package com.spark.package1

class method{
  def add(a:Int,b:Int):Unit={
    val c=a+b
    println("Method overloading with 2 arguments addition is "+c)
  }
  def add(a:Double,b:Double):Unit={
    val c=a+b
    println("Method overloading with Double as parameter addition is "+c)
  }
  def add(a:Int,b:Int,c:Double):Unit={
    val d=a+b+c
    println("Method overloading with different datatypes addition is "+d)
  }
}
object methodOver {
  def main(args:Array[String]):Unit={
    val obj=new method()
    obj.add(10,20)
    obj.add(12.23,1234.33444)
    obj.add(10,20,30.12345)
  }
}