-- 코드를 입력하세요
SELECT X.*
FROM (
    SELECT A.PRODUCT_ID
         , A.PRODUCT_NAME
         , A.PRODUCT_CD
         , A.CATEGORY
         , A.PRICE
      FROM FOOD_PRODUCT A
     WHERE 1=1 
     ORDER BY A.PRICE DESC
     ) X
WHERE 1=1
  AND ROWNUM < 2

--AND A.PRICE = MAX(A.PRICE)
  