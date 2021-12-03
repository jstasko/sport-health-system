select choroby.NAZOV as nazov, choroby.popis as popis
from m_osoba osoba
join m_zdravotna_karta karta on (osoba.rod_cislo = karta.rod_cislo),table(karta."M_T_CHOROBY_INFORMACIE") choroby
where osoba.ROD_CISLO = :rodCislo
