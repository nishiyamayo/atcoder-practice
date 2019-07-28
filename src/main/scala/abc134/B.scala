package abc134

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val n, d = sc.nextInt()

  val x = 2 * d + 1

  val ans = n / x

  if (ans * x < n) {
    println(ans + 1)
  } else {
    println(ans)
  }

}
