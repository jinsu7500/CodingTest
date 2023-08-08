SELECT (SELECT Y.DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN Y WHERE X.car_type = Y.CAR_TYPE AND X.duration_type = Y.duration_type)
        AS FEE
    , X.*      
  FROM    
    (
        SELECT CASE WHEN TO_NUMBER(A.END_DATE - A.START_DATE)  >= 90 THEN '90일 이상'
                    WHEN TO_NUMBER(A.END_DATE - A.START_DATE)  >= 30 THEN '30일 이상'
                    WHEN TO_NUMBER(A.END_DATE - A.START_DATE)  >= 7 THEN  '7일 이상'
                    else '할인없음'
                    END
                    AS DURATION_TYPE
                 , TO_NUMBER(A.END_DATE - A.START_DATE + 1) AS RENTDATE
                 , A.HISTORY_ID
                 , A.CAR_ID
                 , A.START_DATE
                 , A.END_DATE
                 , B.CAR_TYPE
                 , B.DAILY_FEE
                 , B.OPTIONS

              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
                 , CAR_RENTAL_COMPANY_CAR B
             WHERE 1=1
               AND A.CAR_ID = B.CAR_ID(+)
               AND B.CAR_TYPE = '트럭'
    ) X
    ORDER BY 4