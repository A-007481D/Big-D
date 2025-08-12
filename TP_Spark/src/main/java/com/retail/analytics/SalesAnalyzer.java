package com.retail.analytics;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import scala.Tuple2;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Sales Analytics Application
 * 
 * This application processes sales data to provide insights such as:
 * - Total sales by city
 * - Annual sales by city
 * 
 * The application can be run locally or on a Spark cluster.
 */
public class SalesAnalyzer {
    // Configure logging
    static {
        Logger.getLogger("org").setLevel(Level.ERROR);
        Logger.getLogger("akka").setLevel(Level.ERROR);
    }

    // Constants
    private static final String APP_NAME = "Retail Sales Analyzer";
    private static final String DATA_FILE_PATH = "data/sales_data.txt";
    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    public static void main(String[] args) {
        // Initialize Spark context
        SparkConf conf = new SparkConf()
            .setAppName(APP_NAME)
            .setMaster("local[*]");

        try (JavaSparkContext sc = new JavaSparkContext(conf)) {
            // Load and process sales data
            JavaRDD<String> salesData = sc.textFile(DATA_FILE_PATH);
            
            // Print total number of sales records
            long totalSales = salesData.count();
            System.out.println("\n📊 Total Sales Records Processed: " + totalSales);

            // Parse the sales data
            JavaRDD<String[]> parsedSales = salesData
                .filter(line -> !line.trim().isEmpty())  // Skip empty lines
                .map(line -> line.split("\\s+"));        // Split by whitespace

            // 1. Calculate total sales by city
            calculateSalesByCity(parsedSales);
            
            // 2. Calculate annual sales by city
            calculateAnnualSalesByCity(parsedSales);
            
        } catch (Exception e) {
            System.err.println("❌ Error processing sales data: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Calculates and prints total sales by city
     * @param salesData Parsed sales data as RDD of String arrays
     */
    private static void calculateSalesByCity(JavaRDD<String[]> salesData) {
        System.out.println("\n🏙️  Total Sales by City:");
        System.out.println("-".repeat(40));
        
        salesData
            .mapToPair(order -> new Tuple2<>(order[1], Integer.parseInt(order[3])))
            .reduceByKey(Integer::sum)
            .sortByKey()
            .foreach(entry -> {
                String formattedAmount = CURRENCY_FORMAT.format(entry._2);
                System.out.printf("%-15s %15s%n", 
                    entry._1 + ":", 
                    formattedAmount);
            });
    }

    /**
     * Calculates and prints annual sales by city
     * @param salesData Parsed sales data as RDD of String arrays
     */
    private static void calculateAnnualSalesByCity(JavaRDD<String[]> salesData) {
        System.out.println("\n📅 Annual Sales by City:");
        System.out.println("-".repeat(40));
        
        salesData
            .mapToPair(order -> {
                String city = order[1];
                String year = order[0].split("/")[2];
                int amount = Integer.parseInt(order[3]);
                return new Tuple2<>(year + " - " + city, amount);
            })
            .reduceByKey(Integer::sum)
            .sortByKey()
            .foreach(entry -> {
                String[] parts = entry._1().split(" - ");
                String year = parts[0];
                String city = parts[1];
                String formattedAmount = CURRENCY_FORMAT.format(entry._2());
                
                System.out.printf("Year: %s | %-15s %15s%n", 
                    year, 
                    city + ":", 
                    formattedAmount);
            });
    }
}
