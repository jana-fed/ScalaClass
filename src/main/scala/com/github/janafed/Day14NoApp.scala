package com.github.janafed

object Day14NoApp {


  def main(args: Array[String]):Unit = {
    println("Starting main function")
    for (arg <- args) {
      //all arguments are strings we can cast them to something else if we want
      println(s"Going to do something with argument: $arg its type is ${arg.getClass}")
    }
    println("All done")
  }

}
