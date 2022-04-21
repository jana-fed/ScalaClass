package com.github.janafed

import scala.util.matching.Regex

object Day19ExerciseExtractYearsMySolution extends App {
  //TODO extract all years into a Array(or list or vector) of Integers
  //From the following src
  val src="src/resources/Alchemist_Ben_Johnson.txt" //you can choose another text if you wish

  val linesWithYears = MyUtil.getLinesFromFile(src)
  val regexYear = raw"\D*(\d{4})\D*".r
  def extractYear(line:String, regexYear: Regex = regexYear):Unit= {
    line match {
      case regexYear(year) => year.toInt
      case _ => None
    }
  }
  val yearsArray = linesWithYears.map(l => extractYear(l).toString.toInt)
  println(yearsArray.mkString)
  //you can test your regex here first: https://regex101.com/ or somewhere else

}
