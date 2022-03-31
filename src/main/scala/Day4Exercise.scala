import scala.io.StdIn.readLine

object Day4Exercise extends App {
  println("Christmas bonus calculator")
  val Name = readLine("What is Your name?")
  val WorkYears = readLine("How many years are you working in your firm?").toInt
  val Wage = readLine("And what is Your monthly wage?").toInt
  val bonusPercent = 0.15
  if (WorkYears > 2) {
    val Bonus = Math.round((WorkYears - 2) * bonusPercent * Wage)*100/100.00
    println(s"Your Christmas bonus is $Bonus")
  }
  else { println("You don't get a bonus!")}
}