package com.spark.package1

class Exam1{
  def test: Unit ={
    val a=67
    println("Marks in test "+a)
  }
}
class Exam2 extends Exam1{
  override def test: Unit ={
    val a=89
    println("Marks in test "+a)
  }
}
object methodOverriding {
  def main(args:Array[String]):Unit={
    val obj=new Exam2()
    obj.test
  }
}
