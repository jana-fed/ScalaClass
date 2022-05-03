--TODO
--CREATE YOUR OWN genre of music
INSERT INTO genres (Name)
VALUES ('Christmas');
SELECT * FROM genres g ;
--CREATE artist Yourself or someone real or imagined
INSERT INTO artists (Name)
VALUES ('Mariah Carey');
SELECT * FROM artists a ;
--CREATE album
INSERT INTO albums (Title, ArtistId)
VALUES ('Merry Christmas', 276);
SELECT * FROM albums a ;

--CREATE 2 tracks from that album that use your own genre of music
INSERT INTO tracks (Name, AlbumId, MediaTypeId, 
GenreId, Composer, Milliseconds,
Bytes, UnitPrice)
VALUES ('All I Want For Christmas is You', 348, 1,26 ,'Mariah Carey', 141000, 1300000, 3.99 );
INSERT INTO tracks (Name, AlbumId, MediaTypeId, 
GenreId, Composer, Milliseconds,
Bytes, UnitPrice)
VALUES ('Silent Night', 348, 1,26 ,'Mariah Carey', 280000, 1300000, 3.99 );
SELECT * FROM tracks t WHERE AlbumId  = 348;


--UPDATE one of the tracks to be opera genre
UPDATE tracks 
SET GenreId = 25
WHERE TrackId = 3505;
--DELETE the opera track 
DELETE FROM tracks 
WHERE TrackId = 3505;

--SELECT show your track joining it together with genre, album and artist
--like we did in a previous lecture

SELECT * FROM tracks t 
JOIN albums a 
ON t.AlbumId = a.AlbumId
JOIN artists a2 
ON a.ArtistId = a2.ArtistId
JOIN genres g 
ON t.GenreId = g.GenreId
WHERE TrackId = 3504;

