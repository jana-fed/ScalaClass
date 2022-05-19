import com.github.janafed.MyUtil
import org.scalatest.funsuite.AnyFunSuite

class UtilTest extends AnyFunSuite {
  test("Util.myRound") {
    //TODO write some tests
    assert(MyUtil.myRound(3.14, 0) === 3.0) //checking double/float equality can be tricky
    assert(MyUtil.myRound(3.14159, 2) === 3.14)
    assert(MyUtil.myRound(3.14159, 4) === 3.1416)
  }

  test("Util.myRound.zeros") {
    assert(MyUtil.myRound(0.0041, 0) === 0.0)
  }

  test("Util.myRound.negative") {
    assert(MyUtil.myRound(-1.52, 0) === -2.0)
  }

  test("Util.getCharacterCount") {
    val arr = Array("Valdis", "Scala") //so 11 characters plus newline between so answer should be 12
    assert(MyUtil.getCharacterCount(arr) === 12)
  }

  test("Util.getCharacterCount.blank") {
    val arr = Array[String]()
    assert(MyUtil.getCharacterCount(arr) === 0)
  }

  test("getWordCountPerLine"){
    val arr = Array("My name is Yana", "Today is a good day for some unit tests")
    assert(MyUtil.getWordCountPerLine(arr) === Array(4,9))
  }

  test("getWordCountPerLine.blank"){
    val arr = Array[String]()
    assert(MyUtil.getWordCountPerLine(arr) === Array())
  }


}

