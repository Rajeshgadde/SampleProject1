package com.spark.package1

abstract class child(){    //Abstract class
  def add                  //Non-implemented method
  def sub                  //Non-implemented method
  def mul(): Unit ={
    println("mul method")  //Implemented method
  }
}
class parent extends child{ //Extending abstract class into another class
  def add()={
    println("add method")
  }
  def sub(): Unit ={
    println("sub method")
  }
}
object abstract1 {
  def main(args:Array[String])={
    val obj=new parent()
    obj.add()
    obj.sub()
    obj.mul()
  }
}
