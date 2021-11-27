create or replace procedure insert_krvna_skupina(
     in_rod_cislo in varchar2,
     in_typ_skupiny in varchar2,
     in_rh_faktor in varchar2,
     out_id out number
    ) as

    newId number;
    begin
        SELECT m_krvna_skupina_seq.nextval
        INTO newId
        FROM dual;

        out_id:= newId;

        insert into M_KRVNA_SKUPINA(rod_cislo,auto, id)
        values (in_rod_cislo,M_KRV(in_typ_skupiny, in_rh_faktor), newId);
        commit;

    end;

create or replace procedure get_krvna_skupina(
    in_id in number,
    out_rod_cislo out varchar2,
    out_typ_skupiny out varchar2,
    out_rh_faktor out varchar2
) as
    begin
        select ma.ROD_CISLO, ma.AUTO.TYP_SKUPINY, ma.AUTO.RH_FAKTOR
        into out_rod_cislo, out_typ_skupiny, out_rh_faktor
        from M_KRVNA_SKUPINA ma
        where ma.ID = in_id;

    end;

create or replace procedure delete_krvna_skupina(in_id in number) as
    begin
        delete from M_KRVNA_SKUPINA where ID = in_id;
        commit;
    end;

create or replace procedure update_krvna_skupina(
    in_id in number,
    in_rod_cislo in varchar2,
    in_typ_skupiny in varchar2,
    in_rh_faktor in varchar2
) as
    begin
        update M_KRVNA_SKUPINA
            set AUTO = M_KRV(in_typ_skupiny, in_rh_faktor), ROD_CISLO = in_rod_cislo
        where ID = in_id;

        commit ;
    end;

--set serveroutput on;
create or replace procedure insert_vlastnosti_hraca(
     in_rod_cislo in varchar2,
     in_hmotnost in float,
     in_vyska in float,
     out_id out number
    ) as

    newId number;
    begin
        SELECT m_vlastnosti_hraca_seq.nextval
        INTO newId
        FROM dual;

        out_id:= newId;

        insert into M_VLASTNOSTI_HRACA(rod_cislo,auto, id)
        values (in_rod_cislo, M_VLASTNOSTI(in_hmotnost, in_vyska), newId);
        commit;

    end;
/

--test 
--declare
--    out_id number(38,0);
--begin
--    insert_vlastnosti_hraca('740422/7776', 100.2, 100.3, out_id);
--end;
--/


create or replace procedure get_vlastnosti_hraca(
    in_id in number,
    out_rod_cislo out varchar2,
    out_hmotnost out float,
    out_vyska out float
) as
    begin
        select va.ROD_CISLO, va.AUTO.HMOTNOST, va.AUTO.VYSKA
        into out_rod_cislo, out_hmotnost, out_vyska
        from M_VLASTNOSTI_HRACA va
        where va.ID = in_id;
--        dbms_output.put_line('Rodne cislo: ' || out_rod_cislo); 
--        dbms_output.put_line('hmotnost: ' || out_hmotnost); 
--        dbms_output.put_line('vyska: ' || out_vyska); 
    end;
/



create or replace procedure delete_vlastnosti_hraca(in_id in number) as
    begin
        delete from M_VLASTNOSTI_HRACA where ID = in_id;
        commit;
    end;
/

create or replace procedure update_vlastnosti_hraca(
    in_id in number,
    in_rod_cislo in varchar2,
    in_hmotnost in varchar2,
    in_vyska in varchar2
) as
    begin
        update M_VLASTNOSTI_HRACA
            set AUTO = M_VLASTNOSTI(in_hmotnost, in_vyska), ROD_CISLO = in_rod_cislo
        where ID = in_id;

        commit ;
    end;
/ 


-----------------------------------------------------m_zdravotna_karta---------------------------------------------------
----------------------INSERT-------------------------------
create or replace procedure insert_zdravotna_karta (    
    in_rod_cislo in varchar,                      
    in_popis in varchar2,     
    in_nazov in varchar2,     
    in_kod in varchar,     
    in_id_zdravotny_zaznam in varchar,
    in_kontraindikacie in varchar,           
    in_datum_zalozenia in timestamp,
    out_id out number
 )
 as 
 begin   
  insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) 
   values (in_rod_cislo, m_t_choroba(new m_rec_choroba(in_popis, in_nazov, in_kod)),in_id_zdravotny_zaznam,in_kontraindikacie,in_datum_zalozenia);
   commit;
   SELECT max(id)
        INTO out_id
        FROM m_zdravotna_karta;  
 end;
/


create or replace procedure insert_zdravotna_karta_choroba (
    in_popis varchar2,
    in_nazov varchar2,
    in_kod varchar2,
    in_id integer
 )
 as
   prikaz varchar2(10000);
 begin 
  select  'insert into table (select m_t_choroby_informacie from M_ZDRAVOTNA_KARTA where id = ' || in_id  || ') 
  values ( new m_rec_choroba(''' || in_popis || ''',''' || in_nazov ||''',''' || in_kod || '''))' 
   into prikaz from dual;
   execute immediate prikaz;
   commit;
 end;
/
--------------------UPDATE---------------------------------

create or replace procedure update_zdravotna_karta (
    in_nova_hodnota varchar,
    in_nazov_stlpca varchar,
    in_id varchar
 )
 as
  prikaz varchar2(10000);
 begin 
  select 'update m_zdravotna_karta set ' || in_nazov_stlpca || ' = '|| in_nova_hodnota 
   || ' where id = ' || in_id into prikaz from dual;
   execute immediate prikaz;
 end;
/


create or replace procedure update_zdravotna_karta_timestamp (
    in_nova_hodnota timestamp,
    in_nazov_stlpca varchar,
    in_id varchar
 )
 as
 begin 
  update m_zdravotna_karta set datum_zalozenia = in_nova_hodnota 
   where id = in_id;
  commit;
 end;
/

create or replace procedure update_zdravotna_karta_choroba(
    in_nova_hodnota varchar2,
    in_nazov_stlpca varchar2,
    in_kod varchar2,
    in_id varchar2
 )
 as 
 prikaz varchar2(1000);
 begin
  select 'update table(select karta.m_t_choroby_informacie
 from M_ZDRAVOTNA_KARTA karta
  WHERE karta.id = ' || in_id || ' ) choroby
  set choroby.' || in_nazov_stlpca || ' = ''' ||in_nova_hodnota ||
  ''' WHERE choroby.kod = ''' ||  in_kod || ''''  into prikaz from dual; 
  --dbms_output.put_line(prikaz);
  execute immediate prikaz;
 end;
/

----------------------DELETE-------------------------------
create or replace procedure delete_zdravotna_karta(
    in_id integer
 )
 as
 begin 
  delete from M_ZDRAVOTNA_KARTA where ID = in_id;
 end; 
/ 

create or replace procedure delete_zdravotna_karta_choroba(
    in_id integer,
    in_kod varchar2
 )
 as
 begin 
   delete table(select m_t_choroby_informacie from M_ZDRAVOTNA_KARTA where ID = in_id) choroby
   WHERE choroby.kod = in_kod; 
 end; 
/ 

----------------------GET_ALL-------------------------------

create or replace procedure  get_choroby(
    in_out_cursor IN OUT SYS_REFCURSOR,
    int_id in integer
    )
 as
 begin
     open in_out_cursor for
      select choroby.NAZOV, choroby.popis, choroby.kod
        from "M_ZDRAVOTNA_KARTA" karta, table(karta."M_T_CHOROBY_INFORMACIE") choroby
        WHERE karta."ID" = int_id;
 end;
/
-----------------------------------------------------help_procedures---------------------------------------------------
