import Day8CubeSequence.cubeSequince

import scala.io.StdIn.readLine

object Day8CubeSequence extends App {
val startNumber = readLine("Enter start number:").toInt
val endNumber = readLine("Enter edn number:").toInt
  val numbers = startNumber to endNumber
  val cubeSequince = scala.collection.mutable.ArrayBuffer[Int]()
  for (n <- startNumber to endNumber){
    val cube = n*n*n
    cubeSequince += cube
  }
  println(cubeSequince)
  val oddCubes = for (cubeSequince <- cubeSequince if cubeSequince % 2 == 0) yield cubeSequince
  println(oddCubes)
}
