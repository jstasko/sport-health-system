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
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, kontraindikacie, datum_zalozenia) values ('9707256121', m_t_choroba(new m_rec_choroba('Zhubný nádor bližšie neurèenej sliznice úst.Zhubný nádor vnútorného líca','Zhubný nádor sliznice líca','C06.0')),null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, kontraindikacie, datum_zalozenia) values ('9707256122', m_t_choroba(new m_rec_choroba('Infekcia zapríèinená Salmonella typhi. Tyfoidná horúèka','Brušný týfus','A01.0')),null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, kontraindikacie, datum_zalozenia) values ('9707256123', m_t_choroba(new m_rec_choroba('Infekèná enetritída zapríèinená salmonelou. ','Salmonelová enteritída','A02.0')),null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, kontraindikacie, datum_zalozenia) values ('9707256124', m_t_choroba(new m_rec_choroba('Klasická potravinová otrava zapríèinená Clostridium botulinum','Botulizmus','A05.1')),null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, kontraindikacie, datum_zalozenia) values ('9707256125', m_t_choroba(new m_rec_choroba('Infekcia zapríèinená Salmonella typhi. Tyfoidná horúèka','Brušný týfus','A01.0')),null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, kontraindikacie, datum_zalozenia) values ('9707256121', m_t_choroba(new m_rec_choroba('Infekèná enetritída zapríèinená salmonelou.','Salmonelová enteritída','A02.0')),null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, kontraindikacie, datum_zalozenia) values ('9707256122', m_t_choroba(new m_rec_choroba('Klasická potravinová otrava zapríèinená Clostridium botulinum.','Botulizmus','A05.1')),null,CURRENT_TIMESTAMP);



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


