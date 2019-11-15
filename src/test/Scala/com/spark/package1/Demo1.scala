package com.spark.package1

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}

object Demo1 {
  def main(args:Array[String])={
    val conf=new SparkConf()
      .setAppName("sample application")
      .setMaster("local")
    val sc=new SparkContext(conf)
    val sqlContext=new SQLContext(sc)
    import sqlContext.implicits._

    val emp=sc.textFile("F:/Practice/sparklab/emp.txt")
    //emp.collect.foreach(println)
    val data=emp.map{x=>
      val w=x.split(",")
      val id=w(0)
      val name=w(1)
      val salary=w(2)
      val sex=w(3)
      val dno=w(4)
      (id,name,salary,sex,dno)
    }
    //data.collect.foreach(println)
    val df1=data.toDF("Id","Name","Salary","Sex","Dno")
    //df1.show()
    val df2=df1.select("*")
      .filter(df1("Sex")==="m" and df1("Salary")>= 85000)
    //df2.show()
    val df3=df2.groupBy("Sex","Dno")
      .count()
      .filter("count >= 2")
    //df3.show()
    val rdd1_df1=df1.rdd
    //rdd1_df1.collect.foreach(println)
    val sm=df1.schema
    // println(sm)
    val df1_rdd1=sqlContext.createDataFrame(rdd1_df1,sm)
    //df1_rdd1.show()
    val sm2=StructType{Array(StructField("Id",StringType,true),
      StructField("Name",StringType,true),
      StructField("Salary",IntegerType,true),
      StructField("Sex",StringType,true),
      StructField("Dno",StringType,true))}
    val df1_rdd2=sqlContext.createDataFrame(rdd1_df1,sm2)
    //df1_rdd2.show()
    //df1_rdd2.printSchema()
    val ds1=data.toDS()
    //ds1.show()
  }
}
