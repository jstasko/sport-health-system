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
select * from m_osoba;
select * from m_zdravotna_karta;
select * from m_zdravotny_zaznam;
*/