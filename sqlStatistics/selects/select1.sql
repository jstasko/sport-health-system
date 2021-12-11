--1 pravdepodobnost zranenia hraca podla jeho rodneho cisla

SELECT /*+ PARALLEL */
    hrac.meno,
    hrac.priezvisko,
    CASE
        WHEN COUNT(*) > 5 THEN
            'Vysoká'
        WHEN COUNT(*) < 5
             AND COUNT(*) > 2 THEN
            'Stredná'
        ELSE
            'Nízka'
    END AS pravdepodobnostzranenia,
    COUNT(*)
FROM
         m_hrac hrac
    JOIN m_osoba             osoba ON ( hrac.id = osoba.externeid )
    JOIN m_operacie_pacienta operacie_pacienta ON ( operacie_pacienta.rod_cislo = osoba.rod_cislo )
    JOIN m_operacia          operacia ON ( operacia.id = operacie_pacienta.id_operacia )
WHERE
    osoba.rod_cislo = '9001024923'
GROUP BY
    hrac.meno,
    hrac.priezvisko,
    osoba.rod_cislo;
    
