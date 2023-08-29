-- 코드를 입력하세요
SELECT A.REST_ID
     , A.REST_NAME
     , A.FOOD_TYPE
     , A.FAVORITES
     , A.ADDRESS
     , B.SCORE
  FROM REST_INFO A
     , (
         SELECT B.REST_ID
              , ROUND(SUM(B.REVIEW_SCORE) / COUNT(*) ,2) AS SCORE
           FROM REST_REVIEW B
          GROUP BY REST_ID
       ) B
 WHERE 1=1
   AND A.REST_ID = B.REST_ID
   AND A.ADDRESS LIKE '서울%'
 ORDER BY B.SCORE DESC
        , A.FAVORITES DESC
   ;


 