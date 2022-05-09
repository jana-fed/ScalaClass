package com.github.janafed

import scala.io.StdIn.readLine

class Nim(val playerA:String,
          val playerB:String,
          val startingCount:Int = 21,
          val gameEndCondition:Int = 0,
          val minMove:Int,
          val maxMove:Int,
          ){
  var currentState:Int = startingCount
  var isPlayerATurn:Boolean = true
  def clampMove(move: Int, min:Int, max:Int, verbose: Boolean  = true): Int = {
    if (move > max) {
      if (verbose) println(s"$move was too much, you will have to settle for $max")
      max //return since this is the last line of the function
    } else if (move < min) {
      if (verbose) println(s"$move is too little, you will have to settle for $min")
      min //return
    } else {
      move //return
    }
  }
  def removeMatches(currentState:Int, safemove:Int):Int = {
    val state = currentState - safemove
    state
  }

  def showStatus(currentState: Int, currentPlayer: String): Unit = {
    println(s"There is $currentState matches in the pile and it is $currentPlayer turn")
  }

  //TODO bonus: objects created from this class should also have a ArrayBuffer of moves
  //so each time removeMatches is called this buffer is updated, thus we have an exact log of game moves
  val playerAMoves = scala.collection.mutable.ArrayBuffer()
  val playerBMoves = scala.collection.mutable.ArrayBuffer()

}


object Day26Nim extends App {
  //TODO implement basic version of https://en.wikipedia.org/wiki/Nim
  //https://en.wikipedia.org/wiki/Nim#The_21_game

  //TODO setup/config - set data/state what is needed for the application
  //TODO main application/game loop - it could be a loopless - if you process data only once
  //TODO cleanup - close database connections, files etc
  //No plan survives first contact with the enemy - who said it first?
  //It is normal (especially Agile development) to adjust as you development

  //NIM specific TODO
  //setup
  //we will start with 21 matches/tokens
  val playerA = readLine("Player A what is your name?")
  val playerB = readLine("Player B what is your name?")

  println(s"Player A -  $playerA and Player B - $playerB let us play NIM!")
  //inevitably in most applications we will have some state that we want to keep track of
  //here it is simple enough state that we can use a few variables
  //at some point we will want to structure this game/app state into a separate object based on some class

  val nimGame = new Nim(playerA, playerB = playerB, startingCount = 21, gameEndCondition = 0, minMove = 1, maxMove = 3)
  var currentState = nimGame.currentState
  var isPlayerATurn = nimGame.isPlayerATurn //so A goes first


  //main loop - while there are some matches play on
  //TODO implement PvP - player versus player - computer only checks the rules
  while (currentState > nimGame.gameEndCondition) {
    val currentPlayer = if (isPlayerATurn) playerA else playerB
    nimGame.showStatus(currentState,currentPlayer) //show the game state
    val move = readLine(s"How many matches do you want to take $currentPlayer? (1-3) ").toInt //TODO error checking
    val safeMove = nimGame.clampMove(move, nimGame.minMove, nimGame.maxMove)
    currentState = nimGame.removeMatches(currentState, safeMove) //TODO replace this with removeMatches method call
    isPlayerATurn = !isPlayerATurn //toggle trick to change a boolean to reverse version of present
    //play the game
  }
  //TODO PvC - player versus computer you will need to add some logic to the computer
  //end cleanup here we just print some game state and congratulations
  //TODO add saving to Database, stats etc

  val winner = if (isPlayerATurn) playerA else playerB
  val loser = if (!isPlayerATurn) playerA else playerB
  println(s"Game ended. Congratulations $winner! Better luck next time $loser.")
  //print game status again
  //TODO implement multiple games



}

