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
insert into m_kraj(n_kraja, id_krajiny) values ('Bratislavsk�','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Trnavsk�','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Tren�iansky','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Nitriansky','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('�ilinsk�','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Banskobystrick�','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Pre�ovsk�','SK');
insert into m_kraj(n_kraja, id_krajiny) values ('Ko�ick�','SK');


----------------------------------------------Okres----------------------------------------------
insert into m_okres(n_okresu, id_kraja) values ('Bratislava I',1);
insert into m_okres(n_okresu, id_kraja) values ('Bratislava II',1);
insert into m_okres(n_okresu, id_kraja) values ('Bratislava III',1);
insert into m_okres(n_okresu, id_kraja) values ('Bratislava IV',1);
insert into m_okres(n_okresu, id_kraja) values ('Bratislava V',1);
insert into m_okres(n_okresu, id_kraja) values ('Malacky',1);
insert into m_okres(n_okresu, id_kraja) values ('Pezinok',1);
insert into m_okres(n_okresu, id_kraja) values ('Senec',1);
insert into m_okres(n_okresu, id_kraja) values ('Dunajsk� Streda',2);
insert into m_okres(n_okresu, id_kraja) values ('Galanta',2);
insert into m_okres(n_okresu, id_kraja) values ('Hlohovec',2);
insert into m_okres(n_okresu, id_kraja) values ('Pie�?any',2);
insert into m_okres(n_okresu, id_kraja) values ('Senica',2);
insert into m_okres(n_okresu, id_kraja) values ('Skalica',2);
insert into m_okres(n_okresu, id_kraja) values ('Trnava',2);
insert into m_okres(n_okresu, id_kraja) values ('B�novce nad Bebravou',3);
insert into m_okres(n_okresu, id_kraja) values ('Ilava',3);
insert into m_okres(n_okresu, id_kraja) values ('Myjava',3);
insert into m_okres(n_okresu, id_kraja) values ('Nov� Mesto nad V�hom',3);
insert into m_okres(n_okresu, id_kraja) values ('Partiz�nske',3);
insert into m_okres(n_okresu, id_kraja) values ('Pova�sk� Bystrica',3);
insert into m_okres(n_okresu, id_kraja) values ('Prievidza',3);
insert into m_okres(n_okresu, id_kraja) values ('P�chov',3);
insert into m_okres(n_okresu, id_kraja) values ('Tren��n',3);
insert into m_okres(n_okresu, id_kraja) values ('Kom�rno',4);
insert into m_okres(n_okresu, id_kraja) values ('Levice',4);
insert into m_okres(n_okresu, id_kraja) values ('Nitra',4);
insert into m_okres(n_okresu, id_kraja) values ('Nov� Z�mky',4);
insert into m_okres(n_okresu, id_kraja) values ('�a�a',4);
insert into m_okres(n_okresu, id_kraja) values ('Topo��any',4);
insert into m_okres(n_okresu, id_kraja) values ('Zlat� Moravce',4);
insert into m_okres(n_okresu, id_kraja) values ('Byt�a',5);
insert into m_okres(n_okresu, id_kraja) values ('�adca',5);
insert into m_okres(n_okresu, id_kraja) values ('Doln� Kub�n',5);
insert into m_okres(n_okresu, id_kraja) values ('Kysuck� Nov� Mesto',5);
insert into m_okres(n_okresu, id_kraja) values ('Liptovsk� Mikul�',5);
insert into m_okres(n_okresu, id_kraja) values ('Martin',5);
insert into m_okres(n_okresu, id_kraja) values ('N�mestovo',5);
insert into m_okres(n_okresu, id_kraja) values ('Ru�omberok',5);
insert into m_okres(n_okresu, id_kraja) values ('Tur�ianske Teplice',5);
insert into m_okres(n_okresu, id_kraja) values ('Tvrdo��n',5);
insert into m_okres(n_okresu, id_kraja) values ('�ilina',5);
insert into m_okres(n_okresu, id_kraja) values ('Bansk� Bystrica',6);
insert into m_okres(n_okresu, id_kraja) values ('Bansk� �tiavnica',6);
insert into m_okres(n_okresu, id_kraja) values ('Brezno',6);
insert into m_okres(n_okresu, id_kraja) values ('Detva',6);
insert into m_okres(n_okresu, id_kraja) values ('Krupina',6);
insert into m_okres(n_okresu, id_kraja) values ('Lu�enec',6);
insert into m_okres(n_okresu, id_kraja) values ('Polt�r',6);
insert into m_okres(n_okresu, id_kraja) values ('Rev�ca',6);
insert into m_okres(n_okresu, id_kraja) values ('Rimavsk� Sobota',6);
insert into m_okres(n_okresu, id_kraja) values ('Ve�k� Krt�',6);
insert into m_okres(n_okresu, id_kraja) values ('Zvolen',6);
insert into m_okres(n_okresu, id_kraja) values ('�arnovica',6);
insert into m_okres(n_okresu, id_kraja) values ('�iar nad Hronom',6);
insert into m_okres(n_okresu, id_kraja) values ('Bardejov',7);
insert into m_okres(n_okresu, id_kraja) values ('Humenn�',7);
insert into m_okres(n_okresu, id_kraja) values ('Ke�marok',7);
insert into m_okres(n_okresu, id_kraja) values ('Levo�a',7);
insert into m_okres(n_okresu, id_kraja) values ('Medzilaborce',7);
insert into m_okres(n_okresu, id_kraja) values ('Poprad',7);
insert into m_okres(n_okresu, id_kraja) values ('Pre�ov',7);
insert into m_okres(n_okresu, id_kraja) values ('Sabinov',7);
insert into m_okres(n_okresu, id_kraja) values ('Snina',7);
insert into m_okres(n_okresu, id_kraja) values ('Star� �ubov�a',7);
insert into m_okres(n_okresu, id_kraja) values ('Stropkov',7);
insert into m_okres(n_okresu, id_kraja) values ('Svidn�k',7);
insert into m_okres(n_okresu, id_kraja) values ('Vranov nad Top�ou',7);
insert into m_okres(n_okresu, id_kraja) values ('Gelnica',8);
insert into m_okres(n_okresu, id_kraja) values ('Ko�ice I',8);
insert into m_okres(n_okresu, id_kraja) values ('Ko�ice II',8);
insert into m_okres(n_okresu, id_kraja) values ('Ko�ice III',8);
insert into m_okres(n_okresu, id_kraja) values ('Ko�ice IV',8);
insert into m_okres(n_okresu, id_kraja) values ('Ko�ice - okolie',8);
insert into m_okres(n_okresu, id_kraja) values ('Michalovce',8);
insert into m_okres(n_okresu, id_kraja) values ('Ro��ava',8);
insert into m_okres(n_okresu, id_kraja) values ('Sobrance',8);
insert into m_okres(n_okresu, id_kraja) values ('Spi�sk� Nov� Ves',8);
insert into m_okres(n_okresu, id_kraja) values ('Trebi�ov',8);


----------------------------------------------Obce----------------------------------------------
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('�belov�',2,23,'529311');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abovce',3,23,'529320');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abrah�m',4,23,'529338');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abrah�movce',5,24,'529346');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abrah�movce',6,24,'529354');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Pikovce',7,24,'529362');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abramov�',8,25,'529401');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Laclav�',9,25,'529371');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Polerieka',10,25,'529389');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Abranovce',11,25,'529397');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Adamovsk� Kochanovce',12,25,'529419');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Adidovce',13,25,'529427');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Alek�ince',14,26,'529435');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Andovce',15,26,'529443');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Andrejov�',16,26,'529460');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ardanovce',17,26,'529494');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ardovo',18,27,'507831');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Arnutovce',19,27,'507890');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B�b',20,27,'507954');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Babie',21,27,'507962');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bab�n',22,27,'508012');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Babin�',23,27,'508021');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Babindol',24,27,'508039');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Babinec',25,27,'508055');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bac�ch',26,27,'508063');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bac�rov',27,27,'504556');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B��',28,27,'508080');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ba�ka',29,27,'508161');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ba�kov',30,27,'504629');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ba�kov�k',31,27,'504637');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ba�an',32,27,'508195');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B�dice',33,27,'504769');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bad�n',34,27,'504858');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B�ho�',35,27,'504874');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajany',36,27,'508233');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baj�',37,27,'508241');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajerov',38,27,'504947');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajerovce',39,27,'508349');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajka',40,27,'500267');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bajtava',41,27,'508365');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baka',42,27,'504980');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bal�e',43,27,'508381');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Baldovce',44,28,'507806');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Balog nad Ip�om',45,28,'507849');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Balo�',46,28,'507857');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ba�a',47,28,'507873');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ba�a Lucia',48,28,'507881');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Banka',49,28,'507946');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B�nov',50,28,'508047');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B�novce nad Bebravou',51,28,'508101');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Biskupice',52,28,'508179');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Horn� Ozorovce',53,28,'508187');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B�novce nad Ondavou',54,28,'508225');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bansk� Bel�',55,28,'507989');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bansk� Bystrica',56,28,'508250');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bansk� �tiavnica',57,28,'508268');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bansk�',58,28,'508306');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bansk� Studenec',59,28,'508314');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bara',60,28,'508322');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Mal� Bara',61,29,'507814');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ve�k� Bara',62,29,'507822');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Barca',63,29,'503681');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bardejov',64,29,'507865');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bardejovsk� Nov� Ves',65,29,'545333');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Dlh� L�ka',66,29,'507903');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bardejovsk� Z�bava',67,29,'503797');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bardejovsk� K�pele',68,29,'503801');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bardo�ovo',69,29,'503819');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Barto�ova Leh�tka',70,29,'507911');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Barto�ovce',71,29,'555487');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ba�ka',72,29,'507938');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ba�kovce',73,29,'507997');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ba�kovce',74,29,'555495');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Ba�ovce',75,29,'503851');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Batizovce',76,29,'503894');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B�tka',77,29,'508071');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B�torov�',78,29,'508098');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B�torove Kosihy',79,29,'508110');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('B�tovce',80,29,'508136');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Jalak�ov�',81,29,'582549');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Beckov',82,29,'503983');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Beckovsk� Vieska',83,29,'508209');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Beharovce',84,29,'508217');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Becherov',85,29,'508276');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bel�',86,29,'508284');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bel�',87,29,'508292');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Kub�kov�',88,29,'508331');
insert into m_adresa(n_mesta, cislo_domu, id_okresu, psc) values ('Bel� nad Cirochou',89,29,'555509');


