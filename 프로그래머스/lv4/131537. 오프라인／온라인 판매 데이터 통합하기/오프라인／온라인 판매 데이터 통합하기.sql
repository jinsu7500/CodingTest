-- 코드를 입력하세요
SELECT TO_CHAR(X.SALES_DATE,'YYYY-MM-DD') AS SALES_DATE
     , X.PRODUCT_ID
     , X.USER_ID
     , X.SALES_AMOUNT
  FROM
      (
        SELECT A.SALES_DATE
             , A.PRODUCT_ID
             , A.USER_ID
             , A.SALES_AMOUNT
          FROM ONLINE_SALE A
         WHERE 1=1
           AND TO_CHAR(A.SALES_DATE,'YYYYMM') = '202203'

        UNION ALL

        SELECT B.SALES_DATE
             , B.PRODUCT_ID
             , NULL     AS USER_ID
             , B.SALES_AMOUNT
          FROM OFFLINE_SALE B
         WHERE 1=1
           AND TO_CHAR(B.SALES_DATE,'YYYYMM') = '202203'
      ) X
ORDER BY SALES_DATE ASC
       , PRODUCT_ID ASC
       , USER_ID  ASC

   
   
   