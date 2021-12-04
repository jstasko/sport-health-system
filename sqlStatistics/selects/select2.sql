--2 meno, priezvisko doktora, nazov operacie vykonana na danom pacientovi

SELECT  /*+ PARALLEL */
    doktor.meno,
    doktor.priezvisko,
    operacia.nazov
FROM
         m_osoba osoba
    JOIN m_operacie_pacienta operacie_pacienta ON ( osoba.rod_cislo = operacie_pacienta.rod_cislo )
    JOIN m_operacia          operacia ON ( operacia.id = operacie_pacienta.id_operacia )
    JOIN m_osetrujuci_doktor osetrujuci_doktor ON ( osetrujuci_doktor.id = operacie_pacienta.id )
    JOIN m_doktor            doktor ON ( doktor.id = osetrujuci_doktor.id_doktor )
WHERE
    osoba.rod_cislo LIKE '9001019929';