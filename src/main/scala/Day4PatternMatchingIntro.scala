import scala.util.Random

object Day4PatternMatchingIntro extends App {
  println("Short introduction to pattern matching")
  //https://docs.scala-lang.org/tour/pattern-matching.html

  val x: Int = Random.nextInt(10) //so i will have random values between 0 and 9 (not 10!)

  //so pattern matching can replace long if else if else if else chains - it can do more as well
  //  val txt = if (x==0) { "zero"
  //  } else if (x==1) {
  //    "one"
  //  } else if (x==2) {
  //    "two"
  //  } else { "other"}
  //the above is still relatively readable
  //but we could have a longer if else chain an then patern matching would be nicer..

  val txt = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case 3 => "three" //so very easy to add additional cases
    case _ => "other" //so default case
  }

  //so any time you have a long if else if else if chain consider using pattern matching


  println(s"So $x -> $txt")
}
