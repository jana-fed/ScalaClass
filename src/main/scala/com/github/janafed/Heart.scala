package com.github.janafed

object Heart extends App {
  type D = Double

  def w(x: D, y: D, a: D) = {
    val (i, j) = (x - a, y - 8)
    Math.sqrt(i * i + j * j) < 8
  }

  val l: Stream[Char] = "love".toStream #::: l
  val c = l.toIterator

  def p(b: Boolean) = print(if (b) c.next else ' ')

  for (y <- 0 to 24) {
    for (x <- 0 to 32) {
      if (y > 7) p((16 - x).abs < 24 - y)
      else p(w(x, y, 8) | w(x, y, 24))
    }; println
  }
}
