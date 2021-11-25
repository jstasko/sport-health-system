create or replace function get_gen_value(p_column char, p_table char)
 return varchar
 as
 prikaz varchar2(10000);
 pom varchar2(10000);
 vysledok varchar2(150);
 begin
  vysledok := '';
  select 'select ' || p_column  || ' from ( select ' || p_column || ' from ' || p_table || ' order by DBMS_RANDOM.RANDOM) where rownum = 1'  into prikaz from dual;  
  execute immediate prikaz into vysledok;
  return vysledok;
 end;
/




----------------------------------------------KRAJINA------------------------------------------
--KRAJINA SA INSERTUJE PRI TABLES.SQL

----------------------------------------------Kraj----------------------------------------------
insert into m_kraj(n_kraja, id_krajiny) values ('Bratislavský','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Trnavský','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Trenèiansky','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Nitriansky','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Žilinský','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Banskobystrický','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Prešovský','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Košický','SK');


----------------------------------------------Okres----------------------------------------------
insert into m_okres(n_okresu, id_kraja) values ('Bratislava I',1);
insert into m_okres(n_okresu, id_kraja) values ('Bratislava II',1);
insert into m_okres(n_okresu, id_kraja) values ('Bratislava III',1);
insert into m_okres(n_okresu, id_kraja) values ('Bratislava IV',1);
insert into m_okres(n_okresu, id_kraja) values ('Bratislava V',1);
insert into m_okres(n_okresu, id_kraja) values ('Malacky',1);
insert into m_okres(n_okresu, id_kraja) values ('Pezinok',1);
insert into m_okres(n_okresu, id_kraja) values ('Senec',1);
insert into m_okres(n_okresu, id_kraja) values ('Dunajská Streda',2);
insert into m_okres(n_okresu, id_kraja) values ('Galanta',2);
insert into m_okres(n_okresu, id_kraja) values ('Hlohovec',2);
insert into m_okres(n_okresu, id_kraja) values ('Pieš?any',2);
insert into m_okres(n_okresu, id_kraja) values ('Senica',2);
insert into m_okres(n_okresu, id_kraja) values ('Skalica',2);
insert into m_okres(n_okresu, id_kraja) values ('Trnava',2);
insert into m_okres(n_okresu, id_kraja) values ('Bánovce nad Bebravou',3);
insert into m_okres(n_okresu, id_kraja) values ('Ilava',3);
insert into m_okres(n_okresu, id_kraja) values ('Myjava',3);
insert into m_okres(n_okresu, id_kraja) values ('Nové Mesto nad Váhom',3);
insert into m_okres(n_okresu, id_kraja) values ('Partizánske',3);
insert into m_okres(n_okresu, id_kraja) values ('Považská Bystrica',3);
insert into m_okres(n_okresu, id_kraja) values ('Prievidza',3);
insert into m_okres(n_okresu, id_kraja) values ('Púchov',3);
insert into m_okres(n_okresu, id_kraja) values ('Trenèín',3);
insert into m_okres(n_okresu, id_kraja) values ('Komárno',4);
insert into m_okres(n_okresu, id_kraja) values ('Levice',4);
insert into m_okres(n_okresu, id_kraja) values ('Nitra',4);
insert into m_okres(n_okresu, id_kraja) values ('Nové Zámky',4);
insert into m_okres(n_okresu, id_kraja) values ('Ša¾a',4);
insert into m_okres(n_okresu, id_kraja) values ('Topo¾èany',4);
insert into m_okres(n_okresu, id_kraja) values ('Zlaté Moravce',4);
insert into m_okres(n_okresu, id_kraja) values ('Bytèa',5);
insert into m_okres(n_okresu, id_kraja) values ('Èadca',5);
insert into m_okres(n_okresu, id_kraja) values ('Dolný Kubín',5);
insert into m_okres(n_okresu, id_kraja) values ('Kysucké Nové Mesto',5);
insert into m_okres(n_okresu, id_kraja) values ('Liptovský Mikuláš',5);
insert into m_okres(n_okresu, id_kraja) values ('Martin',5);
insert into m_okres(n_okresu, id_kraja) values ('Námestovo',5);
insert into m_okres(n_okresu, id_kraja) values ('Ružomberok',5);
insert into m_okres(n_okresu, id_kraja) values ('Turèianske Teplice',5);
insert into m_okres(n_okresu, id_kraja) values ('Tvrdošín',5);
insert into m_okres(n_okresu, id_kraja) values ('Žilina',5);
insert into m_okres(n_okresu, id_kraja) values ('Banská Bystrica',6);
insert into m_okres(n_okresu, id_kraja) values ('Banská Štiavnica',6);
insert into m_okres(n_okresu, id_kraja) values ('Brezno',6);
insert into m_okres(n_okresu, id_kraja) values ('Detva',6);
insert into m_okres(n_okresu, id_kraja) values ('Krupina',6);
insert into m_okres(n_okresu, id_kraja) values ('Luèenec',6);
insert into m_okres(n_okresu, id_kraja) values ('Poltár',6);
insert into m_okres(n_okresu, id_kraja) values ('Revúca',6);
insert into m_okres(n_okresu, id_kraja) values ('Rimavská Sobota',6);
insert into m_okres(n_okresu, id_kraja) values ('Ve¾ký Krtíš',6);
insert into m_okres(n_okresu, id_kraja) values ('Zvolen',6);
insert into m_okres(n_okresu, id_kraja) values ('Žarnovica',6);
insert into m_okres(n_okresu, id_kraja) values ('Žiar nad Hronom',6);
insert into m_okres(n_okresu, id_kraja) values ('Bardejov',7);
insert into m_okres(n_okresu, id_kraja) values ('Humenné',7);
insert into m_okres(n_okresu, id_kraja) values ('Kežmarok',7);
insert into m_okres(n_okresu, id_kraja) values ('Levoèa',7);
insert into m_okres(n_okresu, id_kraja) values ('Medzilaborce',7);
insert into m_okres(n_okresu, id_kraja) values ('Poprad',7);
insert into m_okres(n_okresu, id_kraja) values ('Prešov',7);
insert into m_okres(n_okresu, id_kraja) values ('Sabinov',7);
insert into m_okres(n_okresu, id_kraja) values ('Snina',7);
insert into m_okres(n_okresu, id_kraja) values ('Stará ¼ubovòa',7);
insert into m_okres(n_okresu, id_kraja) values ('Stropkov',7);
insert into m_okres(n_okresu, id_kraja) values ('Svidník',7);
insert into m_okres(n_okresu, id_kraja) values ('Vranov nad Top¾ou',7);
insert into m_okres(n_okresu, id_kraja) values ('Gelnica',8);
insert into m_okres(n_okresu, id_kraja) values ('Košice I',8);
insert into m_okres(n_okresu, id_kraja) values ('Košice II',8);
insert into m_okres(n_okresu, id_kraja) values ('Košice III',8);
insert into m_okres(n_okresu, id_kraja) values ('Košice IV',8);
insert into m_okres(n_okresu, id_kraja) values ('Košice - okolie',8);
insert into m_okres(n_okresu, id_kraja) values ('Michalovce',8);
insert into m_okres(n_okresu, id_kraja) values ('Rožòava',8);
insert into m_okres(n_okresu, id_kraja) values ('Sobrance',8);
insert into m_okres(n_okresu, id_kraja) values ('Spišská Nová Ves',8);
insert into m_okres(n_okresu, id_kraja) values ('Trebišov',8);


