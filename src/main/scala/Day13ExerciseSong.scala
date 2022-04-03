class Song (val title:String, val author:String, val lyrics:Array[String]){

  println(s"New Song $title made by $author")

  def sing(maxLines:Int = lyrics.length-1): Unit = {
    if (maxLines > lyrics.length-1){
      println("Number of lines you entered is to big!")
    } else
     { println(s"***$author - $title***")
    for (n <- lyrics.indices)
    {println(lyrics(n))}}
  }
  def yell(maxLines:Int = lyrics.length-1):Unit={

    if (maxLines > lyrics.length-1){
      println("Number of lines you entered is to big!")
    } else
      {println(s"***$author - $title***")
      for (n <- lyrics.indices)
      {println(lyrics(n).toUpperCase())}}
  }
}
class Rap(title: String, author:String, lyrics: Array[String]) extends Song(title: String, author:String, lyrics: Array[String]){

  def breakIT(maxLines:Int = lyrics.length-1, drop:String="yeah"): Unit ={
    for (n <-  lyrics.indices){
      var newlyrics = lyrics(n).split(" ")
      newlyrics = newlyrics.map(t => t + " " + drop.toUpperCase())
      println(newlyrics.mkString(" "))
    }

  }

}
//1. Song class
//create  a class Song
//
//The class constructor needs to have three additional 3 parameters
//
//title defaults to empty string
//
//author defaults to empty string
//
//lyrics by default empty Seq of strings
//
//inside constructor method:
//
// print on the screen "New Song made" - (try also printing here author and title!)
//
//Minimum:
//
//Write a method sing that prints the song line by line on the screen, first printing the author and title, if any.
//
//Write a method yell that prints the song in capital letters line by line on the screen, first printing the author and title, if any.
//you can write private helper methods if you think code is too similar..

//Bonus: create an additional parameter maxLines that prints only a certain number of lines for both sing and yell. Better do with some default value e.g. -1, at which all rows are then printed.
//
//Create multiple songs with lyrics
//
//Example:
//
//
//ziemelmeita = Song("Ziemeļmeita", "Jumprava", Array("Gāju meklēt ziemeļmeitu","Garu, tālu ceļu veicu"))
//
//ziemelmeita.sing(1)
//
// Outputs:
//
//Ziemeļmeita - Jumprava
//
//Gāju meklēt ziemeļmeitu //just one line since I specified sing(1)
//ziemelmeita.sing() //would print all lyrics

//
//2. Rap class
//For those feeling comfortable with class syntax, create a Rap class that inherits from Song
//
// add a new method breakIt with two default parameters max_lines=-1 and drop equal to "yeah",
// this breakIt which is similar to sing, but adds a drop after each word .
//
//Example:
//
//
//
//zrap = Rap("Ziemeļmeita", "Jumprava", Array("Gāju meklēt ziemeļmeitu"," Garu, tālu ceļu veicu"))
//
//
//
//zrap.breakIt(1, "yah")
//
//Ziemeļmeita - Jumprava
//
//Gāju YAH meklēt YAH ziemeļmeitu YAH


object Day13ExerciseSong extends App {
  println("Let's make some songs!")
  val ziemelmeita = new Song("Ziemeļmeita", "Jumprava", Array("Gāju meklēt ziemeļmeitu","Garu, tālu ceļu veicu"))

  ziemelmeita.sing()
  ziemelmeita.yell()
  val christmasstree = new Song("O Christmas Tree", "C. Nygard Jr.", Array("O Christmas tree, O Christmas tree","How lovely are thy branches","O Christmas tree, O Christmas tree","How lovely are thy branches"))
  christmasstree.sing(2)
  christmasstree.yell(6)
  val zrap = new Rap("Ziemeļmeita", "Jumprava", Array("Gāju meklēt ziemeļmeitu","Garu, tālu ceļu veicu"))
  zrap.breakIT()
  zrap.breakIT(drop = "Blabla")
  //create a couple of Songs
  //possibly some Rap songs as well :)
}
