package com.spark.package1

class A{
  def add(x:Int,y:Int)={
    val c=x+y
    println("The addition of two numbers are "+c)
  }
}
class B extends A {
  def sub(x:Int,y:Int)={
    val c=x-y
    println("The substraction of two numbers are "+c)
  }
}
class C extends B{
  def mul(x:Int,y:Int,z:Int)={
    val c=x*y*z
    println("The multiplication of three numbers are "+c)
  }
}
object Inheritance {
  def main(args:Array[String])={
    val obj=new C
    obj.add(2,6)
    obj.sub(10,5)
    obj.mul(1,2,3)
  }
}
