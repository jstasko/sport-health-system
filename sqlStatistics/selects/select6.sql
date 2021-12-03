--6 lekarne ktore predali najviac liekov, kde cena liecby bola viac ako 500

SELECT
    ranking,
    nazovlekarne
FROM
    (
        SELECT /*+ PARALLEL */
            RANK()
            OVER(
                ORDER BY
                    COUNT(id_lekaren) DESC
            )             AS ranking,
            lekaren.nazov AS nazovlekarne
        FROM
                 m_liecba liecba
            JOIN m_lekaren lekaren ON lekaren.id = liecba.id_lekaren
        WHERE
            liecba.cena >= 500
        GROUP BY
            lekaren.nazov
    )
WHERE
    ranking <= 10;