----------------------------------------------Obce----------------------------------------------
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ábelová',2,23,'529311');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abovce',3,23,'529320');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abrahám',4,23,'529338');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abrahámovce',5,24,'529346');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abrahámovce',6,24,'529354');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Pikovce',7,24,'529362');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abramová',8,25,'529401');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Laclavá',9,25,'529371');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Polerieka',10,25,'529389');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abranovce',11,25,'529397');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Adamovské Kochanovce',12,25,'529419');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Adidovce',13,25,'529427');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Alekšince',14,26,'529435');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Andovce',15,26,'529443');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Andrejová',16,26,'529460');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ardanovce',17,26,'529494');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ardovo',18,27,'507831');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Arnutovce',19,27,'507890');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Báb',20,27,'507954');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Babie',21,27,'507962');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Babín',22,27,'508012');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Babiná',23,27,'508021');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Babindol',24,27,'508039');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Babinec',25,27,'508055');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bacúch',26,27,'508063');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bacúrov',27,27,'504556');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Báè',28,27,'508080');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baèka',29,27,'508161');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baèkov',30,27,'504629');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baèkovík',31,27,'504637');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baïan',32,27,'508195');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bádice',33,27,'504769');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Badín',34,27,'504858');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Báhoò',35,27,'504874');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajany',36,27,'508233');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajè',37,27,'508241');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajerov',38,27,'504947');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajerovce',39,27,'508349');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajka',40,27,'500267');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajtava',41,27,'508365');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baka',42,27,'504980');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baláže',43,27,'508381');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baldovce',44,28,'507806');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Balog nad Ip¾om',45,28,'507849');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baloò',46,28,'507857');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baòa',47,28,'507873');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baòa Lucia',48,28,'507881');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Banka',49,28,'507946');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bánov',50,28,'508047');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bánovce nad Bebravou',51,28,'508101');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Biskupice',52,28,'508179');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Horné Ozorovce',53,28,'508187');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bánovce nad Ondavou',54,28,'508225');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Banská Belá',55,28,'507989');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Banská Bystrica',56,28,'508250');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Banská Štiavnica',57,28,'508268');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Banské',58,28,'508306');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Banský Studenec',59,28,'508314');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bara',60,28,'508322');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Malá Bara',61,29,'507814');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ve¾ká Bara',62,29,'507822');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Barca',63,29,'503681');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bardejov',64,29,'507865');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bardejovská Nová Ves',65,29,'545333');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Dlhá Lúka',66,29,'507903');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bardejovská Zábava',67,29,'503797');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bardejovské Kúpele',68,29,'503801');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bardoòovo',69,29,'503819');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bartošova Lehôtka',70,29,'507911');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bartošovce',71,29,'555487');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baška',72,29,'507938');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baškovce',73,29,'507997');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baškovce',74,29,'555495');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bašovce',75,29,'503851');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Batizovce',76,29,'503894');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bátka',77,29,'508071');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bátorová',78,29,'508098');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bátorove Kosihy',79,29,'508110');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bátovce',80,29,'508136');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Jalakšová',81,29,'582549');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Beckov',82,29,'503983');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Beckovská Vieska',83,29,'508209');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Beharovce',84,29,'508217');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Becherov',85,29,'508276');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Belá',86,29,'508284');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Belá',87,29,'508292');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Kubíková',88,29,'508331');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Belá nad Cirochou',89,29,'555509');


