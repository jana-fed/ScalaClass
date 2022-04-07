package com.github.janafed

//TODO add class variables name, animalType, likes, sound- all strings and age which is Int
class animal(val nickname: String, 
             val animalType: String,
             val likes: String,
             val sound: String,
             val age: Int) {
 //TODO add class method makeSound which prints sound
    def makeSound(): Unit = {
    println(s"What's does a $animalType says? It says $sound!")
    }
    def meet(contact: String): Unit ={
    if (contact == "like") println(s"$nickname likes you and says HI! $sound!")
    else println(s"Oh no! $nickname runned away!")
    }
}
object Day12ExerciseAnimal extends App {

  val catMuris = new animal(nickname = "Muris", animalType = "cat", likes = "Fish", sound = "Mau-Mau", age = 5 )
  val dogPedro = new animal(nickname = "Pedro", animalType = "dog", likes = "bones", sound = "Vau-Vau", age = 7)
  val catGven = new animal(nickname = "Venja", animalType = "cat", likes = "mouse", sound = "Mjek", age = 9)
  val parrotAnna  = new animal(nickname = "Njushek", animalType = "parrot", likes = "seeds", sound = "Chiv-Chiv", age = 7)
  parrotAnna.makeSound()
  dogPedro.makeSound()
  catMuris.makeSound()
  catMuris.meet("like")
  parrotAnna.meet("not like")

}
