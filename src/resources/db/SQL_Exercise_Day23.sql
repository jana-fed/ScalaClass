select * from customers c where country != "USA";
select * from customers c where country = 'Germany' ;
select * from employees e where title like "%Sales%Agent%";
select DISTINCT BillingCountry  from invoices i ;
SELECT a.Title Album, 
a2.Name Artist, t.Name SongName, t.GenreId ,g.Name 
FROM tracks t
JOIN albums a 
ON t.AlbumId = a.AlbumId
JOIN artists a2 
ON a.ArtistId = a2.ArtistId
JOIN genres g 
ON t.GenreId = g.GenreId  ;