package com.spark.package1

trait P{
  def add
  def sub(): Unit ={
    println("This is sub method")
  }
}
abstract class Q{
  def mul
  def div(): Unit ={
    println("This is division class")
  }
}
class R extends Q with P{           //Order must be maintain low to high
  def add(): Unit ={
    println("This is add method")
  }
  def mul(): Unit ={
    println("This is mul method")
  }
}
object traitOrder {
  def main(args:Array[String])={
    val obj=new R
    obj.add()
    obj.sub()
    obj.mul()
    obj.div()
  }
}
