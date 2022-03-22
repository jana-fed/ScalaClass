import scala.io.StdIn.readLine

object Day4HealthExercise extends App {
  println("Temperature exercise")
  //TODO ask person for name
  //Ask for their temperature
  //if temperature is below 35 print "That is a bit too cold"
  //if temperature is between 35 and 37 (both sides inclusive) then print "You are all right!"
  //finally if the temperature is over 37 then print "You have a fever! Consider contacting a doctor"

  //consider what would be the best way to handle this logic
  val name = readLine("What is your name?")
  val temperature = readLine(s"What is your temperature $name?").toDouble
  val lowTemp = 35
  val highTemp = 37

  if (temperature < lowTemp) {
    println("That is a bit too cold")
  } else if (temperature >= lowTemp && temperature <= highTemp ) {
    println("You are all right")
  } else {
    println("You have a fever! Consider contacting a doctor")
    //here you could have instructions to send an SMS to your family doctor for example
  }

}
