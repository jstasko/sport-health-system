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

execute gen_data_specializacia(10000);

