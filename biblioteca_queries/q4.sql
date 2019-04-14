INSERT INTO Book VALUES(11, 'The Pragmatic Programmer');
INSERT INTO Member VALUES(400, 'Irene Ginani');
INSERT INTO checkout_item VALUES(400, 11, NULL);
SELECT name FROM member as m INNER JOIN checkout_item on checkout_item.member_id = m.id INNER JOIN book on book.id = checkout_item.book_id and book.title = "The Pragmatic Programmer";