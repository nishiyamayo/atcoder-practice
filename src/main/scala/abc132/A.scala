package abc132

import scala.io.StdIn

object A extends App {

  val s = StdIn.readLine.sorted
  if (s.charAt(0) == s.charAt(1) && s.charAt(2) == s.charAt(3) && s.charAt(1) != s.charAt(2)) {
    println("Yes")
  } else {
    println("No")
  }
}
