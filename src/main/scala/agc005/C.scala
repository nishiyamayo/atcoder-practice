package agc005

import java.util.Scanner

object C extends App {

  val sc = new Scanner(System.in)

  val n = sc.nextInt
  val ds = (1 to n).map(_ => sc.nextInt)
    .sorted
    .groupBy(i => i)
    .map(t => (t._1, t._2.length))
    .toStream
    .sortBy(t => t._1)

  val min = ds(0)
  val max = ds(ds.length - 1)
  val ok = ds.count(_._2 >= 2)

  if ((max._1 + 1) / 2 != min._1) {
    println("Impossible")
  }
}
