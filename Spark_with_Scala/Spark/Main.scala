package org.itc.com
import org.apache.log4j.{Logger,Level}
import org.apache.spark.SparkContext

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[1]", "MySparkName")

    val rdd1= sc.textFile("C:\\Users\\Andriy Ocheretyanyy\\1Training\\Spark_with_Scala\\SparkFile1.txt")
    val words = rdd1.flatMap(line => line.split(" "))

    val wordcount = words.map(w => (w.toLowerCase(),1))

//    val res = wordcount.reduceByKey(_ + _).map(x => (x._2, x._1)).sortByKey()
//
//    res.collect().foreach(println)

    //    count by key
    val res1 = wordcount.countByKey()

    res1.foreach(println)

  }
}