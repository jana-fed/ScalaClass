package com.github.janafed

case class Fruit(genus: String,
                 name: String,
                 id: Int,
                 family: String,
                 order: String,
                 //i am flattening the nutritions
                 carbohydrates: Double = 0.0,
                 protein: Double = 0.0,
                 fat: Double = 0.0,
                 calories: Int,
                 sugar: Double = 0.0
                ) {
  val nonSugars: Double = carbohydrates - sugar
}
//TODO add the rest of fields from nutriotions