package com.github.janafed

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Document(title: String, author:String, url:String, rows:Array[String]=Array[String]()){
  val rowCount:Int = rows.length
  val wordCount: Int = MyUtil.getWordCountPerLine(rows).sum
  println(s"The document has $rowCount rows and $wordCount words.")
  //TODO create Document class (or case class whichever you prefer)
  //class should contain following constant fields to be passed as parameters upon creation:
  // title:String = ""
  // author:String = ""
  // url:String = ""
  // rows:Array[String] = Array[String]()

  // TODO upon creation in constructor (main body of class) - the following constant fields should be created
  // rowCount:Int - rows.length
  // wordCount:Int - contains a count of all the words in rows

  def save(dst:String="", folder:String="src/resources/texts"):Unit={
    val stringBuilder = new StringBuilder()
    //stringBuilder ++= rows.head
    stringBuilder += '\n'
    stringBuilder ++= s"URL: $url"
    stringBuilder += '\n'
    stringBuilder ++= s"Author: $author"
    stringBuilder += '\n'
    stringBuilder ++= s"Title: $title"
    stringBuilder += '\n'*3
    stringBuilder ++= rows.mkString
    val timeStamp = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm").format(LocalDateTime.now())
    if (dst.nonEmpty) {
      val newdst = dst + "_"++ timeStamp
      MyUtil.saveText(s"src/resources/texts/$newdst.txt",stringBuilder.mkString)}
    else
      {if (author.nonEmpty && title.nonEmpty) {
        if (author.length <= 10 && title.length <= 15) {
          val newdst = author ++ "_" ++ title ++ "_" ++ timeStamp
          MyUtil.saveText(s"src/resources/texts/$newdst.txt",stringBuilder.mkString)
          }else {
          val newdst: String = author.take(10) + "_" ++ title.take(15) ++ "_" ++ timeStamp
        MyUtil.saveText(s"src/resources/texts/$newdst.txt",stringBuilder.mkString)}
      }else {println("There isn't author or title! Couldn't save file.")}}

  }}
//TODO add a single method save(dst:String = "", folder:String="src/resources/texts"):Unit
//will write to the folder/dst file - remember to add the extra slash
//will write s"URL: $url" as first row
// similarly will write Author: actual author as 2nd row
//will write Title: title as 3rd row
//will write 3 newlines
//will will write all rows
//if dst is empty string - create a file name
//if author AND title are non empty -
//create file name such as Doyle_Adventures.txt (10 letters max from author, 15 letters max from title
// bonus - add timestamp in file name
// something like this Doyle_Adventures_2022_4_16_15_06.txt
// https://stackoverflow.com/questions/48378006/how-to-get-current-timestamp-in-scala-as-a-string-without-spaces

object Day19DocumentReadingExercise extends App {

//  val timeStamp = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm").format(LocalDateTime.now())
//  println(timeStamp)
//  val docCheck = new Document("Check", "Jana Fedotova", "facebook.com")
//  println(docCheck.rowCount)
//  println(docCheck.wordCount)
//  docCheck.save()
  //val weblines = MyUtil.getLinesFromFile()
//Checking system arguments
  var filePath = ""
  if (args.length == 0) {
    filePath = "src/resources/texts/webPages.txt"} else {
    filePath = "src/resources/" ++ args(0) ++ ".txt"}

  def getDocumentFromUrl(website:String):Document={ //for gutenberg books
    val rows = MyUtil.getTextFromWeb(website).split("\n")
    val title = GutenbergUtil.getTitle(rows)
    val author = GutenbergUtil.getAuthor(rows)
    if (website.contains("gutenberg.org")) {
    val doc = new Document(title,author,website,rows)
    doc
    }
    else {val doc = new Document("Notitle", "NoAuthor", website, rows)
    doc} //I
  }

//  val ex = getDocumentFromUrl("https://www.gutenberg.org/files/345/345-0.txt")
//  ex.save() //checked if save method works

  def addPrefixToLine(web:Array[String], prefix:String = "https://"):Array[String] = {
    val webarray = scala.collection.mutable.ArrayBuffer[String]()
    for (w <- web) {
    if (w.contains(prefix)) {
      val ww = w
      webarray += ww
    } else {
      val ww = prefix ++ w
      webarray += ww
    }
    }
  webarray.toArray
  }

  var urls = addPrefixToLine(MyUtil.getLinesFromFile(filePath)) //saving website from file to lines
  urls.foreach(println)


  val docs = urls.map(u => getDocumentFromUrl(u))
  for (d <- docs) {
    d.save()
    Thread.sleep(200)
  }

  //TODO create a program that reads web addresses from a file and downloads multiple files with some changes
  //check for system arguments (see Day14commandArguments )
  //use first argument as filePath to process
  //otherwise default filePath will be src/resources/webPages.txt

  //TODO read all lines from filePath
  //assume each line is one URL
  //bonus: add https:// prefix if one is not present in each line - if http:// OR https:// is present DO NOTHING

  //TODO read all URLs - save into array of Document objects
  //TODO call save method on all members of the array
  //you can let save figure out the names automatically (if you made this functionality)
  //or you can pass some dst name here as well
  //Use slight delay between each URL read such as  Thread.sleep(200) //200ms delay

  //TODO test it by creating your own 10 URL text file (can use Project Gutenberg can use some other sites and saving it as src/resources/webPages.txt


}
