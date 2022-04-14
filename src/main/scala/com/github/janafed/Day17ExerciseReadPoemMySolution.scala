package com.github.janafed

import com.github.janafed.MyUtil.getLinesFromFile

import scala.io.Source

object Day17ExerciseReadPoemMySolution extends App {

  println(System.getProperty("user.dir"))
  //val filePath = "C:\\Users\\janap\\Documents\\ScalaClass\\src\\resources\\stopping_by"
val filePath: String = "src/resources/stopping_by"
  val poem = getLinesFromFile(filePath)
  val poemsname = poem.head.mkString
  println(s"Poems name is: $poemsname")

  val poemsAuthor = poem(1).drop(3).mkString
  println(s"Poems author is: $poemsAuthor")

  println("All lines that contains woods:")
  val woodLine = poem.filter(_.contains("woods"))
  woodLine.foreach(println)
  //TODO read stopping by poem from src/resources/stopping_by.txt
  //TODO get poem name - it is the first line
  //TODO get poet - it is in the 2nd line but we want just the poet

  //TODO Get all lines which contain "woods" somewhere in the text
  //so instead of startsWith we use contains


}
