package abc098

import java.util.Scanner

object E extends App {

  val sc = new Scanner(System.in)

  val (n, k, q) = (sc.nextInt, sc.nextInt, sc.nextInt)

  val li = (Seq(0) ++ (1 to n).map(_ => sc.nextInt) ++ Seq(0)).zipWithIndex

  val ans = li.toStream
    .map {
      case (min, idx) => li.filter(_._1 < min).map(_._2)
    }
    .map(ps => {
      val size = ps.size
      val ans = (for {
        idx <- (0 to size - 2)
        v = ((ps(idx) + 1) to (ps(idx + 1) - 1)).map(li(_)._1).sorted
        if v.size >= k
        t <- v.take(v.size - k -1)
      } yield t)
        .sorted
      println(ps, ans)
      if (ans.size >= q) ans(q - 1) - ans(0)
      else Int.MaxValue
    })
    .min

  println(ans)
}
