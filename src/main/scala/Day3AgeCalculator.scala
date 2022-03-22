import java.time.Year
import scala.io.StdIn.readLine

object Day3AgeCalculator extends App {
  //TODO write an application that asks for person's and their age
  //Greet the person with their name
  //and calculate when they will be 100 years old and print it out
  //  val year = 2022 //this would be okay
  val targetAge = 100 // I could have asked for the target Age as well
  val myName = readLine("What is your name?")
  println(s"Hi $myName!")
  val smiley = '\u263a' // this is a hexadecimal value of the smiley
  val anotherSmiley = "😀" //each emoji has a numerical representation //we have a string of 1 character
  val anotherSmileyChar:Char = anotherSmiley(0) //first character in a string
  //  val myCat = "Kaķis Muris" //cat in Latvian

  println(s"This $smiley Unicode numerical value is ${smiley.toInt}")
  println(s"This $anotherSmiley Unicode numerical value is ${anotherSmileyChar.toInt}")


  val myAge = readLine("How old are you?").toDouble
  val year = Year.now.getValue
  val whenHundred = year - myAge + targetAge //we got rid of "magic" numbers
  val rounded = Math.round(whenHundred)
  //as soon as you use the same number in two or more places, consider making a val out of it

  println(s"Cool, you'll be $targetAge in $rounded  $smiley") //if i use string interpolation I do no ned to cast it


}

