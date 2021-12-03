--10 vsetky zaznamy, ktorych datum prehliadky je maximalne rok od zalozenia zdravotnej karty

SELECT /*+ PARALLEL */
    hrac.meno,
    hrac.priezvisko,
    zdravotny_zaznam.stav
FROM
         m_zdravotny_zaznam zdravotny_zaznam
    JOIN m_osoba           osoba ON osoba.rod_cislo = zdravotny_zaznam.rod_cislo
    JOIN m_hrac            hrac ON hrac.id = osoba.externeid
    JOIN m_zdravotna_karta zdravotna_karta ON zdravotna_karta.id = zdravotny_zaznam.id_zdravotny_karta
WHERE
    zdravotny_zaznam.datum_prehliadky >= add_months(zdravotna_karta.datum_zalozenia, - 12);