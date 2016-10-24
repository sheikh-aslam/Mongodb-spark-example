package momgodb.spark.java.stockprice;

import com.mongodb.hadoop.BSONFileOutputFormat;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.SparkConf;
import com.mongodb.hadoop.MongoInputFormat;
import com.mongodb.hadoop.MongoOutputFormat;
import org.apache.hadoop.conf.Configuration;
import org.bson.BSONObject;

/**
 *
 * @author kafka
 */
public class DataImporter {

    public static void main(String[] args) {
        System.out.println("Start of program .....");
        Configuration mongodbConfig = new Configuration();
        mongodbConfig.set("mongo.job.input.format", "com.mongodb.hadoop.MongoInputFormat");
        mongodbConfig.set("mongo.input.uri", "mongodb://localhost:27017/marketdata.minibars");
        SparkConf conf = new SparkConf().setAppName("Data importer");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<Object, BSONObject> documents = sc.newAPIHadoopRDD(
                mongodbConfig, // Configuration
                MongoInputFormat.class, // InputFormat: read from a live cluster.
                Object.class, // Key class
                BSONObject.class // Value class
        );

        System.out.println("Total Count : " + documents.count());
        System.out.println("First Record : " + documents.first());

        // Create a separate Configuration for saving data back to MongoDB.
        Configuration outputConfig = new Configuration();
//        outputConfig.set("mongo.output.uri",
//                "mongodb://localhost:27017/marketdata.outputcollection");

        // Save this RDD as a Hadoop "file".
        // The path argument is unused; all documents will go to 'mongo.output.uri'.
//        documents.saveAsNewAPIHadoopFile(
//                "hdfs://localhost:8020//home/ubuntu/sparktextdemo",
//                Object.class,
//                BSONObject.class,
//                MongoOutputFormat.class,
//                outputConfig
//        );

        // We can also save this back to a BSON file.
        documents.saveAsNewAPIHadoopFile(
                "hdfs://localhost:8020//home/ubuntu/sparkbsondemo",
                Object.class,
                BSONObject.class,
                BSONFileOutputFormat.class,
                new Configuration()
        );

        System.out.println("End of program .....");
    }

}
