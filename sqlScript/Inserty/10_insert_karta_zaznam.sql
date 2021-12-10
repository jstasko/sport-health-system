-----------------------------------------------------m_zdravotna_karta-------------------------------------------------------------
set serveroutput  on;

create or replace procedure add_karty
 as
 velkost integer;
 type t_choroba_popis is varray(3) of varchar(200);
 choroba_popis t_choroba_popis := t_choroba_popis(
    'Infekcia zapríèinená Salmonella typhi. Tyfoidná horúèka',
    'Infekèná enetritída zapríèinená salmonelou. ',
    'Klasická potravinová otrava zapríèinená Clostridium botulinum'
 );
 type t_choroba_nazov is varray(3) of varchar(200);
 choroba_nazov t_choroba_nazov := t_choroba_nazov(
    'Brušný týfus',
    'Salmonelová enteritída',
    'Botulizmus'
 );
 type t_choroba_kod is varray(3) of varchar(6);
 choroba_kod t_choroba_kod := t_choroba_kod(
    'A01.0',
    'A02.0',
    'A05.1'
 );
 type t_riadok is record (
    rod_cislo m_osoba.rod_cislo%type
 );
 prikaz varchar2(1000);
 l_ran_time TIMESTAMP;
 prikaz_choroba varchar2(1000);
 type t_pole is table of t_riadok;
 pole t_pole;
 pocet_chorob integer; 
 pom_id integer;
 pom_velkost integer;
 pom_id_update integer;
 begin 
  velkost := 3;
   select rod_cislo bulk collect into pole FROM m_osoba;
   for i in 1 .. pole.last
    loop   
        prikaz := '';
        pocet_chorob := trunc(dbms_random.value(0, velkost), 0);
        --dbms_output.put_line(pocet_chorob);
        if pocet_chorob = 0 then
          select 'insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, kontraindikacie, datum_zalozenia) values (''' 
          || pole(i).rod_cislo || ''', null, null, null)'  into prikaz from dual;
         -- dbms_output.put_line(prikaz);
          execute immediate prikaz;
        end if;
        if pocet_chorob = 1 then
          select 'insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, kontraindikacie, datum_zalozenia) values (''' 
              || pole(i).rod_cislo || ''', m_t_choroba(new m_rec_choroba( ''' 
              || to_char(choroba_popis(trunc(dbms_random.value(1, velkost), 0))) || ''', '''
              || to_char(choroba_nazov(trunc(dbms_random.value(1, velkost), 0))) || ''', '''
              || to_char(choroba_kod(trunc(dbms_random.value(1, velkost), 0))) || '''
          )), null, null)'  into prikaz from dual;
          --dbms_output.put_line(prikaz);
          execute immediate prikaz;
        end if;
        if pocet_chorob > 1 then 
            select 'insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, kontraindikacie, datum_zalozenia) values (''' 
              || pole(i).rod_cislo || ''', m_t_choroba(new m_rec_choroba( ''' 
              || to_char(choroba_popis(trunc(dbms_random.value(1, velkost), 0))) || ''', '''
              || to_char(choroba_nazov(trunc(dbms_random.value(1, velkost), 0))) || ''', '''
              || to_char(choroba_kod(trunc(dbms_random.value(1, velkost), 0))) || '''
          )), null, null)'  into prikaz from dual;
          --dbms_output.put_line(prikaz);
          execute immediate prikaz;
          for j in 1 .. pocet_chorob
          loop
            prikaz_choroba := '';
            select max(id) into pom_id from m_zdravotna_karta;
            select  'insert into table (select m_t_choroby_informacie from M_ZDRAVOTNA_KARTA where id = ' || pom_id  || ')
              values ( new m_rec_choroba(''' 
                  ||  to_char(choroba_popis(trunc(dbms_random.value(1, velkost), 0))) || ''',''' 
                  ||  to_char(choroba_nazov(trunc(dbms_random.value(1, velkost), 0))) || ''',''' 
                  || to_char(choroba_kod(trunc(dbms_random.value(1, velkost), 0))) 
                  || '''))'
               into prikaz_choroba from dual;
               --dbms_output.put_line(prikaz_choroba);
               execute immediate prikaz_choroba;
          end loop;
        end if;
    end loop;   
    select count(*) into pom_velkost from m_zdravotna_karta;
    select min(id) into pom_id_update from m_zdravotna_karta;
    for k in 1 .. pom_velkost
        loop
       SELECT
        CURRENT_TIMESTAMP -
        numToDSInterval(dbms_random.value(1, 24*60*60 * 24 * 10 * 10), 'second')
            INTO l_ran_time
        FROM dual;    
        update m_zdravotna_karta  
         set DATUM_ZALOZENIA = l_ran_time     
          where id = pom_id_update;
          pom_id_update := pom_id_update + 1;
      end loop;
 end;
/


execute add_karty;

-----------------------------------------------------m_zdravotny_zaznam-------------------------------------------------------------
create or replace procedure gen_zdravotny_zaznam(pocet integer)
 as
 type t_stavy is varray(4) of varchar(20);
 stavy t_stavy := t_stavy('zapisany', 'diagnostikovany', 'vylieceny', 'nevylieceny');
 prikaz varchar2(10000);
 l_ran_time TIMESTAMP;
 begin  
  for i in 1 .. pocet
   loop
    prikaz := '';
    select 'insert into m_zdravotny_zaznam (id_doktor, rod_cislo, id_institut, id_zdravotny_karta, datum_prehliadky, stav) values (''' 
      || get_gen_value('id', 'm_doktor') ||  ''','''
      || get_gen_value('rod_cislo', 'm_osoba') || ''', '
      || get_gen_value('id', 'm_institut') ||  ', ' 
	  || get_gen_value('id', 'm_zdravotna_karta') ||  ', ' 
      || 'null' || ','''
      || to_char(stavy(trunc(dbms_random.value(1, 4), 0))) || '''' 
      || ')'
      into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
   end loop;
  for i in 1 .. pocet
   loop
       SELECT
        CURRENT_TIMESTAMP -
        numToDSInterval(dbms_random.value(1, 24*60*60 * 24 * 10 * 10), 'second')
            INTO l_ran_time
        FROM dual;    
        update m_zdravotny_zaznam  
         set DATUM_PREHLIADKY = l_ran_time     
          where id = i;
      end loop;
 end;
/

execute gen_zdravotny_zaznam(100);

