package com.spark.package1

object for1 {
  def main(args:Array[String]):Unit={
    var lst0:List[Any]=List()
    var lst1:List[Any]=List[Int]()
    val lst2=List(1,2,3,4,5,6,7,8,9)
    for(i <- lst2){
      if(i%2!=0){
        lst0=i::lst0  //Prepending
        lst1=lst1:+i //Appending
      }
    }
    println("Appending list is "+lst1)
    println("Prepending list is "+lst0)
  }
}