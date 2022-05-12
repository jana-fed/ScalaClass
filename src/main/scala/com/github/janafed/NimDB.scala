package com.github.janafed

import java.sql.{DriverManager, PreparedStatement, ResultSet, ResultSetMetaData}

class NimDB(val dbPath: String) {

  val url =  s"jdbc:sqlite:$dbPath"

  val conn = DriverManager.getConnection(url) //TODO handle exceptions at connection time
  println(s"Opened Database at ${conn.getMetaData.getURL}")

  /**
   * Perform table migration in a new installation, does nothing otherwise
   */
  def migrate():Unit = {
    //migrate for db refers to table creation other setup needed to start work in a new enviroment
    //https://www.sqlitetutorial.net/sqlite-create-table/

    //TODO created multiple tables with users in one table
    //so when we do insert we will reference the users table in our results table

    val statement = conn.createStatement() //we create a statement object that will handl sending SQL statements to the DB

    //this query should do nothing if table already exists
    val sql =
      """
        |CREATE TABLE IF NOT EXISTS results (
        |id INTEGER PRIMARY KEY,
        |winner TEXT NOT NULL,
        |loser TEXT NOT NULL,
        |created TEXT
        |);
        |""".stripMargin

    //    statement.executeQuery(sql) //so Query for selects
    statement.execute(sql)

    //TODO add another sql statement that creates scores table if it does not exist
    //this table should have the following columns
    //id, game_id, turn, move, created
    //id is the primary key
    //it should have game_id column that will be referencing our results table - so called Foreign Key
    //also it should have turn column that will store game turn (starting from 1) for a specific game
    //finally we store move column
    //also lets store a created column as well -this will use autamtic timestamp later
//    val statement2 = conn.createStatement()
//    val sql2 =
//      """
//      |CREATE TABLE IF NOT EXISTS scores (
//      |id INTEGER PRIMARY KEY NOT NULL,
//      |game_id INTEGER FOREIGN KEY NOT NULL,
//      |turn INTEGER NOT NULL,
//      |move INTEGER NOT NULL,
//      |created TEXT,
//      |);
//      |""".stripMargin
//
//    statement2.execute(sql2)
  }

  def insertResult(winner:String,loser:String):Unit = {
    //we want to avoid inserting unprepared values
    //https://xkcd.com/327/

    //https://alvinalexander.com/source-code/scala-jdbc-sql-select-insert-statement-resultset-preparedstatement-example/

    val insertSql = """
                      |INSERT INTO results (winner,loser,created)
                      |values (?,?,CURRENT_TIMESTAMP)
""".stripMargin
    //CURRENT_TIMESTAMP is in SQL standard: https://stackoverflow.com/questions/15473325/inserting-current-date-and-time-in-sqlite-database

    val preparedStmt: PreparedStatement = conn.prepareStatement(insertSql)

    preparedStmt.setString (1, winner)
    preparedStmt.setString (2, loser)
    preparedStmt.execute

    preparedStmt.close()
  }

  //TODO create insertScore method
  //parameters will be Array[Int] of moves
  //also we will want a reference to the game id
  def getIdOfLastGame():Int = {
    val statement = conn.createStatement()
    val sql =
      """
        |SELECT MAX(id)
        |  FROM results;
        |""".stripMargin
    val resultSet = statement.executeQuery(sql)
    val lastGameId = resultSet.getMetaData.toString
    lastGameId
  }
//  def insertScore(moves:Array[Int], game_id:Int):Unit={
//    val insertSqlmoves = """
//                      |INSERT INTO scores (turn, moves, created)
//                      |values (?,?,CURRENT_TIMESTAMP)
//""".stripMargin
//    val preparedStmt: PreparedStatement = conn.prepareStatement(insertSqlmoves)
//
//    preparedStmt.setString (1, winner)
//    preparedStmt.setString (2, loser)
//    preparedStmt.execute
//
//    preparedStmt.close()
//  }

  //TODO we need to create a helper method to get the id of the last game played in results
  //this assumes we save the game result first
  //https://stackoverflow.com/questions/5191503/how-to-select-the-last-record-of-a-table-in-sql
  //so we we will store moves for all games in a single table,
  //id, game_id, turn, move, created
  //1, 1, 1, 3, 2022-05-12etc
  //2, 1, 2, 2, 2022
  //...
  //8, 2, 1, 3, 2022
  //9, 2, 2, 1, 2022
  //10, 2, 3, 2, 2022
  //

}

