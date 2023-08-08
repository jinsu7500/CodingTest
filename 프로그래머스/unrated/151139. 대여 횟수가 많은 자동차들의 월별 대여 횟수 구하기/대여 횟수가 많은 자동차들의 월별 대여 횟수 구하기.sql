-- 코드를 입력하세요
SELECT 
      TO_NUMBER(TO_CHAR(A.START_DATE , 'MM')) AS MONTH
    , A.CAR_ID
    , COUNT(A.CAR_ID) AS RECORDS

FROM (
    SELECT  A.CAR_ID     
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
     WHERE 1=1
       AND TO_CHAR(A.START_DATE,'YYYYMM') >= '202208' 
       AND TO_CHAR(A.START_DATE,'YYYYMM') <= '202210'   
     GROUP BY A.CAR_ID
    HAVING COUNT(A.CAR_ID) >= 5
        ) X -- 총건수 5건 이상 차량번호
    , CAR_RENTAL_COMPANY_RENTAL_HISTORY  A
WHERE 1=1
  AND A.CAR_ID = X.CAR_ID
  AND TO_CHAR(A.START_DATE,'YYYYMM') >= '202208' 
  AND TO_CHAR(A.START_DATE,'YYYYMM') <= '202210' 
  GROUP BY TO_NUMBER(TO_CHAR(A.START_DATE , 'MM'))
        , A.CAR_ID
ORDER BY TO_NUMBER(TO_CHAR(A.START_DATE , 'MM'))
       , A.CAR_ID DESC

