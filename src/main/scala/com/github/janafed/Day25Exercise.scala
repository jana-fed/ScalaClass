package com.github.janafed

import com.github.janafed.Day25DBConnection.conn

import java.sql.DriverManager
import scala.collection.mutable.ArrayBuffer


case class Album(albumId: Int, title:String, artistId: Int)
case class Track(trackId:Int, name:String, albumId:Int, mediaTypeId:Int, genreId:Int, composer:String, milliseconds:Int, bytes:Int, unitPrice:Double)

object Day25Exercise extends App {
  println("Testing Database connection")

  val dbPath = "src/resources/db/chinook.db"
  val url = s"jdbc:sqlite:$dbPath"

  println(s"Will connect SQlite database at the following url:  $url")

  val conn = DriverManager.getConnection(url) //TODO handle exceptions at connection time
  //https://docs.scala-lang.org/overviews/scala-book/try-catch-finally.html
  //Alvin has a nice example on how to connect to MySQL - different database but very similar
  //https://alvinalexander.com/scala/scala-jdbc-connection-mysql-sql-select-example/

  println(conn.getClientInfo())

  val statement = conn.createStatement() //we create a statement object that will handl sending SQL statements to the DB

  val sql =
    """
      |SELECT * FROM albums;
      |""".stripMargin

  val resultSet = statement.executeQuery(sql)
  val metaData = resultSet.getMetaData
  println(s"We have received ${metaData.getColumnCount} columns")
  for (i <- 1 to metaData.getColumnCount) {
    println(s"Column $i is named: ${metaData.getColumnName(i)}")
    println(s"Column $i comes from table: ${metaData.getTableName(i)}") //this would be important if we are using joins
  }
  val albumBuffer = ArrayBuffer[Album]()

  while (resultSet.next()) {
  val album = Album(resultSet.getInt("albumId"), resultSet.getString("Title"), resultSet.getInt("ArtistId"))
  albumBuffer += album
  }

  val albumCollection = albumBuffer.toArray
  albumCollection.take(5).foreach(println)

  val sql2 =
  """
    |SELECT * FROM tracks;
    |""".stripMargin

  val resultSettracks = statement.executeQuery(sql2)
  val metaDatatracks = resultSettracks.getMetaData

  val trackBuffer = ArrayBuffer[Track]()
  while (resultSet.next()) {
    val track = Track(resultSettracks.getInt("TrackId"),
                      resultSettracks.getString("Name"),
                      resultSettracks.getInt("AlbumId"),
                      resultSettracks.getInt("MediaTypeId"),
                      resultSettracks.getInt("GenreId"),
                      resultSettracks.getString("Composer"),
                      resultSettracks.getInt("Milliseconds"),
                      resultSettracks.getInt("Bytes"),
                      resultSettracks.getDouble("UnitPrice"))
    trackBuffer += track
  }

  val trackCollection = trackBuffer.toArray
  trackCollection.take(5).foreach(println)
  conn.close()
  //Extra Challenge
  //TODO save all Tracks into CSV - in src/resources/csv/tracks.csv -
  // results should be very similar or identical to what you get in DBeaver export CSV - tracks_exported.csv
  //Check Day 20 examples on how we did this
  val fileName = "tracks.csv"
  val dstFolder = "src/resources/csv"
  val dst = s"$dstFolder/$fileName"
  val tracksStrings = trackCollection.map(_.toString)

  MyUtil.saveLines(dst,tracksStrings)

}
