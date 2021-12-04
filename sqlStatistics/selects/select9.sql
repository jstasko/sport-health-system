--9 pre kazdu specializaciu vypisat top ambulanciu(pripadne top viac) kde je vyskyt specializacie najcastejsi

SELECT
    nazovspecializacie,
    nazovinstitutu,
    ranking
FROM
    (
        SELECT /*+ PARALLEL */
            RANK()
            OVER(PARTITION BY(specializacia_lekara.id_specializacia)
                 ORDER BY
                     COUNT(osetrujuci_doktor.id_institut) DESC
            )                   AS ranking,
            specializacia.nazov AS nazovspecializacie,
            institut.nazov      nazovinstitutu
        FROM
                 m_specializacia_lekara specializacia_lekara
            JOIN m_specializacia     specializacia ON specializacia.id = specializacia_lekara.id_specializacia
            JOIN m_doktor            doktor ON doktor.id = specializacia_lekara.id_doktor
            JOIN m_osetrujuci_doktor osetrujuci_doktor ON osetrujuci_doktor.id_doktor = doktor.id
            JOIN m_institut          institut ON institut.id = osetrujuci_doktor.id_institut
        WHERE
            lower(institut.nazov) LIKE '%ambulancia%'
        GROUP BY
            specializacia_lekara.id_specializacia,
            specializacia.nazov,
            institut.nazov
    )
WHERE
    ranking = 1;