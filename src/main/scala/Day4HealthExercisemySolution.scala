import scala.io.StdIn.readLine

object Day4HealthExercisemySolution extends App {
  println("Temperature execise")
  val temperature = readLine("What is Your temperature?").toDouble
  if (temperature < 35) {
    println("That is a bit too cold!")}
  else {if (temperature >= 35 && temperature <= 37) {println("You are all right!")}
  else println("You have a fever! Consider contacting a doctor")}


}