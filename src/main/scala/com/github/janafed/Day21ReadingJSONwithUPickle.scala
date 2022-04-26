package com.github.janafed


object Day21ReadingJSONwithUPickle extends App {
  val src = "src/resources/json/fruitFacts.json"
  val rawText = MyUtil.getTextFromFile(src)
  println(rawText.take(100))
  //let's use uPickle library to parse the raw Text into some structure
  val data = ujson.read(rawText)
  println(data)
  //in order for arr method to work I need to know that my top level of data is actually an array (not an object or just a string or number)
  val arrData = data.arr.toArray
  println(arrData.head)
  println(arrData.last)
  //with o I indicate that it is an object
  val fruits = for (o <- arrData) yield {
    Fruit(o("genus").str,
      o("name").str,
      o("id").num.toInt,
      o("family").str,
      o("order").str,
      o("nutritions")("carbohydrates").num, //so Double by default
      o("nutritions")("protein").num,
      o("nutritions")("fat").num,
      o("nutritions")("calories").num.toInt,
      o("nutritions")("sugar").num
    )
  }

  fruits.take(3).foreach(println)

  //TODO find most calorie dense fruit - it looks the data is per 100grams maybe someone can verify this?
  val mostCalorieFrutis = fruits.sortBy(_.calories)
  println(s"Most calories fruit:  ${mostCalorieFrutis.reverse.head}")
  //TODO find top 5 fattiest fruits
  val sortedFats = fruits.sortBy(_.fat)
  println(s"5 most fattest fruits:")
  sortedFats.reverse.take(5).foreach(println)
  //TODO find top 5 protein sources for fruits
  val sortedProteins = fruits.sortBy(_.protein)
  println(s"5 top protein sources for fruits:")
  sortedProteins.reverse.take(5).foreach(println)
  //TODO find 5 least sugary fruits
  val sortedSugars = fruits.sortBy(_.sugar)
  println(s"5 least sugary fruits:")
  sortedSugars.take(5).foreach(println)
  //TODO find 5 fruits with most carbohydrates that are not sugars (so difference between carbohydrates and sugar)
  //added value  nonsugar in case class
  val nonSugarCarbohydrates = fruits.sortBy(_.nonSugars)
  println("5 most carbohydrates that are not sugars:")
  nonSugarCarbohydrates.reverse.take(5).foreach(println)

  //you can add some extra conclusions, statistics as well
   val averageApplecalories = MyUtil.myRound(fruits.filter(_.name == "Apple").map(_.calories).sum/fruits.count(_.name == "Apple"),2)
    println(averageApplecalories)
}