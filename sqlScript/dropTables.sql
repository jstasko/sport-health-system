----tables

drop table m_adresa_hraca;
drop table m_krvna_skupina;
drop table m_operacie_pacienta;
drop table m_osetrujuci_doktor;
drop table m_operacia;
drop table m_poistovna;
drop table m_predpisana_liecba;
drop table m_specializacia_lekara;
drop table m_vlastnosti_hraca;
drop table m_zdravotna_karta;
drop table m_zdravotny_zaznam;
drop table m_liecba;
drop table m_institut;
drop table m_lekaren;
drop table m_liek;
drop table m_vyrobca_liekov;
drop table m_adresa;
drop table m_okres;
drop table m_kraj;
drop table m_krajina;
drop table m_doktor;
drop table m_osoba;
drop table m_pouzivatel;
drop table m_specializacia;
drop table m_hrac;
drop table m_image;


-----------------
---types
drop type m_krv;
drop type m_vlastnosti;
drop type m_t_choroba;
drop type m_rec_choroba;


-----------------
----directory
--TODO NEMAME PRAVA NA TOTO 
/*drop directory m_images_dir;
drop directory m_images_stasko_pdbs_dir;*/

set SERVEROUTPUT ON;

begin 
 dbms_output.put_line('----------------------TRIGGERS--------------------------');
 for i in (select 'drop trigger ' || trigger_name as prikaz from all_triggers  where table_owner = 'STASKO_PDBS' and lower(trigger_name) like 'm_%')
 loop
  dbms_output.put_line(i.prikaz);
  execute immediate i.prikaz;
 end loop;
end;
/

begin 
 dbms_output.put_line('----------------------SEQUENCES--------------------------');
 for i in (select 'drop sequence ' || SEQUENCE_NAME as prikaz from USER_SEQUENCES  where lower(SEQUENCE_NAME) like 'm_%')
 loop
  dbms_output.put_line(i.prikaz);
  execute immediate i.prikaz;
 end loop;
end;
/

set SERVEROUTPUT ON;
begin 
 dbms_output.put_line('----------------------VYPIS--------------------------');
 dbms_output.put_line('TABLES');
 for i in (select 'drop table ' || lower(table_name)  || ';' as prikaz from tabs where lower(table_name) like 'm_%')
 loop
  dbms_output.put_line(i.prikaz);
 end loop;
  dbms_output.put_line('TRIGGERS');
 for i in (select 'drop trigger ' || trigger_name as prikaz from all_triggers  where table_owner = 'STASKO_PDBS' and lower(trigger_name) like 'm_%')
 loop
  dbms_output.put_line(i.prikaz);
 end loop;
  dbms_output.put_line('SEQUENCES');
 for i in (select 'drop sequence ' || SEQUENCE_NAME as prikaz from USER_SEQUENCES  where lower(SEQUENCE_NAME) like 'm_%')
 loop
  dbms_output.put_line(i.prikaz);
 end loop;
 dbms_output.put_line('-----------------------------------------------------');
end;
/


