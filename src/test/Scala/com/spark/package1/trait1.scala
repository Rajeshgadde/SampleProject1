package com.spark.package1

trait X {
  def add
  def sub(): Unit = {
    println("This is sub method")
  }
}
trait Y{
  def mul()
}
class Z extends X with Y {       //Extends one or more than one no problem
  def add(): Unit ={
    println("This is add method")
  }
  def mul(): Unit ={
    println("This is mul method")
  }
}
object trait1 {
  def main(args:Array[String])={
    val obj=new Z
    obj.add()
    obj.sub()
    obj.mul()
  }
}
