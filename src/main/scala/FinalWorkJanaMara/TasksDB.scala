package FinalWorkJanaMara

import java.sql.{DriverManager, PreparedStatement, ResultSet, ResultSetMetaData}

class TasksDB(val dbPath: String) {

  val url =  s"jdbc:sqlite:$dbPath"

  val conn = DriverManager.getConnection(url) //TODO handle exceptions at connection time
  println(s"Opened Database at ${conn.getMetaData.getURL}")

  def migrate():Unit = {
    //migrate for db refers to table creation other setup needed to start work in a new enviroment
    //https://www.sqlitetutorial.net/sqlite-create-table/

    val statement = conn.createStatement() //we create a statement object that will handle sending SQL statements to the DB
    //this query should do nothing if table already exists
    val sql =
      """
        |CREATE TABLE IF NOT EXISTS users (
        |id INTEGER PRIMARY KEY,
        |name TEXT NOT NULL,
        |date TEXT
        |);
        |""".stripMargin

    statement.addBatch(sql)
    val sql1 =
      """
        |CREATE TABLE IF NOT EXISTS tasks (
        |id INTEGER PRIMARY KEY,
        |user_id INTEGER NOT NULL,
        |   FOREIGN KEY (user_id)
        |       REFERENCES users (id)
        |);
        |""".stripMargin

    statement.addBatch(sql1)
    statement.executeBatch()

  }
  def AddUsertoDatabase(user:String):Unit={
    //TODO create method add user
  }



}
