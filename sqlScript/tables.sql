create table m_krajina
(
 id_krajiny char(2) NOT NULL ,
 n_krajiny  varchar2(45) NOT NULL ,
 PRIMARY KEY (id_krajiny)
);

create table m_kraj
(
 n_kraja    varchar2(45) NOT NULL ,
 id_krajiny char(2) NOT NULL ,
 id_kraja   int NOT NULL ,

PRIMARY KEY (id_kraja),
CONSTRAINT cons_kraj_krajina_fk  FOREIGN KEY (id_krajiny) REFERENCES m_krajina (id_krajiny)
);


create table m_okres
(
 n_okresu  varchar2(45) NOT NULL ,
 id_kraja  int NOT NULL ,
 id_okresu int NOT NULL ,

PRIMARY KEY (id_okresu),
CONSTRAINT cons_okres_kraj_fk FOREIGN KEY (id_kraja) REFERENCES m_kraj (id_kraja)
);

create table m_adresa
(
 n_mesta       varchar2(45) NOT NULL ,
 --ulica         varchar(45) NOT NULL , TODO DAL SOM PREC
 cislo_domu    varchar2(45) NULL ,
 --popisne_cislo varchar(45) NULL , TODO ROVNAKE AKO cislo_domu
 id_okresu     int NOT NULL ,
 PSC           char(10) NOT NULL ,

PRIMARY KEY (PSC),
CONSTRAINT cons_adresa_okres_fk FOREIGN KEY (id_okresu) REFERENCES m_okres (id_okresu)
);

create table m_vyrobca_liekov
(
 PSC               char(10) NOT NULL ,
 nazov             varchar2(90) NOT NULL ,
 id_vyrobca_liekov int NOT NULL ,

PRIMARY KEY (id_vyrobca_liekov),
CONSTRAINT cons_vl_adresa_fk FOREIGN KEY (PSC) REFERENCES m_adresa (PSC)
);

create table m_liek
(
 id_liek           int NOT NULL ,
 id_vyrobca_liekov int NOT NULL ,
 nazov             varchar2(45) NOT NULL ,
 popis             varchar2(200) NOT NULL ,

PRIMARY KEY (id_liek),
CONSTRAINT cons_liek_vk_fk FOREIGN KEY (id_vyrobca_liekov) REFERENCES m_vyrobca_liekov (id_vyrobca_liekov)
);

create table m_lekaren
(
 PSC        char(10) NOT NULL ,
 nazov      varchar2(45) NOT NULL ,
 id_lekaren int NOT NULL ,

PRIMARY KEY (id_lekaren),
CONSTRAINT cons_lekaren_mesto_fk FOREIGN KEY (PSC) REFERENCES m_adresa (PSC)
);


create table m_institut
(
 PSC         char(10) NOT NULL ,
 nazov       varchar2(45) NOT NULL ,
 popis       varchar2(200) NULL ,
 id_institut int NOT NULL ,

PRIMARY KEY (id_institut),
CONSTRAINT cons_institut_mesto_fk FOREIGN KEY (PSC) REFERENCES m_adresa (PSC)
);
/

create table m_liecba
(
 id_liek     int NOT NULL ,
 id_lekaren  int NOT NULL ,
 id_institut int NOT NULL ,
 stav        varchar2(45) NOT NULL ,
 cena        float(10) NOT NULL, 
 id_liecba   int NOT NULL ,

PRIMARY KEY (id_liecba),
CONSTRAINT cons_liecba_institut_fk FOREIGN KEY (id_institut) REFERENCES m_institut (id_institut),
CONSTRAINT cons_liecba_liek_fk FOREIGN KEY (id_liek) REFERENCES m_liek (id_liek),
CONSTRAINT cons_liecba_lekaren_l FOREIGN KEY (id_lekaren) REFERENCES m_lekaren (id_lekaren)
);


create table m_hrac
(
 ExterneID  char(40) NOT NULL ,
 meno       varchar2(45) NOT NULL ,
 priezvisko varchar2(45) NOT NULL ,

PRIMARY KEY (ExterneID)
);

