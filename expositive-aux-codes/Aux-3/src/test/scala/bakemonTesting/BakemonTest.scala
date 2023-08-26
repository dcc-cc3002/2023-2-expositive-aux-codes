package bakemonTesting

import munit.FunSuite
import bakemon.Bakemon

/** Version 1
class BakemonTest extends FunSuite {
  test("A Bakemon can be created with a name") {
    val bakemon = new Bakemon("Bakemon")
    assertEquals(bakemon.name, "Bakemon")
  }
}
*/

/** Version 2
class BakemonTest extends FunSuite {
  val name = "Bakemon"
  test("A Bakemon can be created with a name") {
    val bakemon = new Bakemon(name)
    assertEquals(bakemon.name, name)
  }
}
*/

/** Version 3
class BakemonTest extends FunSuite {
  val name = "Bakemon"
  val bakemon = new Bakemon(name)
  test("A Bakemon can be created with a name") {
    assertEquals(bakemon.name, name)
  }
}
*/

/** Version 4
class BakemonTest extends FunSuite {
  val name = "Bakemon"
  var bakemon: Bakemon = _
  override def beforeEach(context: BeforeEach): Unit = {
    bakemon = new Bakemon(name)
  }
  test("A Bakemon can be created with a name") {
    assertEquals(bakemon.name, name)
  }
}
*/

class BakemonTest extends FunSuite {
  val name = "Bakemon"
  var bakemon: Bakemon = _
  override def beforeEach(context: BeforeEach): Unit = {
    bakemon = new Bakemon(name)
  }
  test("A Bakemon can be created with a name") {
    assertEquals(bakemon.name, name)
  }
  test("A Bakemon can talk") {
    assertEquals(bakemon.talk(), name)
  }
}



