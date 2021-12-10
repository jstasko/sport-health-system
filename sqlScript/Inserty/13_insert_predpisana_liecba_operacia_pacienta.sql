-----------------------------------------------------m_osetrujuci_doktor--------------------------------------------------------------------------------------------------------
select count (*) from m_osetrujuci_doktor;
set SERVEROUTPUT ON;
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

execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
execute gen_osetrujucich_doktorov(1000);
-----------------------------------------------------m_operacie_pacienta--------------------------------------------------------------------------------------------------------

create or replace procedure gen_operacie_pacienta(p_min integer, p_max integer)
 as
 prikaz varchar2(10000);
 type t_riadok is record (
    id m_operacie_pacienta.id%type
 );
 type t_pole is table of t_riadok;
 pole t_pole;
 pocet_doktorov integer;
 begin  
  select id bulk collect into pole from m_osetrujuci_doktor;
  for i in p_min .. p_max
   loop
    prikaz := '';
    select 'insert into m_operacie_pacienta (rod_cislo, id_operacia, id_osetrujuci_doktor, popis) values ('''
      || get_gen_value('rod_cislo', 'm_osoba') ||  ''','
      || get_gen_value('id', 'm_operacia') || ','
      || pole(i).id || ', null'
      || ')'
      into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
   end loop;
 end;
/

execute gen_operacie_pacienta(2001, 3000);
select * from m_operacie_pacienta;