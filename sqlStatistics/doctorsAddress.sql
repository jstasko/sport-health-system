select adresa.n_mesta, adresa.cislo_domu, adresa.PSC, okres.n_okresu, kraj.n_kraja, krajina.n_krajiny
from m_adresa adresa
         join m_adresa_hraca adresa_hraca on adresa_hraca.id_adresa = adresa.id
         join m_osoba osoba on adresa_hraca.rod_cislo = osoba.rod_cislo
         join m_doktor doktor on doktor.ROD_CISLO = osoba.ROD_CISLO
         join m_okres okres on okres.id = adresa.id_okresu
         join m_kraj kraj on kraj.id = okres.id_kraja
         join m_krajina krajina on krajina.id = kraj.id_krajiny
where doktor.id = :id
