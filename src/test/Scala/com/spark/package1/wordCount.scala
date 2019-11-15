package com.spark.package1

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

object wordCount {
  def main(args: Array[String]) = {
    val conf = new SparkConf()
      .setAppName("sample application")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    val raw=sc.textFile("F:/Practice/sparklab/sample.txt")
    //raw.take(20).foreach(println)
    val fm=raw.flatMap(x=> x.split(" ")).map(x=> (x,1)).reduceByKey(_+_)
    // fm.take(40).foreach(println)
    fm.saveAsTextFile("C:/Users/Rajesh/Desktop/output")
  }
}