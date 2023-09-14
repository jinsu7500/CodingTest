SELECT '/home/grep/src/'||A.BOARD_ID||'/'||A.FILE_ID||A.FILE_NAME||A.FILE_EXT
         AS FILE_PATH
  FROM USED_GOODS_FILE A
     , (
        SELECT *
          FROM (
                SELECT VIEWS AS MAX_VIEWS
                     , BOARD_ID
                  FROM USED_GOODS_BOARD 
                  -- GROUP BY BOARD_ID
                  ORDER BY 1 DESC
               )
        WHERE 1=1
          AND ROWNUM < 2
       ) B
 WHERE 1=1
   AND A.BOARD_ID = B.BOARD_ID
 ORDER BY A.FILE_ID DESC
 
