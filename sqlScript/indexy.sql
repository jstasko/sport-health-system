execute DBMS_STATS.GATHER_SCHEMA_STATS('KASUBA5', cascade => true);

--------------------------------------------------------------------------------
--indexy
create index m_index_adresa on m_adresa(id_okresu);
create index m_index_adresa_hraca on m_adresa_hraca(rod_cislo,id_adresa); --treba
create index m_index_hrac on m_hrac(meno, priezvisko); --U10
create index m_index_instut on m_institut(lower(nazov)); -- functional index
create index m_index_kraj on m_kraj(id_krajiny,n_kraja); --full disappeared from kraj.id = okres.id_kraja
create index m_index_krvna_skupina on m_krvna_skupina(rod_cislo, auto.typ_skupiny, auto.rh_faktor);
create index m_index_liecba on m_liecba(cena, id_lekaren);
create index m_index_lekaren on m_lekaren(nazov);
create index m_index_okres on m_okres(id_kraja, n_okresu);--full disappeared from okres.id = okres.id_okresu
create index m_index_operacie_pacienta_U1 on m_operacie_pacienta(rod_cislo);
create index m_index_operacie_pacienta_U5 on m_operacie_pacienta(id_osetrujuci_doktor);
create index m_index_osetrujuci_doktor on m_osetrujuci_doktor(id_institut,id_doktor);
create index m_index_osoba on m_osoba(ExterneID); --treba
create index m_index_osoba_U7 on m_osoba(rod_cislo, externeid); --treba
create index m_index_specializacia_lekara on m_specializacia_lekara(id_specializacia, id_doktor); 
create index m_index_vlastnosti_hraca on m_vlastnosti_hraca(rod_cislo,auto.vyska);
create index m_index_zdravotna_karta on m_zdravotna_karta(datum_zalozenia);
create index m_index_zdravotna_karta_U4 on m_zdravotna_karta(rod_cislo, datum_zalozenia);
create index m_index_zdravotna_karta_U7 on m_zdravotna_karta(datum_zalozenia, rod_cislo);
create index m_index_zdravotny_zaznam on m_zdravotny_zaznam(rod_cislo, id_zdravotny_karta, datum_prehliadky, stav); 

drop index m_index_adresa;
drop index m_index_adresa_hraca;
drop index m_index_hrac;
drop index m_index_instut;
drop index m_index_kraj;
drop index m_index_krvna_skupina;
drop index m_index_liecba;
drop index m_index_lekaren;
drop index m_index_okres;
drop index m_index_operacie_pacienta_U1;
drop index m_index_operacie_pacienta_U5;
drop index m_index_osetrujuci_doktor;
drop index m_index_osoba;
drop index m_index_osoba_U7;
drop index m_index_specializacia_lekara;
drop index m_index_vlastnosti_hraca;
drop index m_index_zdravotna_karta;
drop index m_index_zdravotna_karta_U4;
drop index m_index_zdravotna_karta_U7;
drop index m_index_zdravotny_zaznam;



select * from user_indexes where lower(index_name) like 'm_%'; 

commit;
--------------------------------------------------------------------------------
--1

create index m_index_operacie_pacienta_U1 on m_operacie_pacienta(rod_cislo); --done
-- pravdepodobnost zranenia hraca podla jeho rodneho cisla
select /*+ PARALLEL */
hrac.meno, hrac.priezvisko,
case
when count(*) > 5 then 'Vysoká'
when count(*) < 5 and count(*) > 2 then 'Stredná'
else 'Nízka'
end as PravdepodobnostZranenia, count(*)
from m_hrac hrac
join m_osoba osoba on (hrac.id = osoba.externeid)
join m_operacie_pacienta operacie_pacienta on ( operacie_pacienta.rod_cislo = osoba.rod_cislo)
join m_operacia operacia on (operacia.id = operacie_pacienta.id_operacia)
where osoba.rod_cislo = '9001019929'
group by hrac.meno, hrac.priezvisko, osoba.rod_cislo;

--------------------------------------------------------------------------------
--2 meno, priezvisko doktora, nazov operacie vykonana na danom pacientovi
--create index m_index_operacie_pacienta_U1 on m_operacie_pacienta(rod_cislo); --U1

select  /*+ PARALLEL */doktor.meno, doktor.priezvisko, operacia.nazov 
  from m_osoba osoba
  join m_operacie_pacienta operacie_pacienta on (osoba.rod_cislo = operacie_pacienta.rod_cislo)
  join m_operacia operacia on (operacia.id = operacie_pacienta.id_operacia)
  join m_osetrujuci_doktor osetrujuci_doktor  on (osetrujuci_doktor.id = operacie_pacienta.id)
  join m_doktor doktor on (doktor.id = osetrujuci_doktor.id_doktor)
  where osoba.rod_cislo like '9001019929';

