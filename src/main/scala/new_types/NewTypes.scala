package new_types

object NewTypes {
  val a: 1 = 1
  val b: 2 = 2
  
  def canTake(a: Int): Unit = println(a)
  def canTakeStrict(a: 1 | 2) = println(a)
  
  canTake(a)
  canTakeStrict(a)
  canTakeStrict(b)
  
  def testValue(arg: String | Int) = arg match {
    case _ : String => println("string")
    case _ : Int => println("int")
  }
  
  testValue("123")
  testValue(1)
  
  trait Box {
    def material() = println("carboard")
  }
  
  trait Apple {
    def color() = println("red")
  }
  
  def useAppleInBox(arg: Box with Apple) = {
    arg.material()
    arg.color()
  }
  
  class Text extends Box with Apple
  
  useAppleInBox(new Text)
  
  trait Return1
  trait Returner1 {
    def get: List[Return1]
  }
  trait Return2
  trait Returner2 {
    def get: List[Return2]
  }
  
  def returnValue(returner: Returner1 & Returner2): List[Return1] & List[Return2] = returner.get
  
  class MassReturner extends Returner1 with Returner2 {
    override def get: List[Return1 & Return2] = List(new Return1 with Return2)
  }
  
  returnValue(new MassReturner)
  
  def main(args: Array[String]): Unit = {
    
  }
}
