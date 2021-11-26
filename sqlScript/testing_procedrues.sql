set SERVEROUTPUT ON;
declare
 out_id integer; 
begin
 insert_zdravotna_karta(
     '9704082542', 
     'Zhubný nádor bližšie neurèenej sliznice úst.Zhubný nádor vnútorného líca',
     'Zhubný nádor sliznice líca',
     'C06.0',
     1,
     null,
     CURRENT_TIMESTAMP,
     out_id
 );
 dbms_output.put_line(out_id);
end;
/


select * from m_zdravotna_karta;

declare
 out_rod_cislo CHAR(11 BYTE);
 out_hmotnost float(10);
 out_vyska float(10);
begin
 get_vlastnosti_hraca(458, out_rod_cislo, out_hmotnost, out_vyska);
end;
/


declare 
 out_id integer;
begin
 update_zdravotna_karta('3', 'kontraindikacie', 21);
end;
/


declare 
 out_id integer;
begin
 update_zdravotna_karta_timestamp(CURRENT_TIMESTAMP, 'datum_zalozenia', 21);
end;
/

select * from m_zdravotna_karta;

execute insert_zdravotna_karta_choroba('c', 'c', 'C014.0', 23);
execute update_zdravotna_karta_choroba('c', 'popis', 'C013.0', 23);
  select karta."ID", choroby.NAZOV, choroby.popis, choroby.kod
    from "M_ZDRAVOTNA_KARTA" karta, table(karta."M_T_CHOROBY_INFORMACIE") choroby
    WHERE karta."ID" = 23;
    
    select karta.m_t_choroby_informacie
 from M_ZDRAVOTNA_KARTA karta
  ;
  
  
update table(select karta.m_t_choroby_informacie
 from M_ZDRAVOTNA_KARTA karta
  WHERE karta.id = 23 ) choroby
  set choroby.popis = 'c' WHERE choroby.kod = 'C013.0';
  
update table(select karta.m_t_choroby_informacie
 from M_ZDRAVOTNA_KARTA karta
  WHERE karta.id = 23) choroby
  set choroby.nazov = 'V'
  WHERE choroby.kod = 'C014.0';
  
DECLARE
 cur_var SYS_REFCURSOR;
  v_emp_id  varchar2(32767);
BEGIN 
 get_choroby(cur_var, 23);
end;
/