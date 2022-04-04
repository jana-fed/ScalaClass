trait FLightTrait {
  def fly(): Unit
}
trait RunningTrait{
  def run(): Unit
}
trait SwimmingTrait {
  def swim(): Unit
}
class Birds(name:String) extends RunningTrait with FLightTrait with SwimmingTrait {
  println(s"It's a bird named $name!")

  override def run(): Unit = println(s"Let's run $name!")

  override def fly(): Unit = println(s"Let's fly $name!")

  override def swim(): Unit = println(s"Let's swim $name!")
}
class Penguin(name:String) extends Birds(name:String) {

   override def run(): Unit = println(s"Penguins $name can also run!")
}
class Chicken(name:String) extends RunningTrait{
  override def run(): Unit = println(s"Let's run $name!") //made chicken using trait extension
  def layeggs(eggamount:Int):Unit = println(s"Chicken $name layed $eggamount eggs!") //chicken also can lay eggs
}
class Parrot(name:String) extends Birds(name:String){
    def talk(): Unit = println(s"A parrot $name can also talk!")
}
class Pigeon(name:String) extends Birds(name:String){
  def eatworms(): Unit = println(s"Pigeon $name eat worms!")
}
//TODO create FlightTrait trait with fly method declaration (no need to define it, just declare it)

//TODO create RunningTrait with at least run method declaration

//TODO create SwimmingTrait with swim method declaration inside

//TODO create Penguin class extended with appropriate traits
//TODO create Chicken class extended with appropriate traits
///optional create generic Bird class first and extend that
//There is no one True solution here

//TODO create two penguin objects
//TODO make them swim
//TODO create two chicken objects
//TODO make the chickens run

//BONUS maybe make some more birds? :)


//traits and classes go here (or in a separate file)

object Day14ExerciseBirds extends App {
  println("Let's create some birds using traits!")
  val sam = new Penguin("Sam")

  val hoppy = new Penguin("Hoppy")
  sam.swim()
  hoppy.swim()
  sam.run()
  val opra = new Chicken("Opra")
  val gigi = new Chicken("Gigi")
  opra.run()
  gigi.run()
  val blue = new Parrot("Njushek")
  blue.fly()
  opra.layeggs(5)
  gigi.layeggs(eggamount = 3)
  val rafael = new Pigeon("Rafael")
  rafael.eatworms()
  //object creation goes here

}