--------------------------------------------Vyrobcovia liekov----------------------------------------------------------------
Insert into m_vyrobca_liekov values ('529311','AGEPHA PHARMA s.r.o.�',45703850);
Insert into m_vyrobca_liekov values ('529320','Alliance Healthcare s.r.o. organiza�n� zlo�ka�',36869562);
Insert into m_vyrobca_liekov values ('529338','Allos a.s.�',45687463);
Insert into m_vyrobca_liekov values ('529346','AtB Pharma s.r.o.�',50765973);
Insert into m_vyrobca_liekov values ('529354','BIOMIN a.s.�',681725);
Insert into m_vyrobca_liekov values ('529362','BIONT a.s.�',35917571);
Insert into m_vyrobca_liekov values ('529401','Biotika a.s.�',31561900);
Insert into m_vyrobca_liekov values ('529371','CALENDULA a.s.�',35748320);
Insert into m_vyrobca_liekov values ('529389','DSV Solutions Slovakia s. r. o.�',36467308);
Insert into m_vyrobca_liekov values ('529397','EL spol. s r.o.�',31652859);
Insert into m_vyrobca_liekov values ('529419','EUROFINS BEL/NOVAMANN s.r.o.�',31329209);
Insert into m_vyrobca_liekov values ('529427','Farm�cia Martin a.s.�',45266328);
Insert into m_vyrobca_liekov values ('529435','G.V.Pharma a.s.�',31709249);
Insert into m_vyrobca_liekov values ('529443','GALVEX spol. s r.o.�',36049506);
Insert into m_vyrobca_liekov values ('529460','GMP service s.r.o.�',50585789);
Insert into m_vyrobca_liekov values ('529494','hameln rds s. r. o.�',34122885);
Insert into m_vyrobca_liekov values ('507831','HBM Pharma s.r.o.�',31560784);
Insert into m_vyrobca_liekov values ('507890','IMUNA PHARM a.s.�',36473685);
Insert into m_vyrobca_liekov values ('507954','MED - ART spol. s r.o.�',34113924);
Insert into m_vyrobca_liekov values ('507962','MEDIGROUP s. r. o.�',43957773);
Insert into m_vyrobca_liekov values ('508012','MediPharm a.s.�',46147594);
Insert into m_vyrobca_liekov values ('508021','Medirex a.s.�',35766450);
Insert into m_vyrobca_liekov values ('508039','Messer Tatragas spol. s r.o.�',685852);
Insert into m_vyrobca_liekov values ('508055','MIKROCHEM spol. s r.o.�',604496);
Insert into m_vyrobca_liekov values ('508063','Movianto Slovensko s. r. o.�',36868132);
Insert into m_vyrobca_liekov values ('504556','Novartis Slovakia s.r.o.�',36723304);
Insert into m_vyrobca_liekov values ('508080','PHARMA REVOLTA s. r. o.�',52659453);
Insert into m_vyrobca_liekov values ('508161','PHOENIX Zdravotn�cke z�sobovanie a.s.�',34142941);
Insert into m_vyrobca_liekov values ('504629','RONCOR a.s.�',36323608);
Insert into m_vyrobca_liekov values ('504637','SanaClis s.r.o.�',35804084);
Insert into m_vyrobca_liekov values ('508195','Saneca Pharmaceuticals a. s.�',46833323);
Insert into m_vyrobca_liekov values ('504769','UNIMED PHARMA spol. s r.o.�',31367216);
Insert into m_vyrobca_liekov values ('504858','UNIPHARMA - 1. slovensk� lek�rnick� akciov� spolo�nos?�',31625657);
Insert into m_vyrobca_liekov values ('504874','VULM s.r.o.�',50094602);
------------------------------------------------------Liek--------------------------------------------------------------------
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (681725,'Milurit30 x 300 mg','metabolick� poruchy (dna)');
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (35917571,'Agen 30 x 5 mg','lie�ba zv��en�ho krvn�ho tlaku a is-ch�mia myokardu');
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (31561900,'Tritace 30 x 5mg','terapia hypertenzie');
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (35748320,'Enelbin 100 x 100 mg','pri ochoreniach vyvolan�ch poruchami prekrvenia kon�at�n a mozgu');
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (36467308,'Coronal 30 x 5mg','pre srdciarov');
insert into m_liek(id_vyrobca_liekov, nazov, popis) values (31652859,'Pamycon 1 f�a�ka','na lie�bu r�n, z�palov');

