-----------------------------------------------------m_operacie_pacienta--------------------------------------------------------------------------------------------------------

create or replace procedure gen_operacie_pacienta(pocet integer)
 as
 prikaz varchar2(10000);
 begin  
  for i in 1 .. pocet
   loop
    prikaz := '';
    select 'insert into m_operacie_pacienta (rod_cislo, id_operacia, id_osetrujuci_doktor, popis) values ('''
      || get_gen_value('rod_cislo', 'm_osoba') ||  ''','
      || get_gen_value('id', 'm_operacia') || ','
      || get_gen_value('id', 'm_osetrujuci_doktor') || ', null'
      || ')'
      into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
   end loop;
 end;
/

execute gen_operacie_pacienta(100);

-----------------------------------------------------m_predpisana_liecba--------------------------------------------------------------------------------------------------------

create or replace procedure gen_predpisana_liecba(pocet integer)
 as
 prikaz varchar2(10000);
 begin  
  for i in 1 .. pocet
   loop
    prikaz := '';
    select 'insert into m_predpisana_liecba (id_zdravotna_kara, id_liecba) values ('
      || get_gen_value('id', 'm_zdravotna_karta') ||  ','
      || get_gen_value('id', 'm_liecba')
      || ')'
      into prikaz from dual;
   --dbms_output.put_line(prikaz);
   execute immediate prikaz;
   end loop;
 end;
/

execute gen_predpisana_liecba(100);