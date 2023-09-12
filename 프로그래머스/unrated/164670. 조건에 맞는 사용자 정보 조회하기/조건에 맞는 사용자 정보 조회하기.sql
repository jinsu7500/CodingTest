SELECT A.USER_ID
     , A.NICKNAME
     , A.CITY || ' ' || A.STREET_ADDRESS1|| ' ' || A.STREET_ADDRESS2 AS 전체주소
     , SUBSTR(A.TLNO,0,3) || '-' || SUBSTR(A.TLNO,4,4) || '-' ||SUBSTR(A.TLNO,8)    AS 전화번호
  FROM USED_GOODS_USER A
 WHERE 1=1 
   AND A.USER_ID IN (SELECT B.WRITER_ID
                         -- , COUNT(B.WRITER_ID) AS CNT
                      FROM USED_GOODS_BOARD B
                      GROUP BY B.WRITER_ID
                      HAVING COUNT(B.WRITER_ID) > 2
                        )
  ORDER BY A.USER_ID DESC
  


