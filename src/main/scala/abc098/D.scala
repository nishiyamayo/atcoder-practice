package abc098

import java.util.Scanner

object D extends App {

  val sc = new Scanner(System.in)

  val n = sc.nextInt

  val li = ((1 to n).map(_ => sc.nextLong) ++ Seq((1L << 22) - 1))

  val ans = Stream.iterate((0, 0, 0L, 0L, 0L)) {
    case (r, l, cnt, sum, xor) =>
      if ((xor & li(l)) == 0) {
        (r, l + 1, cnt + 1, sum + cnt + 1, xor | li(l))
      } else {
        (r + 1, l, cnt - 1, sum, xor - li(r))
      }
  }
    .dropWhile(_._1 < n)
    .head

  println(ans._4)
}
