package abc123

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val ar = (1 to 5).map(_ => sc.nextInt).sorted
  val k = sc.nextInt

  if (math.abs(ar(0) - ar(4)) <= k) {
    println("Yay!")
  } else {
    println(":(")
  }
}