create table m_operacia
(
 id_operacia int NOT NULL ,
 nazov       varchar2(45) NOT NULL ,
 popis       varchar2(200) NOT NULL ,

PRIMARY KEY (id_operacia)
);


create table m_pouzivatel
(
 id_pouzivatela           int NOT NULL ,
 email                    varchar2(45) NOT NULL ,
 heslo                    varchar2(450) NOT NULL ,
 datum_posled_prihlasenia timestamp NOT NULL ,
 datum_registracie        timestamp NOT NULL ,
 subor                    BLOB,
 pripona                  VARCHAR2(5),

PRIMARY KEY (id_pouzivatela)
);

create table m_osoba
(
 ExterneID      char(40) NULL ,
 id_pouzivatela int NULL ,
 rod_cislo      char(11) NOT NULL ,

PRIMARY KEY (rod_cislo),
CONSTRAINT cons_osoba_hrac_fk FOREIGN KEY (ExterneID) REFERENCES m_hrac (ExterneID),
CONSTRAINT cons_osoba_pouzivatel_fk FOREIGN KEY (id_pouzivatela) REFERENCES m_pouzivatel (id_pouzivatela)
);

create table m_poistovna
(
 rod_cislo       char(11) NULL , --TODO podla mna moze byt null
 nazov_poistovne varchar2(100) NOT NULL ,
 id_poistovna    int NOT NULL ,

PRIMARY KEY (id_poistovna),
CONSTRAINT cons_poistovna_osoba_fk FOREIGN KEY (rod_cislo) REFERENCES m_osoba (rod_cislo)
);

create table m_specializacia
(
 id_specializacia int NOT NULL ,
 nazov            varchar2(100) NOT NULL ,
 popis            varchar2(200) NULL ,

PRIMARY KEY (id_specializacia)
);


create or replace type m_krv as object 
(
  typ_skupiny      varchar2(2),
  rh_faktor        varchar2(45)
)
/

create table m_krvna_skupina(
  rod_cislo        char(11) NOT NULL ,
  auto             m_krv,
  id_krvna_skupina int NOT NULL ,
  PRIMARY KEY (id_krvna_skupina),
  CONSTRAINT cons_ks_osoba_fk FOREIGN KEY (rod_cislo) REFERENCES m_osoba (rod_cislo)
)
/


create or replace type m_vlastnosti as object 
(
 hmotnost           float(10),
 vyska              float(10)
)
/

create table m_vlastnosti_hraca
(
 rod_cislo          char(11) NOT NULL ,
 auto               m_vlastnosti,
 id_vlastnostiHraca int NOT NULL ,

PRIMARY KEY (id_vlastnostiHraca),
CONSTRAINT cons_vh_osoba_fk FOREIGN KEY (rod_cislo) REFERENCES m_osoba (rod_cislo)
)
/


create table m_doktor
(
 rod_cislo char(11) NOT NULL ,
 id_doktor char(11) NOT NULL ,
 meno      varchar2(45),
 priezvisko varchar2(45),
PRIMARY KEY (id_doktor),
CONSTRAINT cons_doktor_osoba_fk FOREIGN KEY (rod_cislo) REFERENCES m_osoba (rod_cislo)
);



create table m_specializacia_lekara
(
 id_doktor               char(11) NOT NULL ,
 id_specializacia        int NOT NULL ,
 id_specializacia_lekara int NOT NULL ,

PRIMARY KEY (id_specializacia_lekara),
CONSTRAINT cons_sl_doktor_fk FOREIGN KEY (id_doktor) REFERENCES m_doktor (id_doktor),
CONSTRAINT cons_sl_specializacia_fk FOREIGN KEY (id_specializacia) REFERENCES m_specializacia (id_specializacia)
);


