class D() {
  def foo(d: D): Unit = {
    println("d.foo")
  }
  def foo(e: E): Unit = {
    println("d.foo_1")
  }
  def bar(f: F): Unit = {
    println("d.bar")
  }
}

class E extends D {
  def foo(f: F): Unit = {
    println("e.foo")
    this.foo(this)
  }
}

class F extends E{
  override def foo(f: F): Unit = {
    println("f.foo")
    super.foo(this)
  }
  def bar(d: D): Unit = {
    println("f.bar")
  }
}

object main2 {
  def main(args: Array[String]): Unit = {
    val d: D = new D()
    val e: D = new E()
    val f: F = new F()
    d.foo(e)
    /*
    1. d.foo(e): Como el overload se resuelve estaticamente, llama a d.foo(d) ya que e es de tipo D en
    tiempo de compilacion, imprime "d.foo".
     */
    println("------")
    e.foo(f)
    /*
    1. e.foo(f): Como el overload se resuelve estaticamente, llama a d.foo(f) ya que E es de tipo D en
    tiempo de compilacion, como F extiende de E, f tambien es de tipo E, se imprime "d.foo_1".
     */
    println("------")
    f.foo(f)
    /*
    1. f.foo(f): se llama a f.foo(f) ya que F tiene el metodo foo(f: F) sobreescrito, imprime "f.foo".
    2. llama a super.foo(this) donde el super y el this es f, por lo que la busqueda empieza una clase arriba de F,
    es decir en E, por lo tanto llama a e.foo(f) e imprime "e.foo".
    3. llama a this.foo(this), debido a que foo está sobrecargado, se resuelve estaticamente, por lo que llama a
    E.foo(x: E), D.foo(x: E) es el más compatible ya que no necesita "subir en herencia", por lo que imprime d.foo_1.
     */
    println("------")
    //d.bar(d) ----> error: D no tiene un bar que reciba un D, no compila. D no conoce a sus hijos y sus metodos.
    println("d.bar(d) no compila")
  }
}


