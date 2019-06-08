package arc061

import java.util.Scanner

object C extends App {

  val sc = new Scanner(System.in)

  val s = sc.next

  case class Memo[I, O](f: I => O) extends (I => O) {

    import collection.mutable.{Map => Dict}

    val cache = Dict.empty[I, O]

    override def apply(x: I): O = cache getOrElseUpdate(x, f(x))
  }

  type Calc = Memo[String, (Long, Int)]

  lazy val f: Calc = Memo {
    case "" => (0L, 1)
    case str: String =>
      val len = str.length
      (for {
        i <- 1 to len
        (sum, cnt) = f(str.substring(i))
      } yield {
        (str.substring(0, i).toLong * cnt + sum, cnt)
      }).reduce((t1, t2) => (t1._1 + t2._1, t1._2 + t2._2))
  }
  println(f(s)._1)
}
