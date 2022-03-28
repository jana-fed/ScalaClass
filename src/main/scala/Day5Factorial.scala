import scala.io.StdIn.readLine

object Day5Factorial extends App {
  println("Calculating Factorial")
  val number = readLine("What positive integer you want to know Factorial for?").toInt
  println(s"Calculating Factorial for $number")

  var result:Long = 1 //important not to put 0 for multiplication right? because everything multiplied by 0 will be 0
  //we are using Long integer because factorials get big pretty fast

  for (n <- 2 to number) result *= n //result = result * n and n is integer but result will remain long int

  println(s"Factorial of $number is $result")

  //turns out even with Long ints we can't really calculate bigger factorial
  //solution for bigger numbers is to use Big Number libraries
}
