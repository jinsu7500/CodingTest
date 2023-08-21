SELECT FLAVOR
 FROM (
        SELECT A.FLAVOR
             , (A.TOTAL_ORDER + B.TOTAL_ORDER) AS TOTAL_ORDER
          FROM FIRST_HALF A
             , (
                SELECT B.FLAVOR
                     , SUM(B.TOTAL_ORDER) AS TOTAL_ORDER
                  FROM JULY B
                 GROUP BY B.FLAVOR
               ) B
         WHERE 1=1
          AND A.FLAVOR = B.FLAVOR
        ORDER BY TOTAL_ORDER DESC  
     ) X
WHERE 1=1
  AND ROWNUM <= 3