----------------------------------------------------Lekaren-------------------------------------------------------------------
insert into m_lekaren(PSC, nazov)  values ('529311','Lek�re� Dr.Max');
insert into m_lekaren(PSC, nazov)  values ('529320','Lek�re� Medical Park');
insert into m_lekaren(PSC, nazov)  values ('529338','Lek�re� ZDRAVIE');
insert into m_lekaren(PSC, nazov)  values ('529311','Lek�re� VERONIKA');
insert into m_lekaren(PSC, nazov)  values ('529338','Lek�re� P�PAVA');
insert into m_lekaren(PSC, nazov)  values ('529311','Lek�re� Karpatia');
insert into m_lekaren(PSC, nazov)  values ('529320','Lek�re� na korze');


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
insert into m_poistovna values (null, 'ALLIANZ - Slovensk� pois?ov�a a. s.',50274235);
insert into m_poistovna values (null, 'AXA pois?ov�a a.s. pobo�ka pois?ovne z in�ho �lensk�ho �t�tu',40556518);
insert into m_poistovna values (null, '�SOB Pois?ov�a a.s.',50256209);
insert into m_poistovna values (null, 'GENERALI Pois?ov�a a. s.',55842570);
insert into m_poistovna values (null, 'GENERALI Pois?ov�a a. s. od�tepn� z�vod Genertel.',749897);
insert into m_poistovna values (null, 'GROUPAMA pois?ov�a a. s. pobo�ka pois?ovne z in�ho �lensk�ho �t�tu',39509328);
insert into m_poistovna values (null, 'GENERALI Pois?ov�a a. s. od�tepn� z�vod Eur�pska cestovn� pois?ov�a',34718090);
insert into m_poistovna values (null, 'KOMUN�LNA pois?ov�a a.s. Vienna Insurance Group',39323152);
insert into m_poistovna values (null, 'KOOPERATIVA pois?ov�a a.s. Vienna Insurance Group',40114038);
insert into m_poistovna values (null, 'NOVIS Pois?ov�a a.s.',34818144);
insert into m_poistovna values (null, 'UNIQA pois?ov�a a.s.',34462129);
insert into m_poistovna values (null, 'UNION pois?ov�a a. s.',49792960);
insert into m_poistovna values (null, 'W�STENROT pois?ov�a a.s.',34880173);

