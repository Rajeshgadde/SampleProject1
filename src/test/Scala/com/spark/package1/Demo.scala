package com.spark.package1

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object Demo {
  def main(args:Array[String])={
    val conf=new SparkConf()
      .setAppName("sample application")
      .setMaster("local")
    val sc=new SparkContext(conf)
    val sqlContext=new SQLContext(sc)
    import sqlContext.implicits._

    val data=sc.textFile("C:/Users/Rajesh/Desktop/access_log_Jul95")
    //data.take(20).foreach(println)
    val r1="[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}".r
    val r2="[0-9]{1,2}/[A-Z][a-z]{2}/[0-9]{4}:[0-9]{2}:[0-9]{2}:[0-9]{2} -[0-9]{4}".r

    val rdd1=data.map{x=>
      val ip=r1.findFirstIn(x).get
      val date=r2.findFirstIn(x).get
      (date)
    }
    //rdd1.take(200).foreach(println)
    val rdd2=rdd1.map { x =>
      val date = x.slice(0, 2)
      val month = x.slice(3, 6)
      val year = x.slice(7, 11)
      (date,month,year)
    }
    rdd2.take(200).foreach(println)
    // val res=rdd2.saveAsTextFile("C:/Users/Rajesh/Desktop/WebLogData")
    //val par=rdd2.getNumPartitions
    //println("The number of Partitions are "+par)
    /* val df=rdd2.toDF("Date","Month","Year")
     //df.show()
     //df.printSchema()
     val df2=df.selectExpr("cast(Date as Int) Date","Month","cast(Year as Int) Year")
     //df2.printSchema()
     */
  }
}
