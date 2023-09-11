class J(private var z: Int){
  private val x: Int = 1
  var y: Int = 2

  def bar(): Unit = {
    println(x + this.x)
  }

  def foo(): Unit = {
    println(x + y)
  }

  def baz(): Unit = {
    z = z + 2
  }

}

class K(var z: Int) extends J(z) {
  val x: Int = 2
  this.y = y + 3

  override def baz(): Unit = {
    super.baz()
  }
}

object main3 {
  def main(args: Array[String]): Unit = {
    val e: K = new K(10)
    e.bar()
    e.foo()
    e.baz()
    println(e.z)
  }
}
