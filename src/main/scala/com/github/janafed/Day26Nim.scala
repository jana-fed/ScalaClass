
package com.github.janafed


import java.io.FileNotFoundException
import java.nio.file.{Files, Paths}
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.time.{ZoneOffset, ZonedDateTime}
import java.util.Calendar
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

object Day26Nim extends App {
  //implement basic version of https://en.wikipedia.org/wiki/Nim
  //https://en.wikipedia.org/wiki/Nim#The_21_game

  //we could store the settings from here in a text file so non programmer could adjust them later on
  //it could xml, it be json, but easier if it is just a text file
  val saveDst = "src/resources/nim/scores.csv"
  val db = new NimDB("src/resources/nim/nim.db")
  val startingCount = 21
  val gameEndCondition = 0
  val minMove = 1
  val maxMove = 3
  var playerA = ""
  var playerB = ""
  var computerLevel = 0

  def setup():Unit = {
    println("Let's play a game of NIM!")
    getPlayerInformation()
  }

  def getPlayerInformation():Unit = {
    playerA = readLine("Player A what is your name?")
    playerB = readLine("Player B what is your name? (press ENTER for computer) ")
    if (playerB == "") playerB = "COMPUTER"
    if (playerB == "COMPUTER") {
      computerLevel = getIntegerInput("Please enter computer level (1-3)")
    }
  }

  //so this function is only inside the outer loop
  def getIntegerInput(prompt:String="Please enter an integer: "): Int = {
    var needsInteger = true //we use this as a flag for our code
    var myInteger = 0
    //so we keep going until we get an input which we can cast to integer
    while (needsInteger) {
      val moveInput = readLine(prompt)
      //https://alvinalexander.com/scala/scala-try-catch-finally-syntax-examples-exceptions-wildcard/
      try {
        myInteger = moveInput.toInt //this type Casting will throw an exception on bad input
        needsInteger = false //IMPORTANT! this line will not execute if error is encountered
      } catch {
        //It is considered good practice to catch specific errors relevant to your code
        case e:NumberFormatException => println(s"That is not a number! + $e") //for users you would not print $e
        // handling any other exception that might come up
        case unknown => println("Got this unknown exception we need an integer!: " + unknown)
      }
    }
    myInteger
  }

  def runSingleGame(nimGame:Nim, db:NimDB):Unit = {
    //main loop - while there are some matches play on
    while (nimGame.isGameActive) {
      //show the game state
      //    println(s"Currently there are $currentState matches on the table")
      nimGame.showStatus()

      val move = if (nimGame.isCurrentPlayerComputer) {
        NimAI.getComputerMove(nimGame.currentState, computerLevel)
      } else {
        getIntegerInput(s"${nimGame.currentPlayer} please enter how many matches you are taking (1-3)")
      }
      nimGame.removeMatches(move)
      nimGame.nextPlayer()
    }

    nimGame.showStatus()
    nimGame.printMoves()

    nimGame.saveGameResult(saveDst)
    db.insertResult(nimGame.getWinner, nimGame.getLoser)
    nimGame.saveGameScore()
    db.insertFullScore(nimGame.getMoves)
    //    db.printTopPlayers()
    //    db.printBiggestLosers()

    db.printAllPlayers()
  }

  def isNewGameNeeded():Boolean= {
    val nextGameInput = readLine("Do you want to play another game? (Y/N)")

    if (nextGameInput.toLowerCase.startsWith("y")) {
      val arePlayersDifferent = readLine("Do you want to change players? (Y/N)")

      if (arePlayersDifferent.toLowerCase.startsWith("y")) getPlayerInformation()

      true //we return this when we need a new game
    } else false

  }

  def runMainGame():Unit = {
    var isNewGameNeededFlag = true
    while(isNewGameNeededFlag) {
      println(s"Player A -  $playerA and Player B - $playerB let us play NIM!")

      val isPlayerAStarting = true //so A goes first

      val nimGame = new Nim(playerA, playerB, startingCount, gameEndCondition, minMove, maxMove, isPlayerAStarting)

      runSingleGame(nimGame, db)

      isNewGameNeededFlag = isNewGameNeeded()
    }

  }

  def cleanup():Unit = {
    println("Thank you for playing! Hoping to see you again ;)")
    //could add some extra stat display
    //call database closure
    //close any network connections (we do not have any here) etc
  }

  //our actual program starts here
  setup()
  runMainGame()
  cleanup()

}

