package com.github.janafed

object Day28DatabaseMigration extends App {

  val db = new NimDB("src/resources/nim/nim.db")

  db.migrate()

  db.insertResult("Alice", "Bob")
  db.insertResult("Carol", "Dave")
  println(db.getIdOfLastGame())
  //cleanup
  db.conn.close()

}
