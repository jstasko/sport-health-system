--3 vypisanie adresy hraca podla id

SELECT /*+ PARALLEL */
    adresa.n_mesta,
    adresa.cislo_domu,
    adresa.psc,
    okres.n_okresu,
    kraj.n_kraja,
    krajina.n_krajiny
FROM
         m_adresa adresa
    JOIN m_adresa_hraca adresa_hraca ON adresa_hraca.id_adresa = adresa.id
    JOIN m_osoba        osoba ON adresa_hraca.rod_cislo = osoba.rod_cislo
    JOIN m_hrac         hrac ON hrac.id = osoba.externeid
    JOIN m_okres        okres ON okres.id = adresa.id_okresu
    JOIN m_kraj         kraj ON kraj.id = okres.id_kraja
    JOIN m_krajina      krajina ON krajina.id = kraj.id_krajiny
WHERE
    hrac.id = '5d65815c86dc8b723831a8ff';

-- pocet hracov v jednotlivych okresov v zadanom kraji
SELECT  /*+ PARALLEL */
    okres.n_okresu,
    COUNT(*) AS pocethracov
FROM
         m_hrac hrac
    JOIN m_osoba        osoba ON osoba.externeid = hrac.id
    JOIN m_adresa_hraca adresa_hraca ON adresa_hraca.rod_cislo = osoba.rod_cislo
    JOIN m_adresa       adresa ON adresa.id = adresa_hraca.id_adresa
    JOIN m_okres        okres ON adresa.id_okresu = okres.id
    JOIN m_kraj         kraj ON okres.id_kraja = kraj.id
WHERE
    kraj.n_kraja = 'Žilinský'
GROUP BY
    okres.n_okresu;