package FinalWorkJanaMara

import scala.io.StdIn.readLine

object FinalWorkTaskListManagerJanaMara extends App {
  //Database migration
  //created task object to call methods
  val db = new Task("user", "task")
  db.migrate()
  println("Final work assignment. TODO/TaskList manager. Authors: Jana Fedotova, Māra Skudrīte")
  val personsName = readLine("Welcome to TaskList manager. Please enter Your name:")
  db.printHelp()
  //Adding User to Database
  db.AddNewUserToDatabase(personsName)
  val selectionToDo = readLine(s"$personsName, please select what do You want to do in task manager:")
  if (selectionToDo.toLowerCase == "add") {
    val taskInput = readLine("Enter task, please:")
    val firstTask = new Task(personsName, taskInput)
    println(firstTask.getUserId(personsName))
    firstTask.addTaskToDB(personsName,taskInput)
    println("Your task have been added!")
  } else {
    if (selectionToDo.toLowerCase == "h") {
      db.printHelp()
    } else {
      if (selectionToDo.toLowerCase == "v") {
        println(db.printUserTasks(personsName))
      }
    }
  }

//TODO add loop to for reasking commands
  //TODO add new user support
}
