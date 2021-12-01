--------------------------------------------------Osoba---------------------------------------------------------------------
set serveroutput  on;
create or replace procedure add_data_osoby
 as
 type t_riadok is record (
    externe_id m_hrac.id%type
 );
 rod_cislo integer;
 
 prikaz varchar2(1000);
 type t_pole is table of t_riadok;
 pole t_pole;
 begin
   rod_cislo  := 900101004;
   select id bulk collect into pole FROM m_hrac;
   for i in 1 .. pole.last 
    loop   
      select 'insert into m_osoba values (''' 
      || pole(i).externe_id || ''', null, ''' 
      || rod_cislo || ''', null, null)'  into prikaz from dual;
      rod_cislo := rod_cislo + 11;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
    end loop;   
 end;
/
--delete  from m_osoba;
--select * from m_osoba;
execute add_data_osoby;

insert into m_osoba values (null, null, '9754082355', null, null);
insert into m_osoba values (null, null, '9704082366', null, null);
insert into m_osoba values (null, null, '9704082377', null, null);
insert into m_osoba values (null, null, '9754082388', null, null);
insert into m_osoba values (null, null, '9704082399', null, null);
insert into m_osoba values (null, null, '9704082410', null, null);
insert into m_osoba values (null, null, '9704082421', null, null);
insert into m_osoba values (null, null, '9754082432', null, null);
insert into m_osoba values (null, null, '9704082443', null, null);
insert into m_osoba values (null, null, '9754082454', null, null);
insert into m_osoba values (null, null, '9704082465', null, null);
insert into m_osoba values (null, null, '9704082476', null, null);
insert into m_osoba values (null, null, '9754082487', null, null);
insert into m_osoba values (null, null, '9754082498', null, null);
insert into m_osoba values (null, null, '9754082509', null, null);
insert into m_osoba values (null, null, '9704082520', null, null);
insert into m_osoba values (null, null, '9704082531', null, null);



--------------------------------------------------Poistovna---------------------------------------------------------------------
insert into m_poistovna values (null, 'ALLIANZ - Slovenská poisovòa a. s.',50274235);
insert into m_poistovna values (null, 'AXA poisovòa a.s. poboèka poisovne z iného èlenského štátu',40556518);
insert into m_poistovna values (null, 'ÈSOB Poisovòa a.s.',50256209);
insert into m_poistovna values (null, 'GENERALI Poisovòa a. s.',55842570);
insert into m_poistovna values (null, 'GENERALI Poisovòa a. s. odštepnı závod Genertel.',749897);
insert into m_poistovna values (null, 'GROUPAMA poisovòa a. s. poboèka poisovne z iného èlenského štátu',39509328);
insert into m_poistovna values (null, 'GENERALI Poisovòa a. s. odštepnı závod Európska cestovná poisovòa',34718090);
insert into m_poistovna values (null, 'KOMUNÁLNA poisovòa a.s. Vienna Insurance Group',39323152);
insert into m_poistovna values (null, 'KOOPERATIVA poisovòa a.s. Vienna Insurance Group',40114038);
insert into m_poistovna values (null, 'NOVIS Poisovòa a.s.',34818144);
insert into m_poistovna values (null, 'UNIQA poisovòa a.s.',34462129);
insert into m_poistovna values (null, 'UNION poisovòa a. s.',49792960);
insert into m_poistovna values (null, 'WüSTENROT poisovòa a.s.',34880173);

-----------------------------------------------------m_specializacia-------------------------------------------------------------------
insert into m_specializacia(nazov, popis) values ('vnútorné lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('infektológia', null);
insert into m_specializacia(nazov, popis) values ('pneumológia a ftizeológia', null);
insert into m_specializacia(nazov, popis) values ('neurológia', null);
insert into m_specializacia(nazov, popis) values ('psychiatria', null);
insert into m_specializacia(nazov, popis) values ('pracovné lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('pediatria', null);
insert into m_specializacia(nazov, popis) values ('všeobecná starostlivos? o deti a dorast', null);
insert into m_specializacia(nazov, popis) values ('gynekológia a pôrodníctvo', null);
insert into m_specializacia(nazov, popis) values ('chirurgia', null);
insert into m_specializacia(nazov, popis) values ('ortopédia', null);
insert into m_specializacia(nazov, popis) values ('urológia', null);
insert into m_specializacia(nazov, popis) values ('úrazová chirurgia', null);
insert into m_specializacia(nazov, popis) values ('otorinolaryngológia', null);
insert into m_specializacia(nazov, popis) values ('oftalmológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická gynekológia', null);
insert into m_specializacia(nazov, popis) values ('dermatovenerológia', null);
insert into m_specializacia(nazov, popis) values ('klinická onkológia', null);
insert into m_specializacia(nazov, popis) values ('všeobecné lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('dorastové lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('rádiológia', null);
insert into m_specializacia(nazov, popis) values ('klinická biochémia', null);
insert into m_specializacia(nazov, popis) values ('anestéziológia a intenzívna medicína', null);
insert into m_specializacia(nazov, popis) values ('telovıchovné lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('fyziatria balneológia a lieèebná rehabilitácia', null);
insert into m_specializacia(nazov, popis) values ('súdne lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('patologická anatómia', null);
insert into m_specializacia(nazov, popis) values ('hematológia a transfuziológia', null);
insert into m_specializacia(nazov, popis) values ('urgentná medicína', null);
insert into m_specializacia(nazov, popis) values ('klinická mikrobiológia', null);
insert into m_specializacia(nazov, popis) values ('neurochirurgia', null);
insert into m_specializacia(nazov, popis) values ('plastická chirurgia', null);
insert into m_specializacia(nazov, popis) values ('ortopedická protetika', null);
insert into m_specializacia(nazov, popis) values ('klinická imunológia a alergológia', null);
insert into m_specializacia(nazov, popis) values ('radiaèná onkológia', null);
insert into m_specializacia(nazov, popis) values ('foniatria', null);
insert into m_specializacia(nazov, popis) values ('reumatológia', null);
insert into m_specializacia(nazov, popis) values ('algeziológia', null);
insert into m_specializacia(nazov, popis) values ('nukleárna medicína', null);
insert into m_specializacia(nazov, popis) values ('gastroenterológia', null);
insert into m_specializacia(nazov, popis) values ('kardiológia', null);
insert into m_specializacia(nazov, popis) values ('diabetológia poruchy látkovej premeny a vıivy', null);
insert into m_specializacia(nazov, popis) values ('neonatológia', null);
insert into m_specializacia(nazov, popis) values ('hygiena detí a mládee', null);
insert into m_specializacia(nazov, popis) values ('angiológia', null);
insert into m_specializacia(nazov, popis) values ('hygiena ivotného prostredia', null);
insert into m_specializacia(nazov, popis) values ('hygiena vıivy', null);
insert into m_specializacia(nazov, popis) values ('epidemiológia', null);
insert into m_specializacia(nazov, popis) values ('geriatria', null);
insert into m_specializacia(nazov, popis) values ('medicínska informatika a bioštatistika', null);
insert into m_specializacia(nazov, popis) values ('lekárska genetika', null);
insert into m_specializacia(nazov, popis) values ('nefrológia', null);
insert into m_specializacia(nazov, popis) values ('endokrinológia', null);
insert into m_specializacia(nazov, popis) values ('klinická farmakológia', null);
insert into m_specializacia(nazov, popis) values ('zdravotnícka informatika', null);
insert into m_specializacia(nazov, popis) values ('gynekologická sexuológia', null);
insert into m_specializacia(nazov, popis) values ('cievna chirurgia', null);
insert into m_specializacia(nazov, popis) values ('kardiochirurgia', null);
insert into m_specializacia(nazov, popis) values ('maxilofaciálna chirurgia', null);
insert into m_specializacia(nazov, popis) values ('medicína drogovıch závislostí', null);
insert into m_specializacia(nazov, popis) values ('gerontopsychiatria', null);
insert into m_specializacia(nazov, popis) values ('letecké lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('lekár bez špecializácie', null);
insert into m_specializacia(nazov, popis) values ('lekár predpisujúci lieky pre seba a osoby blízke', null);
insert into m_specializacia(nazov, popis) values ('posudkové lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('ochrana zdravia pred ionizujúcim iarením', null);
insert into m_specializacia(nazov, popis) values ('pediatrická neurológia', null);
insert into m_specializacia(nazov, popis) values ('detská psychiatria', null);
insert into m_specializacia(nazov, popis) values ('hrudníková chirurgia', null);
insert into m_specializacia(nazov, popis) values ('detská chirurgia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická ortopédia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická urológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická otorinolaryngológia', null);
insert into m_specializacia(nazov, popis) values ('materno', null);
insert into m_specializacia(nazov, popis) values ('vıchova k zdraviu', null);
insert into m_specializacia(nazov, popis) values ('pediatrická imunológia a alergiológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická reumatológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická endokrinológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická gastroenterológia hepatológia a vıiva', null);
insert into m_specializacia(nazov, popis) values ('pediatrická kardiológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická pneumológia a ftizeológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická nefrológia', null);
insert into m_specializacia(nazov, popis) values ('hepatológia', null);
insert into m_specializacia(nazov, popis) values ('gastroenterologická chirurgia', null);
insert into m_specializacia(nazov, popis) values ('neuropsychiatria', null);
insert into m_specializacia(nazov, popis) values ('laboratórna medicína', null);
insert into m_specializacia(nazov, popis) values ('tropická medicína', null);
insert into m_specializacia(nazov, popis) values ('verejné zdravotníctvo', null);
insert into m_specializacia(nazov, popis) values ('onkológia v gynekológii', null);
insert into m_specializacia(nazov, popis) values ('psychosomatická a behaviorálna medicína', null);
insert into m_specializacia(nazov, popis) values ('ultrazvuk v gynekológii a pôrodníctve', null);
insert into m_specializacia(nazov, popis) values ('špeciálne laboratórne a diagnostické metódy v hematológii a transfúziológii', null);
insert into m_specializacia(nazov, popis) values ('mamológia', null);
insert into m_specializacia(nazov, popis) values ('reprodukèná medicína', null);
insert into m_specializacia(nazov, popis) values ('akupunktúra', null);
insert into m_specializacia(nazov, popis) values ('andrológia', null);
insert into m_specializacia(nazov, popis) values ('klinické pracovné lekárstvo a klinická toxikológia', null);
insert into m_specializacia(nazov, popis) values ('gynekologická urológia', null);
insert into m_specializacia(nazov, popis) values ('onkológia v chirurgii', null);
insert into m_specializacia(nazov, popis) values ('onkológia v urológii', null);
insert into m_specializacia(nazov, popis) values ('pediatrická anestéziológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická hematológia a onkológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická infektológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická intenzívna medicína', null);
insert into m_specializacia(nazov, popis) values ('paliatívna medicína', null);
insert into m_specializacia(nazov, popis) values ('pediatrická oftalmológia', null);
insert into m_specializacia(nazov, popis) values ('sexuológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická urgentná medicína', null);
insert into m_specializacia(nazov, popis) values ('zdravotnícka ekológia', null);
insert into m_specializacia(nazov, popis) values ('revízne lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('preventívne pracovné lekárstvo a toxikológia', null);
insert into m_specializacia(nazov, popis) values ('psychiatrická sexuológia', null);
insert into m_specializacia(nazov, popis) values ('sluby zdravia pri práci', null);
insert into m_specializacia(nazov, popis) values ('študijnı odbor všeobecné lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('študijnı odbor detské lekárstvo', null);

