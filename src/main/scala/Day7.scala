object Day7 extends App {
  //TODO
  def processString(text:String, uppercaseChars:String ="", needsTrim:Boolean=false):Unit = {
    //TODO first trim string if it needs trimming from the argument
    //TODO replace All characters in uppercaseChars with their uppercase versions
    //you will need to write a loop
    //you will probably want to use var to store a temporary string that you keep reweriting
    //return newly created string
    var newtext = ""
    if (needsTrim) {newtext = text.trim }
    else newtext = text

    var bigtext = ""
      for (c <- newtext) {
    bigtext += c.toString.toUpperCase
     }
   bigtext
    }



 println(processString("abracadabra", "cr")) //should print abRaCadabRa
  println(processString("   abracadabra  ", "cr", needsTrim = true)) //should print abRaCadabRa
}

