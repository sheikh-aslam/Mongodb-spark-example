https://github.com/sheikh-aslam/Mongodb-spark-example

Mongodb-spark-example

Basic eample on using spark to communicate with mongodb

This is a simple example based on resourse i found over the internet. 
This example will help you to get started with mongodb data analysis using spark.
=============================
= Command to submit the job =
=============================

spark-submit \ --class "momgodb.spark.java.stockprice.DataImporter" \ --master local[4] \ /home/ubuntu/jars/stockprice-1.0-SNAPSHOT.jar

I used above command to run job on our AWS cluster, you might need to make few changes in it.

# Reference link:
https://www.mongodb.com/blog/post/using-mongodb-hadoop-spark-part-1-introduction-setup

