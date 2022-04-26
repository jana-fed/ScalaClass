package com.github.janafed

object Day20CSVExercise extends App {

  val src = "src/resources/csv/fruitvegprices-19apr22.csv"
  val veggieLines = MyUtil.getLinesFromFile(src)
  val splitLines = veggieLines.map(_.split(",")) //so each line is split by comma

  def arrayToVeggie(arr:Array[String]):Veggie = {
    //in real life scenarios we would want a library to handle bad cases
    //we would want to check if we have some bad data
    Veggie(arr(0), arr(1), arr(2), arr(3),arr(4).toDouble, arr(5))
  }
  val veggies = splitLines.tail.map(arrayToVeggie)
  veggies.take(5).foreach(println)
  //TODO get the top 5 most expensive apple entries
  //TODO get the least expensive 5 apple entries

  val apples = veggies.filter(_.item == "apples")
  apples.take(10).foreach(println)
  val sortedApples = apples.sortBy(_.price)
  println("Top 5 most expensive apple entries:")
  sortedApples.reverse.take(5).foreach(println)
  println("Top 5 least expensive apple entries:")
  sortedApples.take(5).foreach(println)

  //TODO get average price for lettuce
  val lettuce = veggies.filter(_.item == "lettuce")
  val lettuceAverage = MyUtil.myRound(lettuce.map(_.price).sum/lettuce.map(_.price).length,2)
  println(s"Average lettuce price is $lettuceAverage")

  //TODO get cherry tomatoes pricing min, max, mean for year 2022

  val cherrytomatoes2022 = veggies.filter(_.variety == "cherry").filter(_.date.contains("2021"))
  val cherrytomatoes2021prices = cherrytomatoes2022.map(_.price)
  //cherrytomatoes2022.take(10).foreach(println)
  println(s"Max cherry tomatoes price in 2021 is ${cherrytomatoes2022.map(_.price).max} ")
  println(s"Min cherry tomatoes price in 2021 is ${cherrytomatoes2022.map(_.price).min}")
  val cherrytomatoes2022mean = MyUtil.myRound(cherrytomatoes2022.map(_.price).sum/cherrytomatoes2022.map(_.price).length,2)
  println(s"Min cherry tomatoes price in 2021 is $cherrytomatoes2022mean")


  //TODO extra credit challenge get average price for lettuce by year
  //two approaches - one is simply hardcode starting and ending years and filter by those
  //you might not even need to extract year simply lexicographical filering should work
  val lettuce2017price = lettuce.filter(_.date.contains("2017")).map(_.price)
  val lettuce2018price = lettuce.filter(_.date.contains("2018")).map(_.price)
  val lettuce2019price = lettuce.filter(_.date.contains("2019")).map(_.price)
  val lettuce2020price = lettuce.filter(_.date.contains("2020")).map(_.price)
  val lettuce2021price = lettuce.filter(_.date.contains("2021")).map(_.price)
  val lettuce2022price = lettuce.filter(_.date.contains("2022")).map(_.price)
  val averagelettuce2017 = MyUtil.myRound(lettuce2017price.sum/lettuce2017price.length,2)
  val averagelettuce2018 = MyUtil.myRound(lettuce2018price.sum/lettuce2018price.length,2)
  val averagelettuce2019 = MyUtil.myRound(lettuce2019price.sum/lettuce2019price.length,2)
  val averagelettuce2020 = MyUtil.myRound(lettuce2020price.sum/lettuce2020price.length,2)
  val averagelettuce2021 = MyUtil.myRound(lettuce2021price.sum/lettuce2021price.length,2)
  println(s"Average lettuce price in 2017 $averagelettuce2017")
  println(s"Average lettuce price in 2018 $averagelettuce2018")
  println(s"Average lettuce price in 2019 $averagelettuce2019")
  println(s"Average lettuce price in 2020 $averagelettuce2018")
  println(s"Average lettuce price in 2021 $averagelettuce2021")

  //even better approach use groupBy
  // hint: use groupBy but first you would need to modify case class with Year field(value)
  //alternative to creating a Year entry would be to split date field while grouping and group by first portion
  // https://alvinalexander.com/scala/how-to-split-sequences-subsets-groupby-partition-scala-cookbook/

  val lettuceYears2 = lettuce.groupBy(_.date.split("-").head)
  println(lettuceYears2)
//  val veggieYears = veggies.map(_.date.split("-").head)
//  veggieYears.distinct.foreach(println)
  val sum = lettuce
  val avglettuce2017 = MyUtil.myRound(lettuce.map(_.price).sum/lettuce.map(_.price).length,2)



}
