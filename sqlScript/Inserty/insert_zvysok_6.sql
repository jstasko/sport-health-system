set SERVEROUTPUT ON;
-----------------------------------------------------m_krvna_skupina-------------------------------------------------------------------
create or replace procedure gen_krvne_skupiny
 as
 type t_krvna_skupina is varray(8) of varchar(3);
 krvna_skupina t_krvna_skupina := t_krvna_skupina('AB+', 'AB-', 'B+', 'B-', 'A+', 'A-', '0+', '0-');
 type t_rha is varray(2) of varchar(3);
 rha t_rha := t_rha ('rh+', 'rh-');
 prikaz varchar2(10000);
 pocet integer;
 type t_riadok is record (
    rod_cislo m_osoba.ROD_CISLO%type
 );
 type t_pole is table of t_riadok;
 pole t_pole;
 begin  
  select rod_cislo bulk collect into pole from m_osoba;
  for i in pole.first .. pole.last
   loop
    prikaz := '';
    
    select 'insert into m_krvna_skupina (rod_cislo, auto) values (''' 
      || pole(i).rod_cislo
      ||  ''',new m_krv('''   
      || to_char(krvna_skupina(trunc(dbms_random.value(1, 8), 0))) || ''',''' 
      || to_char(rha(trunc(dbms_random.value(1, 2), 0))) || '''' 
      || '))'
      into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
   end loop;
 end;
/

execute gen_krvne_skupiny;


-----------------------------------------------------m_vlastnosti-------------------------------------------------------------------

create or replace procedure gen_vlastnosti
 as 
 hmotnost float;
 vyska float;
 prikaz varchar2(10000);
 type t_riadok is record (
    rod_cislo m_osoba.ROD_CISLO%type
 );
 type t_pole is table of t_riadok;
 pole t_pole;
 begin
  select rod_cislo bulk collect into pole from m_osoba;
  for i in pole.first .. pole.last
   loop
    prikaz := '';
    select trunc(dbms_random.value(50, 100),3) into hmotnost from dual;
    select trunc(dbms_random.value(150, 200),3) into vyska from dual;
    select 'insert into m_vlastnosti_hraca (rod_cislo, auto) values (' 
       || '''' || pole(i).rod_cislo
       || ''', new m_vlastnosti(' 
       || hmotnost || ', '  || vyska 
       || '))'
      into prikaz from dual;
   --dbms_output.put_line(prikaz);
   execute immediate prikaz;
   end loop;
 end;
/

execute gen_vlastnosti;

-----------------------------------------------------m_doktor-------------------------------------------------------------


insert into m_doktor values ('9754082355','Lucia','Astalošová',null,'A64932040');
insert into m_doktor values ('9704082366','Emil','Augustín',null,'A37481001');
insert into m_doktor values ('9704082377','Michal','Augustín',null,'A78485049');
insert into m_doktor values ('9754082388','Pavol','Babinec',null,'A57758009');
insert into m_doktor values ('9704082399','Eva','Babišová',null,'A35887023');
insert into m_doktor values ('9704082410','Pavol','Babjak',null,'A70620247');
insert into m_doktor values ('9704082421','Peter','Babjak',null,'A84940020');
insert into m_doktor values ('9754082432','Eva','Baèinská',null,'A41128154');
insert into m_doktor values ('9704082443','Jana','Baèinská',null,'A52758001');
insert into m_doktor values ('9754082454','Karin','Badíková',null,'B59063016');
insert into m_doktor values ('9704082465','Štefan','Baïura',null,'B91009016');
insert into m_doktor values ('9704082476','Štefan','Bajcar',null,'A90906020');
insert into m_doktor values ('9754082487','Viera','Balážová',null,'A18487801');
insert into m_doktor values ('9754082498','Zuzana','Balážová',null,'A45400801');
insert into m_doktor values ('9754082509','Ivana','Balhárková',null,'A96312801');
insert into m_doktor values ('9704082520','Miroslav','Ballay',null,'B78798016');
insert into m_doktor values ('9704082531','Peter','Ballay',null,'A35092001');



-----------------------------------------------------m_specializacia_lekara-------------------------------------------------------------

create or replace procedure gen_data_specializacia(pocet integer)
 as
 prikaz varchar2(10000);
 begin  
  for i in 1 .. pocet
   loop
    prikaz := '';
    select 'insert into m_specializacia_lekara (id_doktor, id_specializacia) values (' 
      || '''' ||  get_gen_value('id', 'm_doktor') || ''', ' 
      || get_gen_value('id', 'm_specializacia')
      || ')'
      into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
   end loop;
 end;
/

execute gen_data_specializacia(100);

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
 prikaz_choroba varchar2(1000);
 type t_pole is table of t_riadok;
 pole t_pole;
 pocet_chorob integer; 
 pom_id integer;
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
 end;
/

--TODO VYKONAT PRE DATUM TIMESTAMP
delete from m_zdravotna_karta;
execute add_karty;

-----------------------------------------------------m_zdravotny_zaznam-------------------------------------------------------------
create or replace procedure gen_zdravotny_zaznam(pocet integer)
 as
 type t_stavy is varray(4) of varchar(20);
 stavy t_stavy := t_stavy('zapisany', 'diagnostikovany', 'vylieceny', 'nevylieceny');
 prikaz varchar2(10000);
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
    update m_zdravotny_zaznam  
     set DATUM_PREHLIADKY = CURRENT_TIMESTAMP
      where id = i;
  end loop;
 end;
/

execute gen_zdravotny_zaznam(100);


-----------------------------------------------------m_adresa_hraca--------------------------------------------------------------------------------------------------------
create or replace procedure gen_adresy_hracov(pocet integer)
 as
 prikaz varchar2(10000);
 begin  
  for i in 1 .. pocet
   loop
    prikaz := '';
    select 'insert into m_adresa_hraca (id_adresa, rod_cislo) values (''' 
      || get_gen_value('id', 'm_adresa') ||  ''','''
      || get_gen_value('rod_cislo', 'm_osoba') || ''''
      || ')'
      into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
   end loop;
 end;
/

execute gen_adresy_hracov(100);


-----------------------------------------------------m_osetrujuci_doktor--------------------------------------------------------------------------------------------------------

create or replace procedure gen_osetrujucich_doktorov(pocet integer)
 as
 prikaz varchar2(10000);
 begin  
  for i in 1 .. pocet
   loop
    prikaz := '';
    select 'insert into m_osetrujuci_doktor (id_institut, id_doktor) values ('
      || get_gen_value('id', 'm_institut') ||  ','''
      || get_gen_value('id', 'm_doktor') || ''''
      || ')'
      into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
   end loop;
 end;
/

execute gen_osetrujucich_doktorov(100);


