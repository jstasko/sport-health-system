commit;
--execute gen_data_liecba(1000);
--execute gen_krvne_skupiny(1000);
--execute gen_vlastnosti(1000);
--execute gen_data_specializacia(1000);

---1000000
--execute gen_adresy_hracov(1000);
--execute gen_osetrujucich_doktorov(1000);

--execute gen_zdravotny_zaznam(1000);


--execute gen_operacie_pacienta(2000);





---1000000
--execute gen_predpisana_liecba(1000);

/*
set serveroutput on;
declare 
out_json  CLOB;
idOfPlayer varchar(200) ;
begin
idOfPlayer := '5d658c1686dc8b7238338cc3';
get_js_json(idOfPlayer,out_json);
dbms_output.put_line(out_json);
end;
/

select * from m_osoba;

select a.rod_cislo,  (
 select count(*) from m_hrac hrac where a.externeid = hrac.id)
 from m_osoba a;
 
 
 desc m_osoba;*/