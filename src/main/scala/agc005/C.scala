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

  val min = ds.head
  val max = ds.last
  val multi = ds.filter(_._2 >= 2).map(_._2).sum
  val ok = ds.length == (max._1 - min._1 + 1)

  if ((max._1 + 1) / 2 != min._1) {
    println("Impossible")
  } else if (ok && max._1 % 2 == 1 && min._2 == 2 && multi == n) {
    println("Possible")
  } else if (ok && max._1 % 2 == 0 && min._2 == 1 && multi == n - 1) {
    println("Possible")
  } else {
    println("Impossible")
  }
}
