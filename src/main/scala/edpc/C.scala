package edpc

import java.util.Scanner

object C extends App {
  val sc = new Scanner(System.in)

  val n = sc.nextInt()

  val happy = Stream.range(0, n)
    .map(_ => (sc.nextLong(), sc.nextLong(), sc.nextLong()))
    .foldLeft(0L, 0L, 0L) {
      case ((am, bm, cm), (ai, bi, ci)) =>
        (
          math.max(bm + ai, cm + ai),
          math.max(cm + bi, am + bi),
          math.max(am + ci, bm + ci)
        )
    }

  println(Seq(happy._1, happy._2, happy._3).max)

}
