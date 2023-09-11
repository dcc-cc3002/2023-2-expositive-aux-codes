class A {
  def foo(): Unit = {
    println("a.foo")
  }
  def bar(): Unit = {
    println("a.bar")
    this.foo()
  }
  def baz(): Unit = {
    println("a.baz")
  }
}
class B extends A {
  override def foo(): Unit = {
    println("b.foo")
    this.baz()
  }
  override def baz(): Unit = {
    println("b.baz")
    super.foo()
  }
}

object main {
  def main(args: Array[String]): Unit = {
    val a: A = new A
    val b: A = new B
    a.bar()
    /*
    1. a.bar(): Llama a a.bar() e imprime "a.bar".
    2. llama a this.foo() donde el this es a, por lo que llama a a.foo() e imprime "a.foo" .
     */
    println("----")
    b.foo()
    /*
    1. b.foo(): Llama a b.foo() ya que está sobreescrito dicho metodo en B, como el override se ve en
    tiempo de ejecución, imprime "b.foo".
    2. llama a this.baz() donde el this es b, por lo que llama a b.baz() (mismo argumento de antes) e imprime "b.baz".
    3. llama a super.foo() donde el super es b, por lo que la busqueda empieza una clase arriba de B, es decir en A,
    por lo tanto llama a a.foo() e imprime "a.foo".
     */
    println("----")
    b.bar()
    /*
    1. b.bar(): Llama a a.bar() ya que no está sobreescrito dicho metodo en B, imprime "a.bar".
    2. llama a this.foo() donde el this es b, por lo que llama a b.foo() (mismo argumento de antes) e imprime "b.foo".
    3. llama a this.baz() donde el super es b, por lo que la busqueda empieza en B, se encuentra con el override de baz
    en B, por lo que llama a b.baz() e imprime "b.baz".
    4. llama a super.foo() donde el super es b, por lo que la busqueda empieza una clase arriba de B, es decir en A,
    por lo tanto llama a a.foo() e imprime "a.foo".
     */
  }
}
/*
class A {
  def bar(): Unit = {
    println("a.bar")
    super.foo() // error: A no tiene super clase que pueda llamar a foo, no compila.
  }
 */
