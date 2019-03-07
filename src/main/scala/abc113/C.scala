package abc113

import java.util.Scanner

object C extends App {
  val sc = new Scanner(System.in)

  val n, m = sc.nextInt()

  (1 to m).map((_, sc.nextInt, sc.nextInt))
    .groupBy(_._2)
    .flatMap(tup => tup._2.sortBy(_._3).zipWithIndex.map(tup => (tup._1._1, s"%06d%06d".format(tup._1._2, tup._2 + 1))))
    .toSeq
    .sortBy(_._1)
    .map(_._2)
    .foreach(println)
}
