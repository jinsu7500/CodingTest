  SELECT Z.MEMBER_NAME                                AS MEMBER_NAME
       , M.REVIEW_TEXT                                AS REVIEW_TEXT
       , TO_CHAR(M.REVIEW_DATE,'YYYY-MM-DD')          AS REVIEW_DATE       
    FROM REST_REVIEW M       
       , (
         SELECT X.CNT
              , X.MEMBER_ID
           FROM
              (
                SELECT COUNT(A.MEMBER_ID)   AS CNT
                     , A.MEMBER_ID
                  FROM REST_REVIEW A
                 WHERE 1=1  
                  GROUP BY A.MEMBER_ID                
              ) X
             , (
                SELECT MAX(COUNT(A.MEMBER_ID)) AS MAX_CNT
                  FROM REST_REVIEW A
                 GROUP BY A.MEMBER_ID
               ) Y
         WHERE 1=1
           AND X.CNT = Y.MAX_CNT
         ) N 
      , MEMBER_PROFILE Z
  WHERE 1=1
   AND M.MEMBER_ID = N.MEMBER_ID
   AND M.MEMBER_ID = Z.MEMBER_ID
 ORDER BY REVIEW_DATE ASC
        , REVIEW_TEXT ASC

  
  
  