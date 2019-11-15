package com.spark.package1

object while1 {
  def main(args:Array[String])={
    var a=0
    while(a<=10){
      if(a%2==0){
        println(a+" is even number")
      }
      else{
        println(a+" is odd number")
      }
      a+=1
    }
  }
}