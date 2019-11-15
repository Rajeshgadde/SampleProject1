package com.spark.package1

object some{
  def fun1(a:Int): Unit ={
    a match {
      case 10 => println("B.Tech")
      case 11 => println("MCA")
      case 12 => println("MBA")
      case 13 => println("M.Tech")
      case 14 => println("B.Sc")
      case 15 => println("MSC")
      case _  => println("Others")
    }
  }
}
object match1 {
  def main(args:Array[String])={
    println("Enter your branch number ")
    val a=scala.io.StdIn.readInt()
    some.fun1(a)
  }
}
