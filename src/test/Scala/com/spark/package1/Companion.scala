package com.spark.package1

class Companion(x:Int){
  println("Your age is "+x)
  def after()={
    println("This is empty function")
  }
}
object Companion {
  def main(args:Array[String])={
    val obj=new Companion(23)
    obj.after
  }
}
