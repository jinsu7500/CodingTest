SELECT M.AUTHOR_ID
     , N.AUTHOR_NAME
     , M.CATEGORY
     , SUM(M.TOTAL_SALES)   AS TOTAL_SALES
 FROM (
        SELECT X.BOOK_ID
             , X.SALES_CNT
             , Y.CATEGORY
             , Y.AUTHOR_ID
             , Y.PRICE
             , (Y.PRICE * X.SALES_CNT)  AS TOTAL_SALES
          FROM (
                -- 2월에 책별로 팔린개수
                SELECT A.BOOK_ID        AS BOOK_ID 
                     , SUM(A.SALES)     AS SALES_CNT
                  FROM BOOK_SALES A
                 WHERE 1=1 
                   AND TO_CHAR(A.SALES_DATE,'YYYYMM') = '202201'
                 GROUP BY A.BOOK_ID
              ) X
              , BOOK Y
        WHERE 1=1 
         AND X.BOOK_ID = Y.BOOK_ID
     ) M
     , AUTHOR N
WHERE 1=1 
  AND M.AUTHOR_ID = N.AUTHOR_ID
GROUP BY M.AUTHOR_ID
       , N.AUTHOR_NAME
       , M.CATEGORY
ORDER BY M.AUTHOR_ID 
       , M.CATEGORY DESC