  SELECT A.*        
           , B.*
           , (
             SELECT DISCOUNT_RATE
                FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
               WHERE 1=1 
                 AND C.CAR_TYPE IN ('세단','SUV')
                 AND C.DURATION_TYPE = '30일 이상'
                 AND C.CAR_TYPE = B.CAR_TYPE
            ) AS DISCOUNT_RATE
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
           , CAR_RENTAL_COMPANY_CAR B       
       WHERE 1=1 
         AND A.CAR_ID = B.CAR_ID     
         AND B.CAR_TYPE IN ('세단','SUV') 
         AND A.CAR_ID NOT IN (  
                            --이미 대여중인 차 목록
                            SELECT DISTINCT CAR_ID
                              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY X
                             WHERE 1=1
                               AND TO_CHAR(X.START_DATE ,'YYYYMMDD') <= 20221201
                               AND TO_CHAR(X.END_DATE,'YYYYMMDD') >= 20221101
                             ) 