SELECT title FROM Movie as m LEFT JOIN checkout_item as ci ON m.id = ci.movie_id WHERE ci.movie_id is null;
SELECT title FROM Book as b LEFT JOIN checkout_item as ci ON b.id = ci.book_id WHERE ci.book_id is null;