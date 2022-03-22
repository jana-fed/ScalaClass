import scala.io.StdIn.readLine

object Day9WordLengthExercise extends App {
  //TODO ask user to enter a sentence
  //Split sentence into words using split , you will will have a sequence of words, we did this on Day 8
  //Generate word length sequence (can use map or yield)
  //Filter only words of length over 5
  //print word lengths for every word
  //print the long words

  //you are allowed to use yield or map/filter

  val sentence = readLine("Enter a sentence, please!")
  val splitSentence = sentence.split(" ")
  println(splitSentence.mkString(","))
  val wordsLength = splitSentence.map(it => it.length)
  println(wordsLength.mkString(","))
 // val longwordslength = wordsLength.filter(n => n > 5)
  val longWords = splitSentence.filter(n => n.length > 5)
  println(s"Your long words are: $longWords.mkString(",")")

}
