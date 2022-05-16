package FinalWorkJanaMara

import scala.io.StdIn.readLine

object FinalWorkTaskListManagerJanaMara extends App {
  //Database migration
  val db = new TasksDB("src/resources/taskmanager/taskmanager.db")
  db.migrate()
  println("Final work assignment. TODO/TaskList manager. Authors: Jana Fedotova, Māra Skudrīte")
  val personsName = readLine("Welcome to TaskList manager. Please enter Your name:")
  val firstTask = new Task
  firstTask.printHelp()
  val selectionToDo = readLine(s"$personsName, please select what do You want to do in task manager:")



}
