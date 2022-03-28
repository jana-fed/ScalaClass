object Day5FizzBuzzMySolution extends App {
  //TODO
  //TODO create a FizzBuzz program based on children's game I think from Britain
  //for numbers 1 to 100 (included!)
  //print FizzBuzz if number divides evenly by both 5 and 7
  //print Fizz if number only divides by 5
  //print Buzz if number divides by 7
  //print number if number does not divide by 5 or 7
  //so something like this 1,2,3,4,Fizz,6,Buzz,..... 34,FizzBuzz,36,...., 99,Fizz (because 100 divides evenly by 5
  //printing can be done with number on new line like we have been doing
  val start = 0
  val end = 100
  val fizzBuzz = "FizzBuzz"
  val fizz = "Fizz"
  val buzz = "Buzz"
  val div1 = 5
  val div2 = 7
  val step = 1
  for (i <- Range.inclusive(start, end, step) ){
    if (i % div1 == 0 && i % div2 == 0)
    {println(s"$fizzBuzz")}
    else if (i % div1 == 0)
    {println(s"$fizz")}
    else if (i % div2 == 0)
    {println(s"$buzz")}
    else {println(s"The number is $i")}

  }
}
