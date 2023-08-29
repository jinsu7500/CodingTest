-- -- 코드를 입력하세요
SELECT A.CATEGORY
     , A.PRICE AS MAX_PRICE
     , A.PRODUCT_NAME
  FROM FOOD_PRODUCT A
     , (
         SELECT X.CATEGORY
             , MAX(X.PRICE) AS MAX_PRICE
          FROM FOOD_PRODUCT X
         WHERE 1=1
           AND X.CATEGORY IN ('과자','국','김치','식용유')
         GROUP BY X.CATEGORY
       ) X
 WHERE 1=1
   AND A.CATEGORY = X.CATEGORY
   AND A.PRICE = X.MAX_PRICE
 ORDER BY A.PRICE DESC
      
        


