SELECT name, COUNT(name) FROM member INNER JOIN checkout_item ON member.id = checkout_item.member_id 
GROUP BY name;