object Day3TypeCasting extends App {
  println("Type Casting different data types")
  // https://docs.scala-lang.org/tour/unified-types.html
  val a = 200 // this is an integer by default
  val b = a.toByte //byte is unsigned and can hold only 256 different values
  println(a,b)
  val c = 127
  val d = 128
  val e = 129
  println(c,d,e)
  println(c.toByte, d.toByte, e.toByte) //so byte only goes up to 127 and then goes to -128 all around and around
  println(1000 % 256, (1000 % 256) - 256, 1000.toByte) // the result will be the reminder(modulo) of 1000 mod 256, and then we will the number

  val myInt = 2_000_000_000
  val bigInt = myInt * 3 // no space because 32 bit int that is signed only goes up to a little bit above 2 billion
  println(myInt, bigInt)

  val face: Char = '☺' // notice the single quotes, in Scala single quotes are for characters
  val number: Int = face // 9786
  val alsoNumber = face.toInt // so we can using .toInt or we can declare the data type in the above
  println(face, number, alsoNumber)
  val faceAgain = number.toChar
  println(face, faceAgain)
  val letterA = 'a'
  println(letterA, letterA.toByte, letterA.toInt) //we have enought space in Byte and Int for an english letter
  //because those only go up to 127 https://www.asciitable.com/

  val bigNum: Long = 10_000_000_000L //I do need to write L to say that a number is Long (64bit integer)
  val result = bigNum + number // so we can add Long and Int no problem
  println(result)
  val anotherResult = bigNum + b //we are adding huge 64bit(8 bytes) integer with a single byte number
  println(anotherResult)
  println(bigNum + a) //so this should be 10Billion and 200

  val myPi = Math.PI //this is built actually
  val ancientPi = myPi.toInt //so what will be the result here ?
  val ancientPiFloat = ancientPi.toDouble //this will not bring us the original Pi back
  println(myPi, ancientPi, ancientPiFloat)

  val myStringy = "44252621"
  val myNumber = myStringy.toInt
  println(myStringy, myNumber) //so when we print them on screen they look the same, but the difference is
  //that I can do math with myNumber and I can do string operations with myStringy
  val myName = "Valdis" //this should not be converted to number
  //  val myNameNum = myName.toInt //this should give us an exception (error)


}
