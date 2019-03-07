package abc097

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val (a, b, c, d) = (sc.nextInt, sc.nextInt, sc.nextInt, sc.nextInt)

  if (math.abs(a - c) <= d) {
    println("Yes")
  } else if (math.abs(a - b) <= d && math.abs(b - c) <= d) {
    println("Yes")
  } else {
    println("No")
  }
}
