/*select * from m_krajina;
select * from m_kraj;
select * from m_okres;
select * from m_adresa;
select * from m_vyrobca_liekov;
select * from m_liek;
select * from m_lekaren;
select * from m_institut;
select * from m_liecba;
select * from m_hrac;
select * from m_operacia;
select * from m_pouzivatel;
select * from m_osoba;
select * from m_poistovna;
select * from m_specializacia;
select * from m_krvna_skupina;
select * from m_vlastnosti_hraca;
select * from m_doktor;
select * from m_specializacia_lekara;
select * from m_zdravotny_zaznam;
select * from m_zdravotna_karta;
select * from m_adresa_hraca;
select * from m_osetrujuci_doktor; 
select * from m_operacie_pacienta;
select * from m_predpisana_liecba;
select * from m_image;*/

select count(*) from (select * from m_krajina);
select count(*) from (select * from m_kraj);
select count(*) from (select * from m_okres);
select count(*) from (select * from m_adresa);
select count(*) from (select * from m_vyrobca_liekov);
select count(*) from (select * from m_liek);
select count(*) from (select * from m_lekaren);
select count(*) from (select * from m_institut);
select count(*) from (select * from m_liecba);
select count(*) from (select * from m_hrac);
select count(*) from (select * from m_operacia);
--select count(*) from (select * from m_pouzivatel);
select count(*) from (select * from m_osoba);
select count(*) from (select * from m_poistovna);
select count(*) from (select * from m_specializacia);
select count(*) from (select * from m_krvna_skupina);
select count(*) from (select * from m_vlastnosti_hraca);
select count(*) from (select * from m_doktor);
select count(*) from (select * from m_specializacia_lekara);
select count(*) from (select * from m_zdravotny_zaznam);
select count(*) from (select * from m_zdravotna_karta);
select count(*) from (select * from m_adresa_hraca);
select count(*) from (select * from m_osetrujuci_doktor); 
select count(*) from (select * from m_operacie_pacienta);
select count(*) from (select * from m_predpisana_liecba);
--select count(*) from (select * from m_image);

/*
---CHOROBY KTORE  HRACA POSTIHLI
select choroby.NAZOV, choroby.popis--, karta.datum_zalozenia
  from m_osoba osoba
  join m_zdravotna_karta karta on (osoba.rod_cislo = karta.rod_cislo)
  ,table(karta."M_T_CHOROBY_INFORMACIE") choroby;



--Hraci operacie
select doktor.meno, doktor.priezvisko, operacia.nazov 
  from m_osoba osoba
  join m_operacie_pacienta operacie_pacienta on (osoba.rod_cislo = operacie_pacienta.rod_cislo)
  join m_operacia operacia on (operacia.id = operacie_pacienta.id_operacia)
  join m_osetrujuci_doktor osetrujuci_doktor  on (osetrujuci_doktor.id = operacie_pacienta.id)
  join m_doktor doktor on (doktor.id = osetrujuci_doktor.id_doktor)
  where osoba.rod_cislo like '900115931';
  
--Hraci lieky
select hrac.id, hrac.meno, hrac.priezvisko, liek.nazov 
 from m_hrac hrac
  join m_osoba osoba on (hrac.id = osoba.ExterneId)
  join m_zdravotna_karta karta on (osoba.rod_cislo = karta.rod_cislo)
  join m_predpisana_liecba predpisana_liecba on (predpisana_liecba.id_zdravotna_kara = karta.id)  
  join m_liecba liecba on (liecba.id = predpisana_liecba.id_liecba)
  join m_liek liek on (liek.id = liecba.id_liek);  
  
--Hraci adresy
select hrac.id, hrac.meno, hrac.priezvisko, liek.nazov 
 from m_hrac hrac
  join m_osoba osoba on (hrac.id = osoba.ExterneId)
  join m_zdravotna_karta karta on (osoba.rod_cislo = karta.rod_cislo)
  join m_predpisana_liecba predpisana_liecba on (predpisana_liecba.id_zdravotna_kara = karta.id)  
  join m_liecba liecba on (liecba.id = predpisana_liecba.id_liecba)
  join m_liek liek on (liek.id = liecba.id_liek);   
  */
  
  
  
  