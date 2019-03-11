package abc003

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val S, T = sc.next

  val ok = "atcoder@"

  val ans = S.toStream.zip(T.toStream)
    .foldLeft(true) {
      case (flg, (s, t)) =>
        if (s == '@') {
          flg & ok.contains(t)

        } else if (t == '@') {
          flg & ok.contains(s)
        } else {
          flg & s == t
        }
    }

  if (ans) {
    println("You can win")
  } else {
    println("You will lose")
  }
}
