object Day5FizzBuzzExercise extends App {
  //TODO
  //TODO create a FizzBuzz program based on children's game I think from Britain
  //for numbers 1 to 100 (included!)
  //print FizzBuzz if number divides evenly by both 5 and 7
  //print Fizz if number only divides by 5
  //print Buzz if number divides by 7
  //print number if number does not divide by 5 or 7
  //so something like this 1,2,3,4,Fizz,6,Buzz,..... 34,FizzBuzz,36,...., 99,Fizz (because 100 divides evenly by 5
  //printing can be done with number on new line like we have been doing
  //think about making it more universal - that is allow different Fizz, Buzz, start, end values
  val fizzNum = 5
  val fizzText = "Fizzy"
  val buzzNum = 7
  val buzzText ="Buzzy"
  val start = 20
  val end = 75

  var textBuffer = "" //for longer strings it should actually be StringBuffer type
  for (n <- start to end) {
    if (n % fizzNum == 0 && n % buzzNum == 0) {
      print(fizzText+buzzText)
      textBuffer += fizzText+buzzText
    } else if (n % fizzNum == 0) {
      print(fizzText)
      textBuffer += fizzText

    } else if (n % buzzNum == 0) {
      print(buzzText)
      textBuffer += buzzText
    } else {
      print(n) //when printing I do not need to convert to String, because print will do it for us
      textBuffer += n.toString //we need to convert the number to string before string concatenation
    }
    if (n < end) {
      print(",")
      textBuffer += ","
    }
  }
  println("") //so newline
  //  println("*"*40) //just some stars as divider
  println(textBuffer)

  println("Now with While Loop")

  val step = 1
  var n = start
  textBuffer = "" //i need to reset text Buffer since I had some stuff from for Loop
  while (n <= end) {
    if (n % fizzNum == 0 && n % buzzNum == 0) {
      print(fizzText+buzzText)
      textBuffer += fizzText+buzzText
    } else if (n % fizzNum == 0) {
      print(fizzText)
      textBuffer += fizzText

    } else if (n % buzzNum == 0) {
      print(buzzText)
      textBuffer += buzzText
    } else {
      print(n) //when printing I do not need to convert to String, because print will do it for us
      textBuffer += n.toString //we need to convert the number to string before string concatenation
    }
    if (n < end) {
      print(",")
      textBuffer += ","
    }
    //in a while loop it is crucial that we increase whatever we are checking in while condition here it is n
    n += step //so while loop is a bit longer to write
  }
  println("")
  println(textBuffer)
}
