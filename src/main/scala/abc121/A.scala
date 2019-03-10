package abc121

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val H, W, h, w = sc.nextInt()

  println(H * W - h * W - H * w + h * w)

}
