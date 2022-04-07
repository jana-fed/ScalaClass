package com.github.janafed

object Day2Variables extends App {
  println("Let's explore some variables") //we are printing is not very useful comment right ? :)
  //we want to store some data while we work
  //for that we need variables
  //but first these are comments
  //comments are only for people not for computers
  /* this is multi
    line comment
    those are used less usually for documentation with extra symbols,
   */
  //when you are learning it is fine to make extra comments
  //one problem with comments is that they can fail to keep up with the code
  //that is the worst
  //comment says one thing
  //code says something else
  //and you are trying to figure out which one is right
  //then version control might help
  //even worse then you realize that it was you who wrote it 6 months ago :)
  //our human brains can only keep 6-8 concepts in our short-term memory at once
  val myName = "Valdis" //I create a new value myName and assign string literal "Valdis" to it
  println(myName)
  //val in Scala stands for value and those constants, meaning whatever object we create it stays
  //  myName = "Valdas" not allowed I'd have to make  var
  var myJob = "teacher"
  println(myJob)
  myJob = "lecturer" //this is completely normal variables can be changed
  println(myJob)
  //so try to make everything val initially and only when really needed you go to vars

  //so in Scala all values and variables have STATIC data types assigned at birth when we first declare them
  //  myJob = 9000 we can not do it because we have myJob as a string data type
  val myCar: String = "VW" //data type can be explicitly mentioned  but not required

  //so far we have seen two data types String and Integer
  //lets look at some more primitives
  val myNumber = 42 //so that is an Int - stands for Integer / Whole number no fraction
  val myPi = 3.1415926 //this will be Double which is Double precision Float
  val bigNum = 2_000_000_000 //we can use _ as separates just for human readability underscores are not required
  println(bigNum)
  val reallyBigNum = bigNum * 3 //here I assigne reallyBigNum to 3 times the value of bigNum
  println(reallyBigNum) //hmm what is going on here... why not 6Billion ???
  println(Math.pow(2, 32)) // we have room for 4Billion and something numbers in 32 bits
  println(bigNum + 500_000_000) // we need 1 bit for sign
  println(Math.pow(2, 31)) // so that is maximum that we can represent as positive integer
  //E9 that meaans the number to the left * 1_000_000_000 (9 zeroes)

  //therefore for bigger number we use Long data type which is a 64 bit Integer
  val myLongVal = 8_000_000_000L // I write L to indicate that it is an Long Integer
  println(myLongVal)
  println(Math.pow(2, 63)) //that is the limit for Long integers positive side, same for negative

  val isLate = true // this is a boolean
  val isTired = false //also a boolean
  println(isLate, isTired) //we can print multiple values with one println
  //we can use .getClass to see the data type of the object
  println(myName.getClass, myNumber.getClass, myPi.getClass, myLongVal.getClass, isLate.getClass)
  //so the String actually comes from, rest of the data types are internal to Scala

  //next time we look at what we can do at the most basic building blocks of our data types
  //namely booleans - true and false what are they useful for
  //also we will look at data conversion

}