--------------------------------------------Vyrobcovia liekov----------------------------------------------------------------
Insert into m_vyrobca_liekov values ('529311','AGEPHA PHARMA s.r.o. ',45703850);
Insert into m_vyrobca_liekov values ('529320','Alliance Healthcare s.r.o. organizaèná zložka ',36869562);
Insert into m_vyrobca_liekov values ('529338','Allos a.s. ',45687463);
Insert into m_vyrobca_liekov values ('529346','AtB Pharma s.r.o. ',50765973);
Insert into m_vyrobca_liekov values ('529354','BIOMIN a.s. ',681725);
Insert into m_vyrobca_liekov values ('529362','BIONT a.s. ',35917571);
Insert into m_vyrobca_liekov values ('529401','Biotika a.s. ',31561900);
Insert into m_vyrobca_liekov values ('529371','CALENDULA a.s. ',35748320);
Insert into m_vyrobca_liekov values ('529389','DSV Solutions Slovakia s. r. o. ',36467308);
Insert into m_vyrobca_liekov values ('529397','EL spol. s r.o. ',31652859);
Insert into m_vyrobca_liekov values ('529419','EUROFINS BEL/NOVAMANN s.r.o. ',31329209);
Insert into m_vyrobca_liekov values ('529427','Farmácia Martin a.s. ',45266328);
Insert into m_vyrobca_liekov values ('529435','G.V.Pharma a.s. ',31709249);
Insert into m_vyrobca_liekov values ('529443','GALVEX spol. s r.o. ',36049506);
Insert into m_vyrobca_liekov values ('529460','GMP service s.r.o. ',50585789);
Insert into m_vyrobca_liekov values ('529494','hameln rds s. r. o. ',34122885);
Insert into m_vyrobca_liekov values ('507831','HBM Pharma s.r.o. ',31560784);
Insert into m_vyrobca_liekov values ('507890','IMUNA PHARM a.s. ',36473685);
Insert into m_vyrobca_liekov values ('507954','MED - ART spol. s r.o. ',34113924);
Insert into m_vyrobca_liekov values ('507962','MEDIGROUP s. r. o. ',43957773);
Insert into m_vyrobca_liekov values ('508012','MediPharm a.s. ',46147594);
Insert into m_vyrobca_liekov values ('508021','Medirex a.s. ',35766450);
Insert into m_vyrobca_liekov values ('508039','Messer Tatragas spol. s r.o. ',685852);
Insert into m_vyrobca_liekov values ('508055','MIKROCHEM spol. s r.o. ',604496);
Insert into m_vyrobca_liekov values ('508063','Movianto Slovensko s. r. o. ',36868132);
Insert into m_vyrobca_liekov values ('504556','Novartis Slovakia s.r.o. ',36723304);
Insert into m_vyrobca_liekov values ('508080','PHARMA REVOLTA s. r. o. ',52659453);
Insert into m_vyrobca_liekov values ('508161','PHOENIX Zdravotnícke zásobovanie a.s. ',34142941);
Insert into m_vyrobca_liekov values ('504629','RONCOR a.s. ',36323608);
Insert into m_vyrobca_liekov values ('504637','SanaClis s.r.o. ',35804084);
Insert into m_vyrobca_liekov values ('508195','Saneca Pharmaceuticals a. s. ',46833323);
Insert into m_vyrobca_liekov values ('504769','UNIMED PHARMA spol. s r.o. ',31367216);
Insert into m_vyrobca_liekov values ('504858','UNIPHARMA - 1. slovenská lekárnická akciová spoloènos? ',31625657);
Insert into m_vyrobca_liekov values ('504874','VULM s.r.o. ',50094602);
------------------------------------------------------Liek--------------------------------------------------------------------
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (681725,'Milurit30 x 300 mg','metabolické poruchy (dna)');
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (35917571,'Agen 30 x 5 mg','lieèba zvýšeného krvného tlaku a is-chémia myokardu');
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (31561900,'Tritace 30 x 5mg','terapia hypertenzie');
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (35748320,'Enelbin 100 x 100 mg','pri ochoreniach vyvolaných poruchami prekrvenia konèatín a mozgu');
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (36467308,'Coronal 30 x 5mg','pre srdciarov');
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (31652859,'Pamycon 1 f¾aœka','na lieèbu rán, zápalov');

