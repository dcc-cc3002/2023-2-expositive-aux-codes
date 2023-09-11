class C (val x: Int) {
  print("a")

  def this(x: Int, y: Int) = {
    this(x+y)
    new C ("1", "2")
    print("c2")
  }
  def this(x: String, y: String) = {
    this(x.toInt + y.toInt)
    print("c3")
  }
  def this(x: String) = {
    this(x.toInt, 5)
    print("c4")
  }
  def this() = {
    this("1")
    print("c5")
  }
  print("b")
}

object main1{
  def main(args: Array[String]): Unit = {
    new C("0")
    /*
    1. Se llama al constructor de C con el parametro "0" que es un String,
    por lo tanto se llama al constructor this(x: String).
    2. Dentro de se llama al constructor this(0,5) con los parametros 0 y 5 que son Int,
    por esto se llama al construtor this(x: Int, y: Int).
    3. Dentro de se llama al constructor this(0+5) con el parametro 5 que es Int,
    entonces se llama al principal.
    4. Se imprime "a" y se imprime "b" por el constructor principal.
    5. Se ejecuta la siguiente linea de codigo: new C ("1", "2"), que es llama al constructor this(x: String, y: String).
    6. Dentro de se llama al constructor this(1+2) con los parametros 1 y 2 que son Int,
    por esto se llama al construtor principal imprime "a" y "b".
    7. Despues se sigue con la siguiente linea de codigo: print("c3") e imprime "c3".
    8. Se sigue con la siguiente linea de codigo: print("c2") e imprime "c2".
    9. Se sigue con la siguiente linea de codigo: print("c4") e imprime "c4".

    (Se ve mejor con flechitas D:)
     */
    println("\n")
    new C()
    /*
    1. Se llama al constructor de C sin parametros, por lo tanto se llama al constructor this().
    2. Dentro de se llama al constructor this("1") con el parametro "1" que es un String,
    por lo que volvemos al caso de new C("0").
    3. Luego de todo lo que se hizo en el caso de new C("0"),
    se sigue con la siguiente linea de codigo: print("c5") e imprime "c5".
     */
  }
}
