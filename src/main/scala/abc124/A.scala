package abc124

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val a, b = sc.nextInt()

  if (a == b) {
    println(a + b)
  } else {
    val m = math.max(a, b)
    println(2 * m - 1)
  }

}
