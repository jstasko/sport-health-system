select liek.nazov as liek, vyrobca.NAZOV as vyrobca
from m_osoba osoba
join m_zdravotna_karta karta on (osoba.rod_cislo = karta.rod_cislo)
join m_predpisana_liecba predpisana_liecba on (predpisana_liecba.id_zdravotna_kara = karta.id)
join m_liecba liecba on (liecba.id = predpisana_liecba.id_liecba)
join m_liek liek on (liek.id = liecba.id_liek)
join m_vyrobca_liekov vyrobca on (liek.id_vyrobca_liekov = vyrobca.id)
where osoba.rod_cislo = :rodCislo
