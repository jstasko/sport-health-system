set SERVEROUTPUT ON;

create or replace function m_generuj_char(min_hranica integer, max_hranica integer)
 return varchar2
 as
 hodnota varchar2(450);
 velkost integer;
 begin 
  velkost := dbms_random.value(min_hranica, max_hranica);
  hodnota := dbms_random.string('a', velkost);
  return hodnota;
end;
/

create or replace procedure m_generuj_data_krajina(pocet_dat integer)
 as 
 type t_rec is record
 (
  id_krajiny m_krajina.id_krajiny%type,
  n_krajiny m_krajina.n_krajiny%type
 );
 rec t_rec;
 prikaz varchar2(10000);
 pocet integer;
 begin
  select count(*) + 1 into pocet from m_krajina;
  for i in pocet .. pocet_dat
   loop
    select 'insert into m_krajina (id_krajiny, n_krajiny) values (' || i || ',''' || to_char(m_generuj_char(2, 10))  || ''')' into prikaz from dual;
    dbms_output.put_line(prikaz); 
    execute immediate prikaz;
   end loop;
 end;
/

create or replace procedure m_generuj_data_kraj(pocet_dat integer)
 as 
 type t_rec is record
 (
  n_kraja m_kraj.n_kraja%type,
  id_krajiny m_kraj.n_krajiny%type,
  id_kraja m_kraj.id_kraja%type
 );
 rec t_rec;
 prikaz varchar2(10000);
 pocet integer;
 begin
  select count(*) + 1 into pocet from m_krajina;
  for i in pocet .. pocet_dat
   loop
    select 'insert into m_kraj (n_kraja, id_krajiny, id_kraja) 
     values (' || i || ',''' || to_char(m_generuj_char(2, 10))  || '''
      , )' into prikaz from dual;
    dbms_output.put_line(prikaz); 
    execute immediate prikaz;
   end loop;
 end;
/


select nth_value(id_krajiny, 2) over (order by id_krajiny) from (select id_krajiny from m_krajina);

execute m_generuj_data_krajina(20);