----------------------------------------------------Lekaren-------------------------------------------------------------------
insert into m_lekaren(PSC, nazov)  values ('529311','Lekáreò Dr.Max');
insert into m_lekaren(PSC, nazov)  values ('529320','Lekáreò Medical Park');
insert into m_lekaren(PSC, nazov)  values ('529338','Lekáreò ZDRAVIE');
insert into m_lekaren(PSC, nazov)  values ('529311','Lekáreò VERONIKA');
insert into m_lekaren(PSC, nazov)  values ('529338','Lekáreò PÚPAVA');
insert into m_lekaren(PSC, nazov)  values ('529311','Lekáreò Karpatia');
insert into m_lekaren(PSC, nazov)  values ('529320','Lekáreò na korze');


---------------------------------------------------Institut-------------------------------------------------------------------
insert into m_institut(PSC, nazov, popis) values ('529311','Nemocnica sv. Michala', 'Nemocnica pre pacientov s diabetom');

---------------------------------------------------Liecba-------------------------------------------------------------------

create or replace procedure gen_data_liecba(pocet integer)
 as
 type t_stavy is varray(7) of varchar(20);
 stavy t_stavy := t_stavy('systemova', 'opakovana', 'cielena', 'hormonalna', 'chirurgicka', 'radioterapia', 'imunoterapia');
 prikaz varchar2(10000);
 cena float;
 begin  
  for i in 1 .. pocet
   loop
    prikaz := '';
    select trunc(dbms_random.value(0.01, 9999.99),2) into cena from dual ;
    select 'insert into m_liecba (id_liek, id_lekaren, id_institut, stav, cena) values (' 
      || to_number(get_gen_value('id', 'm_liek')) || ', ' 
      || get_gen_value('id', 'm_lekaren') || ', '
      || get_gen_value('id', 'm_institut') ||  ',''' 
      || to_char(stavy(trunc(dbms_random.value(1, 7), 0))) || ''', ' 
      || cena 
      || ')'
      into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
   end loop;
 end;
/

execute gen_data_liecba(10000);

--------------------------------------------------HRAC---------------------------------------------------------------------
insert into m_hrac values ('Denis', 'ADAM', 'aaaa825986dc8b723831d448');
--------------------------------------------------Operacia---------------------------------------------------------------------
insert into m_operacia(nazov, popis) values ('Operacia kolena', 'Odrezanie jablcka');



--------------------------------------------------Osoba---------------------------------------------------------------------\


create or replace procedure add_data_osoby
 as
 type t_riadok is record (
    rod_cislo KVET3.P_OSOBA_X.ROD_CISLO%type,
    meno KVET3.P_OSOBA_X.MENO%type,
    PRIEZVISKO KVET3.P_OSOBA_X.PRIEZVISKO%TYPE
 );
 prikaz varchar2(1000);
 type t_pole is table of t_riadok;
 pole t_pole;
 begin
   select rod_cislo, meno, PRIEZVISKO bulk collect into pole FROM KVET3.P_OSOBA_X;
   for i in 1 .. pole.last 
    loop 
      select 'insert into m_osoba values (null, null, ''' 
      || pole(i).rod_cislo || ''', ''' 
      || pole(i).meno || ''','''
      || pole(i).PRIEZVISKO 
      || ''')' into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
    end loop;   
 end;
/

execute add_data_osoby;

insert into m_osoba values (null, null, '9704082355', null, null);
insert into m_osoba values (null, null, '9704082366', null, null);
insert into m_osoba values (null, null, '9704082377', null, null);
insert into m_osoba values (null, null, '9704082388', null, null);
insert into m_osoba values (null, null, '9704082399', null, null);
insert into m_osoba values (null, null, '9704082410', null, null);
insert into m_osoba values (null, null, '9704082421', null, null);
insert into m_osoba values (null, null, '9704082432', null, null);
insert into m_osoba values (null, null, '9704082443', null, null);
insert into m_osoba values (null, null, '9704082454', null, null);
insert into m_osoba values (null, null, '9704082465', null, null);
insert into m_osoba values (null, null, '9704082476', null, null);
insert into m_osoba values (null, null, '9704082487', null, null);
insert into m_osoba values (null, null, '9704082498', null, null);
insert into m_osoba values (null, null, '9704082509', null, null);
insert into m_osoba values (null, null, '9704082520', null, null);
insert into m_osoba values (null, null, '9704082531', null, null);
insert into m_osoba values (null, null, '9704082542', null, null);
insert into m_osoba values (null, null, '9704082553', null, null);
insert into m_osoba values (null, null, '9704082564', null, null);
insert into m_osoba values (null, null, '9704082575', null, null);

insert into m_osoba values ('aaaa825986dc8b723831d448', null, '9707256124', null, null);
insert into m_osoba values ('aaaa825986dc8b723831d448', null, '9707256125', null, null);

--------------------------------------------------Poistovna---------------------------------------------------------------------
insert into m_poistovna values (null, 'ALLIANZ - Slovenská pois?ovòa a. s.',50274235);
insert into m_poistovna values (null, 'AXA pois?ovòa a.s. poboèka pois?ovne z iného èlenského štátu',40556518);
insert into m_poistovna values (null, 'ÈSOB Pois?ovòa a.s.',50256209);
insert into m_poistovna values (null, 'GENERALI Pois?ovòa a. s.',55842570);
insert into m_poistovna values (null, 'GENERALI Pois?ovòa a. s. odštepný závod Genertel.',749897);
insert into m_poistovna values (null, 'GROUPAMA pois?ovòa a. s. poboèka pois?ovne z iného èlenského štátu',39509328);
insert into m_poistovna values (null, 'GENERALI Pois?ovòa a. s. odštepný závod Európska cestovná pois?ovòa',34718090);
insert into m_poistovna values (null, 'KOMUNÁLNA pois?ovòa a.s. Vienna Insurance Group',39323152);
insert into m_poistovna values (null, 'KOOPERATIVA pois?ovòa a.s. Vienna Insurance Group',40114038);
insert into m_poistovna values (null, 'NOVIS Pois?ovòa a.s.',34818144);
insert into m_poistovna values (null, 'UNIQA pois?ovòa a.s.',34462129);
insert into m_poistovna values (null, 'UNION pois?ovòa a. s.',49792960);
insert into m_poistovna values (null, 'WüSTENROT pois?ovòa a.s.',34880173);

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
insert into m_specializacia(nazov, popis) values ('telovýchovné lekárstvo', null);
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
insert into m_specializacia(nazov, popis) values ('diabetológia poruchy látkovej premeny a výživy', null);
insert into m_specializacia(nazov, popis) values ('neonatológia', null);
insert into m_specializacia(nazov, popis) values ('hygiena detí a mládeže', null);
insert into m_specializacia(nazov, popis) values ('angiológia', null);
insert into m_specializacia(nazov, popis) values ('hygiena životného prostredia', null);
insert into m_specializacia(nazov, popis) values ('hygiena výživy', null);
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
insert into m_specializacia(nazov, popis) values ('medicína drogových závislostí', null);
insert into m_specializacia(nazov, popis) values ('gerontopsychiatria', null);
insert into m_specializacia(nazov, popis) values ('letecké lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('lekár bez špecializácie', null);
insert into m_specializacia(nazov, popis) values ('lekár predpisujúci lieky pre seba a osoby blízke', null);
insert into m_specializacia(nazov, popis) values ('posudkové lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('ochrana zdravia pred ionizujúcim žiarením', null);
insert into m_specializacia(nazov, popis) values ('pediatrická neurológia', null);
insert into m_specializacia(nazov, popis) values ('detská psychiatria', null);
insert into m_specializacia(nazov, popis) values ('hrudníková chirurgia', null);
insert into m_specializacia(nazov, popis) values ('detská chirurgia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická ortopédia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická urológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická otorinolaryngológia', null);
insert into m_specializacia(nazov, popis) values ('materno', null);
insert into m_specializacia(nazov, popis) values ('výchova k zdraviu', null);
insert into m_specializacia(nazov, popis) values ('pediatrická imunológia a alergiológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická reumatológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická endokrinológia', null);
insert into m_specializacia(nazov, popis) values ('pediatrická gastroenterológia hepatológia a výživa', null);
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
insert into m_specializacia(nazov, popis) values ('služby zdravia pri práci', null);
insert into m_specializacia(nazov, popis) values ('študijný odbor všeobecné lekárstvo', null);
insert into m_specializacia(nazov, popis) values ('študijný odbor detské lekárstvo', null);



-----------------------------------------------------m_krvna_skupina-------------------------------------------------------------------
create or replace procedure gen_krvne_skupiny(pocet integer)
 as
 type t_krvna_skupina is varray(8) of varchar(3);
 krvna_skupina t_krvna_skupina := t_krvna_skupina('AB+', 'AB-', 'B+', 'B-', 'A+', 'A-', '0+', '0-');
 type t_rha is varray(2) of varchar(3);
 rha t_rha := t_rha ('rh+', 'rh-');
 prikaz varchar2(10000);
 begin  
  for i in 1 .. pocet
   loop
    prikaz := '';
    select 'insert into m_krvna_skupina (rod_cislo, auto) values (''' 
      || get_gen_value('rod_cislo', 'm_osoba') 
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

