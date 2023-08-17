SELECT a.member_name
     , b.review_text
     , to_char(b.review_date, 'YYYY-MM-DD') AS review_date
  from member_profile a
,rest_review b
    
 where 1=1
  and  a.member_id = b.member_id
  and a.member_id in (select member_id
                         from rest_review
                        group by member_id
                        having count(*) = (select max(count(*))
                                             from rest_review
                                            group by member_id))
order by 3, 2