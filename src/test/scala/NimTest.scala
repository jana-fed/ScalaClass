import com.github.janafed.{Nim, NimAI, NimDB}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter


class NimTest extends AnyFunSuite with BeforeAndAfter {
  //https://alvinalexander.com/scala/writing-tdd-unit-tests-with-scalatest/

  var nim: Nim = _
  var nimDB: NimDB = _

  before {
    //we put whatever  initialization we need for tests in this particular suite
    nim = new Nim("Valdis","COMPUTER")
    nimDB = new NimDB("src/resources/nim/nim.db")
  }

  test("Nim.clampMove") {
    assert(nim.clampMove(5,1,3) === 3)
    assert(nim.clampMove(0,1,3) === 1)
    assert(nim.clampMove(-1,1,3) === 1)
    assert(nim.clampMove(1,1,3) === 1)
    assert(nim.clampMove(2,1,3) === 2)
    assert(nim.clampMove(3,1,3) === 3)
  }


  //we should create a new class just for unit testing NimAI
  test("NimAI.getSmartStrategy") {

    assert(NimAI.getSmartStrategy(2) === 1)
    assert(NimAI.getSmartStrategy(3) === 2)
    assert(NimAI.getSmartStrategy(4) === 3)
  }

  //TODO write 3 more tests involving Nim class

  test("Nim.RemoveMatches"){

    assert(nim.removeMatches(2) === 18) //negative test, there should be 19
  } //pass

  test("NimAI.getMinimalStrategy"){
    assert(NimAI.getMinimalStrategy === 1)
  }
  test("getComputerMove"){
    val currentState = 21
    val computerLevel = 1
    assert(NimAI.getComputerMove(currentState,computerLevel) === 1)
  }

  //TODO write a test testing database functionality - reading is one you can test

  test("getIdOfLastGame"){
    assert(nimDB.getIdOfLastGame === 0) //It should not be 0 (it needs to be 22)
  }

}


