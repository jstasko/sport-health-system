--8 meno, priezvisko, krvna skupina, rh faktor, vyska, hmotnost hraca so zadanym id

SELECT /*+ PARALLEL */
    hrac.meno,
    hrac.priezvisko,
    krvna_skupina.auto.typ_skupiny,
    krvna_skupina.auto.rh_faktor,
    vlastnosti_hraca.auto.vyska,
    vlastnosti_hraca.auto.hmotnost
FROM
         m_osoba osoba
    JOIN m_hrac             hrac ON ( hrac.id = osoba.externeid )
    JOIN m_vlastnosti_hraca vlastnosti_hraca ON vlastnosti_hraca.rod_cislo = osoba.rod_cislo
    JOIN m_krvna_skupina    krvna_skupina ON krvna_skupina.rod_cislo = osoba.rod_cislo
WHERE
    hrac.id = '5d65907a86dc8b72383451ff';