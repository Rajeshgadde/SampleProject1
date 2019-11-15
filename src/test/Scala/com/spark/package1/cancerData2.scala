package com.spark.package1

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions.{when, _}

object cancerData2 {
  def main(args:Array[String])={
    val conf=new SparkConf()
      .setAppName("sample data for analysis")
      .setMaster("local")
    val sc=new SparkContext(conf)
    val sqlContext=new SQLContext(sc)
    import sqlContext.implicits._

    val df1=sqlContext
      .read
      .format("com.databricks.spark.csv")
      .option("header","true")
      .option("inferSchema","true")
      .load("F:/Practice/sparklab/breast_cancer_clinical_data.csv")
    // df1.printSchema()
    // df1.show()
    //println(df1.count())
    val df2=df1.filter((df1("Age at Initial Pathologic Diagnosis")>50 and df1("Age at Initial Pathologic Diagnosis")<=60 and df1("Gender")==="MALE"))
    //df2.show()
    val df3=df1.withColumn("Gender",when(col("Gender")==="MALE","M")
      .when(col("Gender")==="FEMALE","F")
      .otherwise("Unknown"))
    // df3.show(100)
    val df4=df1.withColumn("AgeGroup",when(col("Age at Initial Pathologic Diagnosis")<=18,"Teenage")
      .when(col("Age at Initial Pathologic Diagnosis")>18 and col("Age at Initial Pathologic Diagnosis")<=40,"Middleage")
      .when(col("Age at Initial Pathologic Diagnosis")>40,"Oldage")
      .otherwise("Unknownage"))
    // df4.show(105)
    val df5=df1.withColumn("Age at Initial Pathologic Diagnosis",when(col("Age at Initial Pathologic Diagnosis")<=18,"Teenage")
      .when(col("Age at Initial Pathologic Diagnosis")>18 and col("Age at Initial Pathologic Diagnosis")<=40,"Middleage")
      .when(col("Age at Initial Pathologic Diagnosis")>40,"Oldage")
      .otherwise("Unknownage"))
    //df5.show(105)
    val df6=df1.withColumnRenamed("Gender","Sex")
      .withColumnRenamed("Age at Initial Pathologic Diagnosis","Age")
    // df6.printSchema()
    val df7=df6.withColumn("Age",col("Age").cast("Float"))
      .withColumn("Days to Date of Last Contact",col("Days to Date of Last Contact").cast("Double"))
    // df7.printSchema()
    val df8=df7.withColumn("Newage",col("Age")+10)
    //df8.show()
    val df9=df6.withColumn("Present_Date",lit(current_date()))
    //df9.show()

    val df10=df7.groupBy("Sex","Age").agg(count("*") as "count")
    df10.show()

  }
}
