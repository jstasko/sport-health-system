--4 Vsetky choroby a ich popis pre daneho hraca

SELECT  /*+ PARALLEL */
    choroby.nazov,
    choroby.popis --, karta.datum_zalozenia
FROM
         m_osoba osoba
    JOIN m_hrac                                   hrac ON hrac.id = osoba.externeid
    JOIN m_zdravotna_karta                        karta ON ( osoba.rod_cislo = karta.rod_cislo ),
    TABLE ( karta."M_T_CHOROBY_INFORMACIE" ) choroby
WHERE
    hrac.id = '61407e9debf3a384471ac714';