-----------------------------------------------------m_specializacia-------------------------------------------------------------------
insert into m_specializacia(nazov, popis) values ('vn�torn� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('infektol�gia', null);
insert into m_specializacia(nazov, popis) values ('pneumol�gia a ftizeol�gia', null);
insert into m_specializacia(nazov, popis) values ('neurol�gia', null);
insert into m_specializacia(nazov, popis) values ('psychiatria', null);
insert into m_specializacia(nazov, popis) values ('pracovn� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('pediatria', null);
insert into m_specializacia(nazov, popis) values ('v�eobecn� starostlivos? o deti a dorast', null);
insert into m_specializacia(nazov, popis) values ('gynekol�gia a p�rodn�ctvo', null);
insert into m_specializacia(nazov, popis) values ('chirurgia', null);
insert into m_specializacia(nazov, popis) values ('ortop�dia', null);
insert into m_specializacia(nazov, popis) values ('urol�gia', null);
insert into m_specializacia(nazov, popis) values ('�razov� chirurgia', null);
insert into m_specializacia(nazov, popis) values ('otorinolaryngol�gia', null);
insert into m_specializacia(nazov, popis) values ('oftalmol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� gynekol�gia', null);
insert into m_specializacia(nazov, popis) values ('dermatovenerol�gia', null);
insert into m_specializacia(nazov, popis) values ('klinick� onkol�gia', null);
insert into m_specializacia(nazov, popis) values ('v�eobecn� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('dorastov� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('r�diol�gia', null);
insert into m_specializacia(nazov, popis) values ('klinick� bioch�mia', null);
insert into m_specializacia(nazov, popis) values ('anest�ziol�gia a intenz�vna medic�na', null);
insert into m_specializacia(nazov, popis) values ('telov�chovn� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('fyziatria balneol�gia a lie�ebn� rehabilit�cia', null);
insert into m_specializacia(nazov, popis) values ('s�dne lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('patologick� anat�mia', null);
insert into m_specializacia(nazov, popis) values ('hematol�gia a transfuziol�gia', null);
insert into m_specializacia(nazov, popis) values ('urgentn� medic�na', null);
insert into m_specializacia(nazov, popis) values ('klinick� mikrobiol�gia', null);
insert into m_specializacia(nazov, popis) values ('neurochirurgia', null);
insert into m_specializacia(nazov, popis) values ('plastick� chirurgia', null);
insert into m_specializacia(nazov, popis) values ('ortopedick� protetika', null);
insert into m_specializacia(nazov, popis) values ('klinick� imunol�gia a alergol�gia', null);
insert into m_specializacia(nazov, popis) values ('radia�n� onkol�gia', null);
insert into m_specializacia(nazov, popis) values ('foniatria', null);
insert into m_specializacia(nazov, popis) values ('reumatol�gia', null);
insert into m_specializacia(nazov, popis) values ('algeziol�gia', null);
insert into m_specializacia(nazov, popis) values ('nukle�rna medic�na', null);
insert into m_specializacia(nazov, popis) values ('gastroenterol�gia', null);
insert into m_specializacia(nazov, popis) values ('kardiol�gia', null);
insert into m_specializacia(nazov, popis) values ('diabetol�gia poruchy l�tkovej premeny a v��ivy', null);
insert into m_specializacia(nazov, popis) values ('neonatol�gia', null);
insert into m_specializacia(nazov, popis) values ('hygiena det� a ml�de�e', null);
insert into m_specializacia(nazov, popis) values ('angiol�gia', null);
insert into m_specializacia(nazov, popis) values ('hygiena �ivotn�ho prostredia', null);
insert into m_specializacia(nazov, popis) values ('hygiena v��ivy', null);
insert into m_specializacia(nazov, popis) values ('epidemiol�gia', null);
insert into m_specializacia(nazov, popis) values ('geriatria', null);
insert into m_specializacia(nazov, popis) values ('medic�nska informatika a bio�tatistika', null);
insert into m_specializacia(nazov, popis) values ('lek�rska genetika', null);
insert into m_specializacia(nazov, popis) values ('nefrol�gia', null);
insert into m_specializacia(nazov, popis) values ('endokrinol�gia', null);
insert into m_specializacia(nazov, popis) values ('klinick� farmakol�gia', null);
insert into m_specializacia(nazov, popis) values ('zdravotn�cka informatika', null);
insert into m_specializacia(nazov, popis) values ('gynekologick� sexuol�gia', null);
insert into m_specializacia(nazov, popis) values ('cievna chirurgia', null);
insert into m_specializacia(nazov, popis) values ('kardiochirurgia', null);
insert into m_specializacia(nazov, popis) values ('maxilofaci�lna chirurgia', null);
insert into m_specializacia(nazov, popis) values ('medic�na drogov�ch z�vislost�', null);
insert into m_specializacia(nazov, popis) values ('gerontopsychiatria', null);
insert into m_specializacia(nazov, popis) values ('leteck� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('lek�r bez �pecializ�cie', null);
insert into m_specializacia(nazov, popis) values ('lek�r predpisuj�ci lieky pre seba a osoby bl�zke', null);
insert into m_specializacia(nazov, popis) values ('posudkov� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('ochrana zdravia pred ionizuj�cim �iaren�m', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� neurol�gia', null);
insert into m_specializacia(nazov, popis) values ('detsk� psychiatria', null);
insert into m_specializacia(nazov, popis) values ('hrudn�kov� chirurgia', null);
insert into m_specializacia(nazov, popis) values ('detsk� chirurgia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� ortop�dia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� urol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� otorinolaryngol�gia', null);
insert into m_specializacia(nazov, popis) values ('materno', null);
insert into m_specializacia(nazov, popis) values ('v�chova k zdraviu', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� imunol�gia a alergiol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� reumatol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� endokrinol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� gastroenterol�gia hepatol�gia a v��iva', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� kardiol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� pneumol�gia a ftizeol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� nefrol�gia', null);
insert into m_specializacia(nazov, popis) values ('hepatol�gia', null);
insert into m_specializacia(nazov, popis) values ('gastroenterologick� chirurgia', null);
insert into m_specializacia(nazov, popis) values ('neuropsychiatria', null);
insert into m_specializacia(nazov, popis) values ('laborat�rna medic�na', null);
insert into m_specializacia(nazov, popis) values ('tropick� medic�na', null);
insert into m_specializacia(nazov, popis) values ('verejn� zdravotn�ctvo', null);
insert into m_specializacia(nazov, popis) values ('onkol�gia v gynekol�gii', null);
insert into m_specializacia(nazov, popis) values ('psychosomatick� a behavior�lna medic�na', null);
insert into m_specializacia(nazov, popis) values ('ultrazvuk v gynekol�gii a p�rodn�ctve', null);
insert into m_specializacia(nazov, popis) values ('�peci�lne laborat�rne a diagnostick� met�dy v hematol�gii a transf�ziol�gii', null);
insert into m_specializacia(nazov, popis) values ('mamol�gia', null);
insert into m_specializacia(nazov, popis) values ('reproduk�n� medic�na', null);
insert into m_specializacia(nazov, popis) values ('akupunkt�ra', null);
insert into m_specializacia(nazov, popis) values ('androl�gia', null);
insert into m_specializacia(nazov, popis) values ('klinick� pracovn� lek�rstvo a klinick� toxikol�gia', null);
insert into m_specializacia(nazov, popis) values ('gynekologick� urol�gia', null);
insert into m_specializacia(nazov, popis) values ('onkol�gia v chirurgii', null);
insert into m_specializacia(nazov, popis) values ('onkol�gia v urol�gii', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� anest�ziol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� hematol�gia a onkol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� infektol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� intenz�vna medic�na', null);
insert into m_specializacia(nazov, popis) values ('paliat�vna medic�na', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� oftalmol�gia', null);
insert into m_specializacia(nazov, popis) values ('sexuol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� urgentn� medic�na', null);
insert into m_specializacia(nazov, popis) values ('zdravotn�cka ekol�gia', null);
insert into m_specializacia(nazov, popis) values ('rev�zne lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('prevent�vne pracovn� lek�rstvo a toxikol�gia', null);
insert into m_specializacia(nazov, popis) values ('psychiatrick� sexuol�gia', null);
insert into m_specializacia(nazov, popis) values ('slu�by zdravia pri pr�ci', null);
insert into m_specializacia(nazov, popis) values ('�tudijn� odbor v�eobecn� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('�tudijn� odbor detsk� lek�rstvo', null);



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
insert into m_doktor values ('9704082355','Lucia','Astalo�ov�', null,'A64932040');
insert into m_doktor values ('9704082366','Emil','August�n', null,'A37481001');
insert into m_doktor values ('9704082377','Michal','August�n', null,'A78485049');
insert into m_doktor values ('9704082388','Pavol','Babinec', null,'A57758009');
insert into m_doktor values ('9704082399','Eva','Babi�ov�', null,'A35887023');
insert into m_doktor values ('9704082410','Pavol','Babjak', null,'A70620247');
insert into m_doktor values ('9704082421','Peter','Babjak', null,'A84940020');
insert into m_doktor values ('9704082432','Eva','Ba?insk�', null,'A41128154');
insert into m_doktor values ('9704082443','Jana','Ba?insk�', null,'A52758001');
insert into m_doktor values ('9704082454','Karin','Bad�kov�', null,'B59063016');
insert into m_doktor values ('9704082465','�tefan','Ba?ura', null,'B91009016');
insert into m_doktor values ('9704082476','�tefan','Bajcar', null,'A90906020');
insert into m_doktor values ('9704082487','Viera','Bal�ov�', null,'A18487801');
insert into m_doktor values ('9704082498','Zuzana','Bal�ov�', null,'A45400801');
insert into m_doktor values ('9704082509','Ivana','Balh�rkov�', null,'A96312801');
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
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082542', m_t_choroba(new m_rec_choroba('Zhubn� n�dor bli��ie neur�enej sliznice �st.Zhubn� n�dor vn�torn�ho l�ca','Zhubn� n�dor sliznice l�ca','C06.0')),1,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082553', m_t_choroba(new m_rec_choroba('Infekcia zapr��inen� Salmonella typhi. Tyfoidn� hor��ka','Bru�n� t�fus','A01.0')),2,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082564', m_t_choroba(new m_rec_choroba('Infek�n� enetrit�da zapr��inen� salmonelou. ','Salmonelov� enterit�da','A02.0')),3,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082575', m_t_choroba(new m_rec_choroba('Klasick� potravinov� otrava zapr��inen� Clostridium botulinum','Botulizmus','A05.1')),4,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082542', m_t_choroba(new m_rec_choroba('Infekcia zapr��inen� Salmonella typhi. Tyfoidn� hor��ka','Bru�n� t�fus','A01.0')),5,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082542', m_t_choroba(new m_rec_choroba('Infek�n� enetrit�da zapr��inen� salmonelou.','Salmonelov� enterit�da','A02.0')),6,null,CURRENT_TIMESTAMP);
insert into m_zdravotna_karta(rod_cislo, m_t_choroby_informacie, id_zdravotny_zaznam, kontraindikacie, datum_zalozenia) values ('9704082542', m_t_choroba(new m_rec_choroba('Klasick� potravinov� otrava zapr��inen� Clostridium botulinum.','Botulizmus','A05.1')),7,null,CURRENT_TIMESTAMP);

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