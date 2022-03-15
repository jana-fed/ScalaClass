import scala.io.StdIn.readLine

object TreesAssignment extends App {
  //TODO ask person's name
  //TODO ask for tree height
  //TODO print a xmas tree (or another tree) by calling printTree function with the correct parameters
  //tree height should be the one assigned
  //simple version for height 3 would be
  //  *
  // ***
  //*****

  //for full points I would like to see the following
  //if user enters name Valdis  and height 9
  //then we should print
  //        *
  //       VVV
  //      AAAAA
  //     LLLLLLL
  //    DDDDDDDDD
  //   IIIIIIIIIII
  //  SSSSSSSSSSSSS
  // VVVVVVVVVVVVVVV
  //AAAAAAAAAAAAAAAAA
 // println(" "*10+"*"*5)
  //let's consider maximum height 40 (so person's name letters could repeat many times)
  val name = readLine("Hello! What is your name?")
  val height = readLine("Enter you trees heigth").toInt
 def printTree(name:String, height:Int, symbol:Char='*', maximumHeight:Int=40):Unit = {
   val max = maximumHeight/name.length
   val newname = name + name*max

   println(" "*(height-1)+"*")
   for (i <- 2 to height){
    val c = newname(i-2).toString.toUpperCase
    println(" "*(height-i)+c*(i*2-1))}

    }
  //def printchar(heght: Int, name: String): Unit = {
   //val max = 40/name.length
   //val newname = name + name*max
    //for (i <- 0 to heght){
      //println(newname(i))

    //for this exercise we are not going to adjust maximumHeight
    //TODO print the tree HINT: check the last entry in Day7Strings

printTree(name, height)
}
