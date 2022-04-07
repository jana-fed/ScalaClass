package com.github.janafed

import scala.io.StdIn.readLine

object InputHandling extends App {
  val myName = readLine("What is your name friend?")
  println(s"Cool your name is $myName, isn't it ?")
  val potatoCount = readLine("How many kg of potatoes do you have?").toDouble //we can cast immediately
  println(s"Cool you have $potatoCount kg of potatoes")
  val cost = 0.55
  //if potatoCount is already double we do not need the cast
  val total = potatoCount * cost //possible to also use toInt (if we do not care about fractional kg
  val rounded = Math.round(total * 100) / 100.0 //it is a little trick to have two digits of precision
  println(s"Without rounding $total")
  println(s"So those must have cost you $rounded Euros")

  //we could use a full syntax but that would get old fast wouldn't it ?
  //  val myGreeting = scala.io.StdIn.readLine("enter a custom greeting")
}
