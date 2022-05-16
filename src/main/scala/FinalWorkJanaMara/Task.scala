package FinalWorkJanaMara

import sun.util.calendar.BaseCalendar.Date

case class Task(){

  def addTasktoDB(user:String, task:String, date: String):Unit = {
    //TODO make add task command
  }
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
}
