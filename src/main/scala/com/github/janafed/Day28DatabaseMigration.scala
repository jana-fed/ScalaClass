package com.github.janafed

object Day28DatabaseMigration extends App {

  val db = new NimDB("src/resources/nim/nim.db")

  db.migrate()

  db.insertResult("Alice", "Bob")
  db.insertResult("Carol", "Dave")
  val lastGamesId = db.getIdOfLastGame()
  db.insertScore()
  //cleanup
  db.conn.close()

}