execute gen_krvne_skupiny(10000);


-----------------------------------------------------m_vlastnosti-------------------------------------------------------------------

create or replace procedure gen_vlastnosti(pocet integer)
 as 
 hmotnost float;
 vyska float;
 prikaz varchar2(10000);
 id_hrac m_hrac.id%type;
 begin
  for i in 1 .. pocet
   loop
    prikaz := '';
    select trunc(dbms_random.value(50, 100),3) into hmotnost from dual;
    select trunc(dbms_random.value(150, 200),3) into vyska from dual;
    select 'insert into m_vlastnosti_hraca (rod_cislo, auto) values (' 
       || '''' || (select trim(get_gen_value('rod_cislo', 'm_osoba')) from dual)
       || ''', new m_vlastnosti(' 
       || hmotnost || ', '  || vyska 
       || '))'
      into prikaz from dual;
   --dbms_output.put_line(prikaz);
   execute immediate prikaz;
   end loop;
 end;
/

execute gen_vlastnosti(10000);

-----------------------------------------------------m_doktor-------------------------------------------------------------
insert into m_doktor values ('9704082355','Lucia','Astalošová', null,'A64932040');
insert into m_doktor values ('9704082366','Emil','Augustín', null,'A37481001');
insert into m_doktor values ('9704082377','Michal','Augustín', null,'A78485049');
insert into m_doktor values ('9704082388','Pavol','Babinec', null,'A57758009');
insert into m_doktor values ('9704082399','Eva','Babišová', null,'A35887023');
insert into m_doktor values ('9704082410','Pavol','Babjak', null,'A70620247');
insert into m_doktor values ('9704082421','Peter','Babjak', null,'A84940020');
insert into m_doktor values ('9704082432','Eva','Ba?inská', null,'A41128154');
insert into m_doktor values ('9704082443','Jana','Ba?inská', null,'A52758001');
insert into m_doktor values ('9704082454','Karin','Badíková', null,'B59063016');
insert into m_doktor values ('9704082465','Štefan','Ba?ura', null,'B91009016');
insert into m_doktor values ('9704082476','Štefan','Bajcar', null,'A90906020');
insert into m_doktor values ('9704082487','Viera','Balážová', null,'A18487801');
insert into m_doktor values ('9704082498','Zuzana','Balážová', null,'A45400801');
insert into m_doktor values ('9704082509','Ivana','Balhárková', null,'A96312801');
insert into m_doktor values ('9704082520','Miroslav','Ballay', null,'B78798016');
insert into m_doktor values ('9704082531','Peter','Ballay', null,'A35092001');


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




-----------------------------------------------------m_zdravotny_zaznam-------------------------------------------------------------
create or replace procedure gen_zdravotny_zaznam(pocet integer)
 as
 type t_stavy is varray(4) of varchar(20);
 stavy t_stavy := t_stavy('zapisany', 'diagnostikovany', 'vylieceny', 'nevylieceny');
 prikaz varchar2(10000);
 begin  
  for i in 1 .. pocet
   loop
    prikaz := '';
    select 'insert into m_zdravotny_zaznam (id_doktor, rod_cislo, id_institut, datum_prehliadky, stav) values (''' 
      || get_gen_value('id', 'm_doktor') ||  ''','''
      || get_gen_value('rod_cislo', 'm_osoba') || ''', '
      || get_gen_value('id', 'm_institut') ||  ', ' 
      || 'null' || ','''
      || to_char(stavy(trunc(dbms_random.value(1, 4), 0))) || '''' 
      || ')'
      into prikaz from dual;
    execute immediate prikaz;
   end loop;
  for i in 1 .. pocet
   loop
    update m_zdravotny_zaznam  
     set DATUM_PREHLIADKY = CURRENT_TIMESTAMP
      where id = i;
  end loop;
 end;
/

execute gen_zdravotny_zaznam(10000);

-----------------------------------------------------m_zdravotna_karta-------------------------------------------------------------
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082542', m_t_choroba(new m_rec_choroba('Zhubný nádor bližšie neurèenej sliznice úst.Zhubný nádor vnútorného líca','Zhubný nádor sliznice líca','C06.0')),1,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082553', m_t_choroba(new m_rec_choroba('Infekcia zapríèinená Salmonella typhi. Tyfoidná horúèka','Brušný týfus','A01.0')),2,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082564', m_t_choroba(new m_rec_choroba('Infekèná enetritída zapríèinená salmonelou. ','Salmonelová enteritída','A02.0')),3,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082575', m_t_choroba(new m_rec_choroba('Klasická potravinová otrava zapríèinená Clostridium botulinum','Botulizmus','A05.1')),4,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082542', m_t_choroba(new m_rec_choroba('Infekcia zapríèinená Salmonella typhi. Tyfoidná horúèka','Brušný týfus','A01.0')),5,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082542', m_t_choroba(new m_rec_choroba('Infekèná enetritída zapríèinená salmonelou.','Salmonelová enteritída','A02.0')),6,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082542', m_t_choroba(new m_rec_choroba('Klasická potravinová otrava zapríèinená Clostridium botulinum.','Botulizmus','A05.1')),7,null,CURRENT_TIMESTAMP);

-----------------------------------------------------m_adresa_hraca--------------------------------------------------------------------------------------------------------
create or replace procedure gen_adresy_hracov(pocet integer)
 as
 prikaz varchar2(10000);
 begin  
  for i in 1 .. pocet
   loop
    prikaz := '';
    select 'insert into m_adresa_hraca (PSC, rod_cislo) values (''' 
      || get_gen_value('PSC', 'm_adresa') ||  ''','''
      || get_gen_value('rod_cislo', 'm_osoba') || ''''
      || ')'
      into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
   end loop;
 end;
/

execute gen_adresy_hracov(10000);


-----------------------------------------------------m_osetrujuci_doktor--------------------------------------------------------------------------------------------------------

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

execute gen_operacie_pacienta(10000);

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

execute gen_predpisana_liecba(10000);