package gcj2019.qualification

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val T = sc.nextInt

  (1 to T).foreach { t =>
    val _ = sc.nextInt
    val s = sc.next
    val ans = s
      .map(c => if (c == 'E') 'S' else 'E')
    println(s"Case #${t}: $ans")
  }
}
