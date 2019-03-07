package abc096

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val month = sc.nextInt()
  val date = sc.nextInt()

  val ans = if (month > date) month - 1 else month

  println(ans)
}