-----------------------------------------------------------------------------
--3
create index m_index_osoba on m_osoba(ExterneID); --treba
create index m_index_adresa_hraca on m_adresa_hraca(rod_cislo,id_adresa); --treba

create index m_index_kraj on m_kraj(id_krajiny,n_kraja); --full disappeared from kraj.id = okres.id_kraja
create index m_index_okres on m_okres(id_kraja, n_okresu);--full disappeared from okres.id = okres.id_okresu
create index m_index_adresa on m_adresa(id_okresu);

-- vypisanie adresy hraca podla id
select /*+ PARALLEL */ adresa.n_mesta, adresa.cislo_domu, adresa.PSC, okres.n_okresu, kraj.n_kraja, krajina.n_krajiny
from m_adresa adresa
join m_adresa_hraca adresa_hraca on adresa_hraca.id_adresa = adresa.id
join m_osoba osoba on adresa_hraca.rod_cislo = osoba.rod_cislo
join m_hrac hrac on hrac.id = osoba.ExterneID
join m_okres okres on okres.id = adresa.id_okresu
join m_kraj kraj on kraj.id = okres.id_kraja
join m_krajina krajina on krajina.id = kraj.id_krajiny
where hrac.id = '5d65815c86dc8b723831a8ff';


-- pocet hracov v jendotlivych okresov v zadanom kraji
create index m_index_kraj_2 on m_kraj(n_kraja, id_krajiny);
create index m_index_adresa_hraca_mk_2 on m_adresa_hraca(rod_cislo);
drop /*+ PARALLEL */ index m_index_adresa_hraca_mk_2;
select okres.n_okresu, count(*) as PocetHracov
from m_hrac hrac 
join m_osoba osoba on osoba.ExterneID = hrac.id
join m_adresa_hraca adresa_hraca on adresa_hraca.rod_cislo = osoba.rod_cislo
join m_adresa adresa on adresa.id = adresa_hraca.id_adresa
join m_okres okres on adresa.id_okresu = okres.id
join m_kraj kraj on okres.id_kraja = kraj.id
where kraj.n_kraja = 'Žilinský'
group by okres.n_okresu;
-----------------------------------------------------------------------------
--4 Vsetky choroby a ich popis pre daneho hraca
create index m_index_zdravotna_karta_U4 on m_zdravotna_karta(rod_cislo, datum_zalozenia);
drop index m_index_zdravotna_karta_U4;
select   /*+ PARALLEL */  choroby.NAZOV, choroby.popis
from m_osoba osoba
join m_hrac hrac on hrac.id = osoba.externeid
join m_zdravotna_karta karta on (osoba.rod_cislo = karta.rod_cislo)
,table(karta."M_T_CHOROBY_INFORMACIE") choroby
where hrac.id = '61407e9debf3a384471ac714';

-----------------------------------------------------------------------------
--5 ohodnotenie doktora, jeho meno, priezvisko a pocet operacii

create index m_index_operacie_pacienta_U5 on m_operacie_pacienta(id_osetrujuci_doktor); -- this one
create index m_index_specializacia_lekara on m_specializacia_lekara(id_doktor);

select ranking, menodoktora, priezviskodoktora, pocetOperacii from (
    select /*+ PARALLEL */ rank() over (order by count(id_osetrujuci_doktor) desc) as ranking, doktor.meno as menodoktora,
    doktor.priezvisko as priezviskodoktora, count(id_osetrujuci_doktor) as pocetOperacii
    from m_operacie_pacienta operacie_pacienta
    join m_osetrujuci_doktor osetrujuci_doktor on osetrujuci_doktor.id = operacie_pacienta .id_osetrujuci_doktor
    join m_doktor doktor on doktor.id = osetrujuci_doktor.id_doktor
    join m_specializacia_lekara specializacia_lekara on specializacia_lekara.id_doktor = doktor.id
    where specializacia_lekara.id_specializacia = 44
    group by id_osetrujuci_doktor,doktor.meno, doktor.priezvisko, id_osetrujuci_doktor
) where ranking <= 10;

-----------------------------------------------------------------------------
--6 lekarne ktore predali najviac liekov, kde cena liecby bola viac ako 500

create index m_index_liecba on m_liecba(cena, id_lekaren);
create index m_index_lekaren on m_lekaren(nazov);

select ranking, nazovlekarne from (
    select /*+ PARALLEL */ rank() over (order by count(id_lekaren) desc) as ranking, lekaren.nazov as nazovlekarne 
    from m_liecba liecba
    join m_lekaren lekaren on lekaren.id = liecba .id_lekaren
    where liecba.cena >= 500
    group by lekaren.nazov
) where ranking <= 10;

--------------------------------------------------------------------------------
--7 karty zalozene za posledny rok plus nejaky where
create index m_index_zdravotna_karta on m_zdravotna_karta(datum_zalozenia);
create index m_index_zdravotna_karta1 on m_zdravotna_karta(datum_zalozenia,  rod_cislo); --need this
create index m_index_osoba_U7 on m_osoba(rod_cislo, externeid);
drop index m_index_hrac ;

