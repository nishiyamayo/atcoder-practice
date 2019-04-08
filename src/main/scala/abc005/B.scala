package abc005

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val n = sc.nextInt

  println(
    (1 to n).map(_ => sc.nextInt)
      .min
  )

}
