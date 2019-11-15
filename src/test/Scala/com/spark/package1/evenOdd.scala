package com.spark.package1

class Num{
  def fun(x:Int,y:Int)={
    if(x==y){
      println("Num1 and Num2 both are equal")
    }
    else if(x>y){
      println("Num1 is greater then Num2")
    }
    else{
      println("Num2 is greater then Num1")
    }
  }
}
object evnOdd{
  def main(args:Array[String])={
    println("Enter Num1 ")
    val a=scala.io.StdIn.readInt()
    println("Enter Num2 ")
    val b=scala.io.StdIn.readInt()
    val obj=new Num
    obj.fun(a,b)
  }
}
