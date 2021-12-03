--5 ohodnotenie doktora, jeho meno, priezvisko a pocet operacii

SELECT
    ranking,
    menodoktora,
    priezviskodoktora,
    pocetoperacii
FROM
    (
        SELECT /*+ PARALLEL */
            RANK()
            OVER(
                ORDER BY
                    COUNT(id_osetrujuci_doktor) DESC
            )                           AS ranking,
            doktor.meno                 AS menodoktora,
            doktor.priezvisko           AS priezviskodoktora,
            COUNT(id_osetrujuci_doktor) AS pocetoperacii
        FROM
                 m_operacie_pacienta operacie_pacienta
            JOIN m_osetrujuci_doktor    osetrujuci_doktor ON osetrujuci_doktor.id = operacie_pacienta.id_osetrujuci_doktor
            JOIN m_doktor               doktor ON doktor.id = osetrujuci_doktor.id_doktor
            JOIN m_specializacia_lekara specializacia_lekara ON specializacia_lekara.id_doktor = doktor.id
        WHERE
            specializacia_lekara.id_specializacia = 44
        GROUP BY
            id_osetrujuci_doktor,
            doktor.meno,
            doktor.priezvisko,
            id_osetrujuci_doktor
    )
WHERE
    ranking <= 10;