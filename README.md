# 📊 Big Data Processing Projects

A collection of big data processing applications demonstrating various technologies including Apache Spark, Spark SQL, and Kafka Streams. This repository serves as a practical implementation of big data concepts and real-time data processing.

## 🚀 Project Structure

```
BigDataProject/
├── TP_Spark/               # Batch processing with Apache Spark RDDs
│   ├── data/               # Sample data files
│   ├── src/                # Java source code
│   └── pom.xml             # Maven build configuration
│
├── TP_SparkSQL/            # SQL-based analytics with Spark SQL
│   ├── images/             # Output and diagram files
│   ├── src/                # Java source code
│   └── pom.xml             # Maven build configuration
│
└── TP_KafkaStream/         # Real-time stream processing
    ├── click-counter-app/  # User click event processor
    ├── weatherStreamApp/   # Weather data stream processor
    └── docker-compose.yml  # Kafka and Zookeeper setup
```

## 📋 Project Descriptions

### 1. TP_Spark - Retail Sales Analytics
- **Purpose**: Batch processing of retail sales data using Apache Spark RDDs
- **Features**:
  - Process sales transactions from text files
  - Calculate total sales by city
  - Analyze sales trends over time
- **Tech Stack**: Java 17, Apache Spark 3.5.0, Maven

### 2. TP_SparkSQL - Industrial Incident Analysis
- **Purpose**: SQL-based analysis of industrial incident reports
- **Features**:
  - Process CSV incident data
  - Aggregate incidents by service
  - Identify peak incident periods
- **Tech Stack**: Java 11, Apache Spark 3.5.5, Spark SQL, Maven

### 3. TP_KafkaStream - Real-time Data Processing
- **Click Counter App**:
  - Tracks user click events in real-time
  - Provides REST API for querying click statistics
  - Uses Kafka Streams for processing
  
- **Weather Stream App**:
  - Processes real-time weather data
  - Calculates temperature and humidity statistics
  - Implements stream processing with Kafka Streams

## 🛠️ Prerequisites

- Java 11+ (17 recommended)
- Apache Maven 3.6.3+
- Docker 20.10+ (for Kafka Streams applications)
- Apache Spark 3.5.0+ (for Spark applications)

## 🚀 Getting Started

### TP_Spark
```bash
cd TP_Spark
mvn clean package
spark-submit --class com.retail.analytics.SalesAnalyzer target/TP_Spark-1.0-SNAPSHOT.jar
```

### TP_SparkSQL
```bash
cd TP_SparkSQL
mvn clean package
spark-submit --class com.incident.analytics.ServiceIncidents target/TP_SparkSQL-1.0-SNAPSHOT.jar
```

### TP_KafkaStream
```bash
# Start Kafka and Zookeeper
cd TP_KafkaStream
docker-compose up -d

# Run individual applications
cd click-counter-app
mvn spring-boot:run
```

## 📊 Sample Data

Sample data files are included in each module's directory:
- TP_Spark: `data/ventes.txt`
- TP_SparkSQL: `incidents.csv`
- TP_KafkaStream: Sample data generated at runtime

## 📝 Documentation

Each module contains its own detailed README with specific instructions:
- [TP_Spark Documentation](./TP_Spark/README.md)
- [TP_SparkSQL Documentation](./TP_SparkSQL/README.md)
- [TP_KafkaStream Documentation](./TP_KafkaStream/README.md)

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
👩‍💻 **Author**: Aisha Saasaa  
📅 **Last Updated**: August 2024