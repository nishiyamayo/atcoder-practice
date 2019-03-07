package abc114

import java.util.Scanner

object C extends App {
  val sc = new Scanner(System.in)

  val n = sc.nextLong()

  val cnt = Stream.from(0)
    .map(i => Integer.toString(i, 4))
    .filter(s => s.contains('1') && s.contains('2') && s.contains('3') && !s.contains('0'))
    .map(s => s
      .replaceAll("3", "7")
      .replaceAll("1", "3")
      .replaceAll("2", "5"))
    .map(s => s.toLong)
    .takeWhile(n >= _)

  println(cnt.size)
}
