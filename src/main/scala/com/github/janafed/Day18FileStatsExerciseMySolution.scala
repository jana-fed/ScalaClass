package com.github.janafed

object Day18FileStatsExerciseMySolution extends App {
  val url = "https://www.gutenberg.org/cache/epub/4081/pg4081.txt"
  val dst = "src/resources/Alchemist_Ben_Johnson.txt"
  val text = MyUtil.getTextFromWebAndSave(url, dst)
  //println(text.take(100))
  val charcount = MyUtil.getCharacterCount(text.split("/n"))
  println(s"Total amount of characters is $charcount")
  val textlines = MyUtil.getLinesFromFile(dst)
  val linecount = textlines.length
  println(s"Total amount of lines is $linecount")
  val wordCount = MyUtil.getWordCountPerLine(textlines).sum
  println(s"Total word count is $wordCount")
  val avgCount = MyUtil.myRound(wordCount/linecount,2)
  println(s"The average word count in each line is $avgCount")
  //TODO download and save a text file of your choosing from gutenberg.org
  //Get Character Count (including whitespace)
  //Get Line Count
  //get Word Count
  //Get average Word Count in each text line

  //You can use the Util functions or maybe add some of your own if you want
}
