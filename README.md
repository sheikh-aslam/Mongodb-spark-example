# Mongodb-spark-example
Basic eample on using spark to communicate with mongodb

This is a simple example based on resourse i found over the internet.
This example will help you to get started with mongodb data analysis using spark.


#=============================#
#= Command to submit the job =#
#=============================#
spark-submit \
  --class "momgodb.spark.java.stockprice.DataImporter" \
  --master local[4] \
  /home/ubuntu/jars/stockprice-1.0-SNAPSHOT.jar

i used above command to run job on our AWS cluster, you might need to make few changes in it.


