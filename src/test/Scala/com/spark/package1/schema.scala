package com.spark.package1

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.{FloatType, IntegerType, StringType, StructField, StructType}

object schema {
  def main(args: Array[String]) = {
    val conf = new SparkConf()
      .setAppName("sample data for analysis")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val df1 = sqlContext
      .read
      .format("com.databricks.spark.csv")
      .option("header", "false")
      .option("inferSchema", "true")
      .load("F:/Practice/sparklab/example.csv")
    //df1.show()
    //df1.printSchema()
    val sch=StructType(StructField("Id",IntegerType,false)::StructField("Name",StringType,false)::StructField("Exp",FloatType,false)::Nil)
    val df2 = sqlContext
      .read
      .format("com.databricks.spark.csv")
      .option("header", "false")
      .schema(sch)
      .option("inferSchema", "true")
      .load("F:/Practice/sparklab/example.csv")
    df2.show()
    df2.printSchema()
  }
}
