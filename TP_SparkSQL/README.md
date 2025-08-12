# 🏭 Industrial Incident Analysis with Spark SQL

A data analysis application that processes industrial incident reports using Apache Spark SQL. This project demonstrates how to perform SQL queries on structured data to derive meaningful insights from incident reports.

## 📋 Project Overview

This application processes industrial incident data to provide valuable insights, including:

- **Incident Count by Service**: Aggregates and counts incidents by department/service
- **Peak Incident Years**: Identifies the top 2 years with the highest number of incidents
- **Data Analysis**: Performs various analytical queries on the incident data

### 🧩 Key Features

- **Structured Data Processing**: Uses Spark SQL for efficient querying of structured data
- **Simple Yet Powerful**: Demonstrates complex analytics with minimal code
- **Scalable**: Can process small to large datasets efficiently
- **Easy to Understand**: Clear, well-documented code for educational purposes

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Apache Spark 3.5.5
- Maven 3.6.3+

### Data Format

The application processes incident data in the following CSV format:
```csv
Id,title,description,service,date
1,Server Downtime,Production server crashed,IT,2023-03-15
2,Water Leak,Water pipe burst in section B,Maintenance,2022-06-20
3,Software Error,Application crash during transaction,IT,2023-08-09
```

### Project Structure

```
TP_SparkSQL/
├── src/
│   └── main/
│       └── java/
│           └── ServiceIncidents.java  # Main application
├── images/                 # Output screenshots
│   ├── 1.png
│   └── 2.png
├── incidents.csv           # Sample incident data
├── pom.xml                 # Maven configuration
└── README.md               # This file
```

## 🛠️ Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd BigDataProject/TP_SparkSQL
   ```

2. **Build the project**
   ```bash
   mvn clean package
   ```

3. **Run the application**
   ```bash
   spark-submit --class ServiceIncidents target/TP_SparkSQL-1.0-SNAPSHOT.jar
   ```

## 📊 Sample Output

The application generates the following analytics:

1. **Incidents by Service**
   ```
   +----------+-------------+
   | service  | nb_incidents|
   +----------+-------------+
   | IT       | 124         |
   | Maintenance | 89       |
   | Security | 67          |
   +----------+-------------+
   ```

2. **Top 2 Years by Incident Count**
   ```
   +----+-------------+
   |year|nb_incidents |
   +----+-------------+
   |2023| 156         |
   |2022| 124         |
   +----+-------------+
   ```

## 🛠️ Technology Stack

- **Java 11**: Stable Java version for Spark compatibility
- **Apache Spark 3.5.5**: Distributed processing engine
- **Spark SQL**: Module for structured data processing
- **Maven**: Dependency management

## 📝 Code Overview

The main application (`ServiceIncidents.java`) performs the following operations:

1. **Initialize Spark Session**:
   ```java
   SparkSession session = SparkSession.builder()
           .master("local[*]")
           .appName("ServiceIncidents")
           .getOrCreate();
   ```

2. **Load and Process Data**:
   ```java
   Dataset<Row> df = session.read()
           .option("header", "true")
           .option("inferSchema", "true")
           .csv("incidents.csv");
   ```

3. **Run Analytical Queries**:
   - Count incidents by service
   - Identify top 2 years with most incidents

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](../LICENSE) file for details.

---
👩‍💻 **Author**: Aisha Saasaa  
📅 **Last Updated**: August 2024