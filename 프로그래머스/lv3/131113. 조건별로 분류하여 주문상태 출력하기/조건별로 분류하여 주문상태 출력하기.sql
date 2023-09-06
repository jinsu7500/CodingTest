-- 코드를 입력하세요
SELECT A.ORDER_ID
     , A.PRODUCT_ID
     , TO_CHAR(A.OUT_DATE,'YYYY-MM-DD') AS OUT_DATE
     , CASE WHEN TO_CHAR(A.OUT_DATE,'YYYYMMDD') <= '20220501' THEN '출고완료'
            WHEN TO_CHAR(A.OUT_DATE,'YYYYMMDD') > '20220501'  THEN '출고대기'
            ELSE '출고미정'
            END AS "출고여부"
 FROM FOOD_ORDER A
 ORDER BY A.ORDER_ID
   