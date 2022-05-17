package FinalWorkJanaMara

import sun.util.calendar.BaseCalendar.Date

import java.sql.{DriverManager, PreparedStatement, ResultSet, ResultSetMetaData}

case class Task(){

  def printHelp():Unit = {
    println("add <task> - add a to-do item")
    println("h - show this help text")
    //println("rm [task number] - remove a task by its number (lets make this last)")
    println("v - view the list of tasks")
    //println("q - quit (maybe we don’t need this)")
    //println("s - show tasks (on current date or all tasks)")
  }

  def viewTaskList():Unit = {
    //TODO add viewtask command from db
  }
  val url =  s"jdbc:sqlite:src/resources/taskmanager/taskmanager.db"

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
        |name TEXT NOT NULL
        |);
        |""".stripMargin

    statement.addBatch(sql)
    val sql1 =
      """
        |CREATE TABLE IF NOT EXISTS tasks (
        |id INTEGER PRIMARY KEY,
        |user_id INTEGER NOT NULL,
        |   FOREIGN KEY (user_id)
        |       REFERENCES users (id),
        |date TEXT
        |);
        |""".stripMargin

    statement.addBatch(sql1)
    statement.executeBatch()

  }
  def AddUserToDatabase(userName:String, userid:Int):Unit={
    val insertSql = """
                      |INSERT INTO users (user_id,user)
                      |values (?,?)
""".stripMargin
    val preparedStmt: PreparedStatement = conn.prepareStatement(insertSql)
    preparedStmt.setInt (1, userid)
    preparedStmt.setString (2, userName)

    preparedStmt.execute

    preparedStmt.close()
  }

  def getUserId(userName:String):Int = {
      val sql =
        """
          |SELECT id cnt FROM users u
          |WHERE name = ?
          |LIMIT 1;
          |""".stripMargin
      val preparedStmt: PreparedStatement = conn.prepareStatement(sql)

      preparedStmt.setString(1, userName)

      val rs = preparedStmt.executeQuery

      val id = rs.getInt(1) //just the first column not worrying about the column name
      preparedStmt.close()
      id
  }
  def addTaskToDB(userName:String, task:String, date: String):Unit = {
    val userid = getUserId(userName)
    val insertSql = """
                      |INSERT INTO tasks (user_id,task,date)
                      |values (?,?,?)
""".stripMargin
    val preparedStmt: PreparedStatement = conn.prepareStatement(insertSql)
    preparedStmt.setInt (1, userid)
    preparedStmt.setString (2, task)
    preparedStmt.setString (3, date)
    preparedStmt.execute

    preparedStmt.close()
  }
//  def showAllUsersTasks(userName:String):Array[Task]={
//    val sql =
//      """
//        |SELECT * FROM tasks t
//        |JOIN users u
//        |ON u.id = t.id
//        |GROUP BY winner
//        |ORDER BY wins DESC
//        |;
//        |""".stripMargin
//
//    val playerBuffer = ArrayBuffer[Player]() //so we start with an empty buffer to store our rows
//    val statement = conn.createStatement()
//    val rs = statement.executeQuery(sql)
//    while (rs.next()) {
//      val player = Player(rs.getString("name"), wins = rs.getInt("wins"))
//      playerBuffer += player
//    }
//    playerBuffer.toArray //better to return immutable values
//
// }

}
