package agc003

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val ds = sc.next().toStream.distinct

  val ns = ds.count(c => c == 'N' || c == 'S')
  val ew = ds.count(c => c == 'W' || c == 'E')

  if (ns % 2 == 0 && ew % 2 == 0) {
    println("Yes")
  } else {
    println("No")
  }
}
