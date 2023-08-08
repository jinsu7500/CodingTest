SELECT A.HISTORY_ID
     , ROUND(A.DAILY_FEE * A.RENTDATE * (100 - NVL(C.DISCOUNT_RATE, 0)) / 100) AS FEE
  FROM 
    ( SELECT A.CAR_TYPE
           , A.DAILY_FEE
           , B.HISTORY_ID             
           , (B.END_DATE - B.START_DATE ) +1 AS RENTDATE
           , CASE WHEN (B.END_DATE - B.START_DATE) + 1 < 7 THEN '할인없음'
                  WHEN (B.END_DATE - B.START_DATE) + 1 < 30 THEN '7일 이상'
                  WHEN (B.END_DATE - B.START_DATE) + 1 < 90 THEN '30일 이상'
                  ELSE '90일 이상'
                   END AS DURATION_TYPE                    
          FROM CAR_RENTAL_COMPANY_CAR A  
             , CAR_RENTAL_COMPANY_RENTAL_HISTORY B             
         WHERE 1=1 
          AND A.CAR_ID = B.CAR_ID  
          AND A.CAR_TYPE = '트럭'          
  ) A
  , CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
WHERE 1=1
 AND A.CAR_TYPE = C.CAR_TYPE(+)
 AND A.DURATION_TYPE = C.DURATION_TYPE (+)
ORDER BY FEE DESC
       , HISTORY_ID DESC
