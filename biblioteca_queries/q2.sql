 SELECT name FROM member as m where m.id not in (SELECT member_id from checkout_item);
 