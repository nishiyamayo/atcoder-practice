package abc117

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)

  val n = sc.nextInt()
  val ls = (1 to n).map(_ => sc.nextInt())
    .sorted

  val sum = ls.sum

  if (sum - ls(n - 1) <= ls(n - 1)) {
    println("No")
  } else {
    println("Yes")
  }
}
