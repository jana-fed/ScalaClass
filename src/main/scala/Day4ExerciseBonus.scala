import scala.io.StdIn.readLine

object Day4ExerciseBonus extends App {
  println("Xmas bonus calculator")
  //TODO
  //Ask for a person's name
  //Ask for how long they have worked at the firm
  //Ask for the monthly wage
  //Calculate Xmas bonus if they have worked at least 2  years otherwise print sorry no bonus
  //Bonus is years worked over 2 years * 15% of monthly wage
  //so 5 years worked, 1000 Euros wage would give 450 Euro bonus (3 years * 150)
  val yearsWithoutBonus = 2 //two word value would be even better
  val percentageBonus = 0.15

  println("Christmas bonus calculator")


  //  println("Please enter your name:")
  val personsName = readLine("Please enter your name:\n") // i can use \n for newline to force entry on new line
  println(s"Hello, $personsName! Please enter how many years you are working at this firm:")
  val workingYears = readLine().toInt //so here you would need to decide whether a person is allowed to enter partial years worked
  println(s"Great, $personsName! Please enter your monthly wage:")
  val monthlyWage = readLine().toDouble

  if (workingYears > yearsWithoutBonus) {
    val bonusMoney = (monthlyWage * percentageBonus) * (workingYears-yearsWithoutBonus)
    val roundedBonus = Math.round(bonusMoney*100) / 100.0 //remember floats/doubles can have tiny imprecisions 17 digits after comma..
    //by dividing by 100.0 (which is a double floating point number) we force the result to be a double precision float
    println(s"Your monthlyWage: $monthlyWage, your Christmas bonus: $bonusMoney -> rounded $roundedBonus")
  } else { //so this means workingYears is <= yearsWithoutBonus
    println(s"$personsName, sorry this year you have no bonuses :(")
  }

  //Scale lets you do this insanity but I do not recommend this method
  println(if (workingYears > yearsWithoutBonus) s"Your Bonus ${(monthlyWage * percentageBonus) * (workingYears-yearsWithoutBonus)}" else "Sorry no Bonus")

}

