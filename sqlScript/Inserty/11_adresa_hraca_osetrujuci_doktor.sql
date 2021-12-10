select count(*) from m_zdravotny_zaznam;
-----------------------------------------------------m_adresa_hraca--------------------------------------------------------------------------------------------------------
create or replace procedure gen_adresy_hracov
 as
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
    select 'insert into m_adresa_hraca (id_adresa, rod_cislo) values (''' 
      || get_gen_value('id', 'm_adresa') ||  ''','''
      || pole(i).rod_cislo || ''''
      || ')'
      into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
   end loop;
 end;
/

execute gen_adresy_hracov;


-----------------------------------------------------m_predpisana_liecba--------------------------------------------------------------------------------------------------------
select count(*) from m_predpisana_liecba;
select * from m_predpisana_liecba;
create or replace procedure gen_predpisana_liecba
 as
 prikaz varchar2(10000);
 type t_riadok is record (
    id m_liecba.id%type
 );
 type t_pole is table of t_riadok;
 pole t_pole;
 begin  
  select id bulk collect into pole from m_liecba;
  for i in 101 .. pole.last
   loop
    prikaz := '';
    select 'insert into m_predpisana_liecba (id_zdravotna_kara, id_liecba) values ('
      || get_gen_value('id', 'm_zdravotna_karta') ||  ','
      || pole(i).id
      || ')'
      into prikaz from dual;
   --dbms_output.put_line(prikaz);
   execute immediate prikaz;
   end loop;
 end;
/
execute gen_predpisana_liecba;