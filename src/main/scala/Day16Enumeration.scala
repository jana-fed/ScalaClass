import Days.Days

object Days extends Enumeration{
  type Days = Value
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

object Day16Enumeration extends App{

  def getDayType(day: Days): Unit = {
    if (day.id >= 0 && day.id <=4 ) println("It is weekday!")
    else println("It is weekend!")
  }

  getDayType(Days.Monday)
}
