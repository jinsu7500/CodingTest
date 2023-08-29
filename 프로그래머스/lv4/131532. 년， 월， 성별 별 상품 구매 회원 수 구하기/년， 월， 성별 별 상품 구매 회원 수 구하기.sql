-- 코드를 입력하세요
SELECT TO_CHAR(A.SALES_DATE,'YYYY')             AS YEAR
     , TO_NUMBER(TO_CHAR(A.SALES_DATE,'MM'))    AS MONTH
     , B.GENDER                                 AS GENDER
     , COUNT(DISTINCT A.USER_ID)                         AS USERS
  FROM ONLINE_SALE A
     , USER_INFO B
WHERE 1=1
  AND A.USER_ID = B.USER_ID (+)
  AND B.GENDER IS NOT NULL
  GROUP BY TO_CHAR(A.SALES_DATE,'YYYY')
         , TO_NUMBER(TO_CHAR(A.SALES_DATE,'MM'))
         , B.GENDER
  ORDER BY YEAR ASC
         , MONTH ASC
         , GENDER ASC
  
  
   