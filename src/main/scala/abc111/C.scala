package abc111

import java.util.Scanner

object C extends App {

  val sc = new Scanner(System.in)

  val n = sc.nextInt()
  val ar0 = Array.fill(n / 2)(0)
  val ar1 = Array.fill(n / 2)(0)
  val map = Range(0, n).map((_, sc.nextInt()))
    .map(t => if (t._1 % 2 == 0) ar0(t._1 / 2) = t._2 else ar1(t._1 / 2) = t._2)

  val or0 = ar0.toSeq.groupBy(i => i)
    .map(t => (t._1, t._2.length))
    .toSeq.sortBy(_._2).reverse

  val or1 = ar1.toSeq.groupBy(i => i)
    .map(t => (t._1, t._2.length))
    .toSeq.sortBy(_._2).reverse

  if (or0(0)._1 == or1(0)._1) {
    if (or0.length == 1) {
      if (or1.length == 1) {
        println(n / 2)
      } else {
        println(n / 2 - or1(1)._2)
      }
    } else {
      if (or1.length == 1) {
        println(n / 2 - or0(1)._2)
      } else {
        println(math.min(n - or1(0)._2 - or0(1)._2, n - or1(1)._2 - or0(0)._2))
      }
    }
  } else {
    val ans = n - or0(0)._2 - or1(0)._2
    println(ans)
  }
}
