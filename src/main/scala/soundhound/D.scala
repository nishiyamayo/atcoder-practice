package soundhound

import java.io.{BufferedReader, InputStream, InputStreamReader, PrintWriter}
import java.util.StringTokenizer

import scala.collection.mutable.{ListBuffer, PriorityQueue}

object D extends App {

  val init = 1e15.toLong

  val sc = new InputReader(System.in)
  val out = new PrintWriter(System.out)

  val (n, m, s, t) = (sc.nextInt, sc.nextInt, sc.nextInt - 1, sc.nextInt - 1)

  val g = Seq.fill(n)(ListBuffer[(Int, Long, Long)]())

  for (_ <- 1 to m) {
    val (u, t, a, b) = (sc.nextInt - 1, sc.nextInt - 1, sc.nextLong, sc.nextLong)
    g(u) += ((t, a, b))
    g(t) += ((u, a, b))
  }

  val yenSeq = dijkstra(s, g, { case (_, a, _) => a })
  val snkSeq = dijkstra(t, g, { case (_, _, b) => b })
  val ans = Array.fill[Long](n + 1)(0L)

  Range(1, n + 1)
    .map(n - _)
    .foreach(idx => ans(idx) = math.max(ans(idx + 1), init - yenSeq(idx) - snkSeq(idx)))

  Range(0, n).foreach(idx => println(ans(idx)))

  def dijkstra(s: Int, g: Seq[Seq[(Int, Long, Long)]], f: ((Int, Long, Long)) => Long): Array[Long] = {
    val pq = new PriorityQueue[(Long, Int)]()(Ordering.by[(Long, Int), Long](_._1))

    val score = Array.fill(n)(1L << 50)
    score(s) = 0
    pq.enqueue((0L, s))

    while (pq.nonEmpty) {
      val (c, p) = pq.dequeue
      if (score(p) == c) for (tup <- g(p)) {
        if (score(tup._1) > c + f(tup)) {
          score(tup._1) = c + f(tup)
          pq.enqueue((c + f(tup), tup._1))
        }
      }
    }
    score
  }

  class InputReader(val stream: InputStream) {
    private val reader = new BufferedReader(new InputStreamReader(stream), 32768)
    private var tokenizer: StringTokenizer = null

    def next: String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens)
        tokenizer = new StringTokenizer(reader.readLine)
      tokenizer.nextToken
    }

    def nextInt(): Int = next.toInt
    def nextLong(): Long = next.toLong
    def nextChar(): Char = next.charAt(0)
  }
}
