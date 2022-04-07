package com.github.janafed

import scala.io.StdIn.readLine

object Day15WeekdayExercise extends App {
  def getDay(day:Int):String = {
    day match {
      case 1 => "Monday"
      case 2 => "Tuesday"
      case 3 => "Wednesday"
      case 4 => "Thursday"
      case 5 => "Friday"
      case 6 => "Saturday"
      case 7 => "Sunday"
      case _ => "Unknown Weekday"
    }
  }
  //TODO write a function getDay(day: Int): String that returns day of the week in English Monday, Tuesday and so on until Sunday
  //Given an index 1 to 7
  //if value is outside you return Unknown Weekday

  //TODO write a function getDayType(day: String): String
  // that returns "Workday" for "Monday" to "Friday" and "Weekend" for "Saturday" and "Sunday"
  // default can be "Groundhog Day" or something equally silly

  def getDayType(day: String):String = {
    day.capitalize match {
      case "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" => "Workday"
      case "Saturday" | "Sunday" => "Weekday"
      case _ => "Groundhog Day"
    }
  }
  //TODO test the functions with some data!

  val daynumber = readLine("Enter day number ").toInt
  println(getDay(daynumber))
  println(getDay(9))

  val daytype = readLine("Enter day ")
  println(getDayType(daytype))
}