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
  def prettyPrint():Unit = {
    println(s"Fruit genus:$genus, name: $name, family:$family, order:$order\n" +
      s", carbs:$carbohydrates, sugar:$sugar, protein: $protein, fat:$fat, calories:$calories, nonSugarCarbs:$nonSugars")
  }
  def getJSON:String = {
    s"""
       |{
       |  "genus": "$genus",
       |  "name": "$name",
       |  "family": "$family",
       |  "order": "$order",
       |  "carbohydrates": "$carbohydrates",
       |  "sugar": "$sugar",
       |  "protein": "$protein",
       |  "fat": "$fat",
       |  "calories": "$calories"
       |}
       |""".stripMargin
  }
}
