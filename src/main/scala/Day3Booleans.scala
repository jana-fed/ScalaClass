object Day3Booleans extends App {
  println("Hello Booleans")
  val isLate = true
  val isSunny = false
  println(isLate, isSunny)
  val isMathCorrect = 2*2 == 4
  println(s"Math 2*2==4 looks fine: $isMathCorrect")
  val myName = "Jana"
  println("IS my name Jana?", myName == "Jana")

  println("5>10",5>10)
  println("5*5<20", 5*5<20)
  println("10<=2*5", 10<=2*5)
  println("8>=14/2", 8>=14/2)
  val a=2
  val b=4
  println("a*a=b", a*a==b)
  println("a*a!=b", a*a!=b)
}