select /*+ PARALLEL */  hrac.meno, hrac.priezvisko from m_zdravotna_karta zdravotna_karta
join m_osoba osoba on osoba.rod_cislo = zdravotna_karta.rod_cislo
join m_hrac hrac on hrac.id = osoba.externeid
where datum_zalozenia > add_months(sysdate,-12);

--------------------------------------------------------------------------------
--8 meno, priezvisko, krvna skupina, rh faktor, vyska, hmotnost hraca so zadanym id

create index m_index_vlastnosti_hraca on m_vlastnosti_hraca(rod_cislo,auto.vyska);
create index m_index_krvna_skupina on m_krvna_skupina(rod_cislo, auto.typ_skupiny, auto.rh_faktor);



select /*+ PARALLEL */
hrac.meno, hrac.priezvisko, krvna_skupina.auto.typ_skupiny, krvna_skupina.auto.rh_faktor, vlastnosti_hraca.auto.vyska, vlastnosti_hraca.auto.hmotnost
from m_osoba osoba
join m_hrac hrac on (hrac.id = osoba.externeid)
join m_vlastnosti_hraca vlastnosti_hraca on vlastnosti_hraca.rod_cislo = osoba.rod_cislo
join m_krvna_skupina krvna_skupina on krvna_skupina.rod_cislo = osoba.rod_cislo
where hrac.id  = '5d65907a86dc8b72383451ff';

--------------------------------------------------------------------------------
--9 pre kazdu specializaciu vypisat top ambulanciu(pripadne top viac) kde je vyskyt specializacie najcastejsi

create index m_index_specializacia_lekara on m_specializacia_lekara(id_specializacia, id_doktor); 
create index m_index_osetrujuci_doktor on m_osetrujuci_doktor(id_institut,id_doktor);

select nazovspecializacie ,nazovinstitutu, ranking from (
    select /*+ PARALLEL */ rank() over (partition by (specializacia_lekara.id_specializacia) order by count(osetrujuci_doktor.id_institut) desc) as ranking, 
    specializacia.nazov as nazovspecializacie, institut.nazov nazovinstitutu
    from m_specializacia_lekara specializacia_lekara
    join m_specializacia specializacia on specializacia.id = specializacia_lekara.id_specializacia
    join m_doktor doktor on doktor.id = specializacia_lekara.id_doktor
    join m_osetrujuci_doktor osetrujuci_doktor on osetrujuci_doktor.id_doktor = doktor.id
    join m_institut institut on institut.id = osetrujuci_doktor.id_institut
    where lower(institut.nazov) like '%ambulancia%'
    group by specializacia_lekara.id_specializacia, specializacia.nazov, institut.nazov
) where ranking = 1;

--------------------------------------------------------------------------------
--10 vsetky zaznamy, ktorych datum prehliadky je maximalne rok od zalozenia zdravotnej karty
create index m_index_zdravotny_zaznam on m_zdravotny_zaznam(rod_cislo, id_zdravotny_karta, datum_prehliadky, stav);

select /*+ PARALLEL */ hrac.meno, hrac.priezvisko ,zdravotny_zaznam.stav
from m_zdravotny_zaznam zdravotny_zaznam
join m_osoba osoba on osoba.rod_cislo = zdravotny_zaznam.rod_cislo
join m_hrac hrac on hrac.id = osoba.externeid
join m_zdravotna_karta zdravotna_karta on zdravotna_karta.id = zdravotny_zaznam.id_zdravotny_karta
where zdravotny_zaznam.datum_prehliadky >= add_months(zdravotna_karta.datum_zalozenia,-12);


--------------------------------------------------------------------------------
--json report
select /*+ PARALLEL */ osoba.rod_cislo,vlastnosti_hraca.auto.vyska,vlastnosti_hraca.auto.hmotnost, krvna_skupina.auto.typ_skupiny,
krvna_skupina.auto.rh_faktor,count(operacie_pacient.rod_cislo)
from m_hrac hrac 
join m_osoba osoba ON(osoba.externeid = hrac.id)
join m_vlastnosti_hraca vlastnosti_hraca on (vlastnosti_hraca.rod_cislo = osoba.rod_cislo)
join m_krvna_skupina krvna_skupina on(krvna_skupina.rod_cislo = osoba.rod_cislo)
left join m_operacie_pacienta operacie_pacient on(osoba.rod_cislo = operacie_pacient.rod_cislo)
left join m_operacia operacie on(operacie.id = operacie_pacient.id_operacia)
where hrac.ID = '5d658c8f86dc8b723833a184'
group by hrac.meno,hrac.priezvisko,osoba.rod_cislo,vlastnosti_hraca.auto.vyska,
vlastnosti_hraca.auto.hmotnost,krvna_skupina.auto.typ_skupiny,krvna_skupina.auto.rh_faktor;


