SELECT DISTINCT X.CAR_ID
     , X.CAR_TYPE
     , X.DISCOUNT_FEE       AS FEE
  FROM
     (
      SELECT A.HISTORY_ID
           , A.CAR_ID
           , A.START_DATE
           , A.END_DATE         
           , B.CAR_TYPE
           , B.DAILY_FEE
           , B.OPTIONS           
           , C.DISCOUNT_RATE 
           , (DAILY_FEE * 30) AS ORG_FEE
           , ROUND((DAILY_FEE * 30) - (DAILY_FEE * 30 * (0.01 * C.DISCOUNT_RATE))) AS DISCOUNT_FEE
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
           , CAR_RENTAL_COMPANY_CAR B   
           , (
              SELECT C.*
                FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
               WHERE 1=1 
                 AND C.CAR_TYPE IN ('세단','SUV')
                 AND C.DURATION_TYPE = '30일 이상'                 
             ) C
       WHERE 1=1 
         AND A.CAR_ID = B.CAR_ID              
         AND B.CAR_TYPE = C.CAR_TYPE (+)
         AND B.CAR_TYPE IN ('세단','SUV')
         AND A.CAR_ID NOT IN (  
                            --이미 대여중인 차 목록
                            SELECT DISTINCT CAR_ID
                              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY X
                             WHERE 1=1
                               AND TO_CHAR(X.START_DATE ,'YYYYMMDD') <= 20221201
                               AND TO_CHAR(X.END_DATE,'YYYYMMDD') >= 20221101
                             ) 
     ) X
WHERE 1=1
  AND X.DISCOUNT_FEE >= 500000
  AND X.DISCOUNT_FEE < 2000000
 ORDER BY FEE DESC
        , CAR_TYPE ASC
        , CAR_ID DESC



  
