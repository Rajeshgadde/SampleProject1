package com.spark.package1

class age(){
  def fun1(a:Int): Unit ={
    if(a>=18 && a<=28){
      println("Your eligible for this job")
    }
    else if(a>28 && a<=120){
      println("Your age is too high to apply")
    }
    else if(a<18 && a>=1){
      println("Your age is too low to apply")
    }
    else{
      println("Unknown age found & enter correct age")
      println("This is under branch for testing")
      println("This is second commit on branch ")
    }
  }
}
object age {
  def main(args:Array[String])={
    println("Enter your age correctly:")
    val a=scala.io.StdIn.readInt()
    val obj=new age()
    obj.fun1(a)
  }
}