create table m_zdravotny_zaznam
(
 id_doktor           char(11) NOT NULL ,
 rod_cislo           char(11) NOT NULL ,
 id_institut         int NOT NULL ,
 datum_prehliadky    timestamp NOT NULL ,
 stav                varchar2(100) NULL ,
 id_zdravotny_zaznam int NOT NULL ,

PRIMARY KEY (id_zdravotny_zaznam),
CONSTRAINT cons_zz_doktor_fk FOREIGN KEY (id_doktor) REFERENCES m_doktor (id_doktor),
CONSTRAINT cons_zz_osoba_fk FOREIGN KEY (rod_cislo) REFERENCES m_osoba (rod_cislo),
CONSTRAINT cons_zz_institut_fk FOREIGN KEY (id_institut) REFERENCES m_institut (id_institut)
);


create or replace type m_rec_choroba as object 
(
  popis      varchar2(500),
  nazov      varchar2(45),
  kod        varchar2(6)
)
/

create or replace type m_t_choroba is table of m_rec_choroba;
/

create table m_zdravotna_karta
(
 rod_cislo                  char(11) not NULL ,
 m_t_choroby_informacie     m_t_choroba,
 id_zdravotny_zaznam        int not NULL ,
 kontraindikacie            varchar2(200) NULL ,
 datum_zalozenia            timestamp not NULL ,
 id_zdravotna_kara          int not NULL ,

PRIMARY KEY (id_zdravotna_kara),
CONSTRAINT cons_zk_zz_fk FOREIGN KEY (id_zdravotny_zaznam) REFERENCES m_zdravotny_zaznam (id_zdravotny_zaznam),
CONSTRAINT cons_zk_osoba_fk FOREIGN KEY (rod_cislo) REFERENCES m_osoba (rod_cislo)
)
nested table m_t_choroby_informacie store as informacie_nest_tab;
/


create table m_adresa_hraca
(
 PSC             char(10) NOT NULL ,
 rod_cislo       char(11) NOT NULL ,
 id_adresa_hraca int NOT NULL ,

PRIMARY KEY (id_adresa_hraca),
CONSTRAINT cons_ah_adresa_fk  FOREIGN KEY (PSC) REFERENCES m_adresa (PSC),
CONSTRAINT cons_ah_osoba_fk FOREIGN KEY (rod_cislo) REFERENCES m_osoba (rod_cislo)
);

create table m_osetrujuci_doktor
(
 id_institut          int NOT NULL ,
 id_doktor            char(11) NOT NULL ,
 id_osetrujuci_doktor int NOT NULL ,

PRIMARY KEY (id_osetrujuci_doktor),
CONSTRAINT cons_od_institut_fk FOREIGN KEY (id_institut) REFERENCES m_institut (id_institut),
CONSTRAINT cons_od_doktor_fk FOREIGN KEY (id_doktor) REFERENCES m_doktor (id_doktor)
);



create table m_operacie_pacienta
(
 rod_cislo            char(11) NOT NULL ,
 id_operacia          int NOT NULL ,
 id_osetrujuci_doktor int NOT NULL ,
 popis                varchar2(200) NULL ,
 id_operacie_pacienta int NOT NULL ,

PRIMARY KEY (id_operacie_pacienta),
CONSTRAINT cons_op_osoba_fk FOREIGN KEY (rod_cislo) REFERENCES m_osoba (rod_cislo),
CONSTRAINT cons_op_operacia_fk FOREIGN KEY (id_operacia) REFERENCES m_operacia (id_operacia),
CONSTRAINT cons_op_od_fk FOREIGN KEY (id_osetrujuci_doktor) REFERENCES m_osetrujuci_doktor (id_osetrujuci_doktor)
);

create table m_predpisana_liecba
(
 id_predpisana_liecba int NOT NULL ,
 id_zdravotna_kara    int NOT NULL ,
 id_liecba            int NOT NULL ,

PRIMARY KEY (id_predpisana_liecba),
CONSTRAINT cons_pl_liecba_fk FOREIGN KEY (id_liecba) REFERENCES m_liecba (id_liecba),
CONSTRAINT cons_pl_zk_fk FOREIGN KEY (id_zdravotna_kara) REFERENCES m_zdravotna_karta (id_zdravotna_kara)
);

--http://www.dba-oracle.com/t_oracle_create_directory.htm TODO KOMUNIKACIA
create directory m_images_dir as 'c:/Images/';

