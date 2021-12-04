--7 karty zalozene za posledny rok plus nejaky where

SELECT /*+ PARALLEL */
    hrac.meno,
    hrac.priezvisko
FROM
         m_zdravotna_karta zdravotna_karta
    JOIN m_osoba osoba ON osoba.rod_cislo = zdravotna_karta.rod_cislo
    JOIN m_hrac  hrac ON hrac.id = osoba.externeid
WHERE
    datum_zalozenia > add_months(sysdate, - 12);