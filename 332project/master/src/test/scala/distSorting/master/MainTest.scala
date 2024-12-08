package distSorting.master

import org.scalatest.funsuite.AnyFunSuite
import java.io.{ByteArrayOutputStream, PrintStream}

class MainTest extends AnyFunSuite {

  test("Main should print 'Hello, World!'") {
    // Redirect standard output to capture the printed output
    val outputStream = new ByteArrayOutputStream()
    Console.withOut(new PrintStream(outputStream)) {
      Main.main(Array.empty)
    }

    // Assert the output is as expected
    assert(outputStream.toString.trim == "Hello, World!")
  }
}
