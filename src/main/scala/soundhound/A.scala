package soundhound

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val (a, b) = (sc.nextInt, sc.nextInt)

  if (a + b == 15) {
    println("+")
  } else if (a * b == 15) {
    println("*")
  } else {
    println("x")
  }
}
