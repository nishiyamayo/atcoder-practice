package abc097

import java.util.Scanner

object C extends App {

  val sc = new Scanner(System.in)

  val s = sc.next()
  val k = sc.nextInt() - 1
  val n = s.length

  val set = (0 to n - 1)
    .flatMap(i => (0 to math.min(4, n - i - 1)).map(j => s.substring(i, i + j + 1)))
    .sorted
    .distinct

  println(set(k))
}
