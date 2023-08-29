-- 코드를 입력하세요
SELECT A.PRODUCT_ID
     , B.PRODUCT_NAME
     , SUM((A.AMOUNT * B.PRICE)) AS TOTAL_SALES

  FROM FOOD_ORDER A
     , FOOD_PRODUCT B
WHERE 1=1
  AND A.PRODUCT_ID = B.PRODUCT_ID
  AND TO_CHAR(A.PRODUCE_DATE , 'YYYYMM') = '202205'
GROUP BY A.PRODUCT_ID
       , B.PRODUCT_NAME       
ORDER BY TOTAL_SALES DESC
       , A.PRODUCT_ID ASC