package com.spark.package1

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object cancerData {
  def main(args:Array[String])={
    val conf=new SparkConf()
      .setAppName("cancer data analysis")
      .setMaster("local")

    val sc=new SparkContext(conf)
    val sqlContext=new SQLContext(sc)
    import sqlContext._
    import sqlContext.implicits._

    val data=sqlContext
      .read
      .format("com.databricks.spark.csv")
      .option("inferSchema","true")
      .option("header","true")
      .load("F:/Practice/sparklab/breast_cancer_clinical_data.csv")
    data.show()
    data.printSchema()
  }
}
