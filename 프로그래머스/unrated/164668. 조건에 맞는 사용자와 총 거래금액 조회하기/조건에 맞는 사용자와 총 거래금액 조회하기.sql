SELECT A.WRITER_ID
     , B.NICKNAME
     , SUM(PRICE) AS TOTAL_PRICE     
  FROM USED_GOODS_BOARD A
     , USED_GOODS_USER B
 WHERE 1=1
   AND A.STATUS = 'DONE'
   AND A.WRITER_ID = B.USER_ID
 GROUP BY A.WRITER_ID
        , B.NICKNAME
 HAVING SUM(PRICE) >= 700000
 ORDER BY TOTAL_PRICE
   