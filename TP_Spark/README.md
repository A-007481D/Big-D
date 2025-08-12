
# 🛍️ Retail Sales Analytics with Apache Spark

A comprehensive big data application that processes and analyzes retail sales data using Apache Spark's RDD API. This project demonstrates batch processing of sales transactions to extract meaningful business insights.

## 📋 Project Overview

This application processes retail sales data to provide valuable business intelligence, including:

- **Total Sales by City**: Aggregates sales figures across different cities
- **Annual Sales Analysis**: Breaks down sales by city and year for trend analysis
- **Product Performance**: Analyzes sales performance across different product categories

### 🧩 Key Features

- **Data Processing**: Efficiently processes large volumes of sales data
- **Parallel Processing**: Leverages Spark's distributed computing capabilities
- **Flexible Deployment**: Can run locally or on a Spark cluster
- **Detailed Reporting**: Generates comprehensive sales reports

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Apache Spark 3.5.0
- Maven 3.6.3+

### Data Format

The application processes sales data in the following format:
```
DD/MM/YYYY  City        Product         Price
27/01/2025  Tangier     AsusZenBook     5950
10/02/2024  Tangier     HPEnvy          6126
14/07/2023  Fes         Iphone15       10123
```

### Project Structure

```
TP_Spark/
├── data/                   # Sample sales data
│   └── ventes.txt
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── retail/
│                   └── analytics/
│                       └── SalesAnalyzer.java  # Main application
├── target/                # Compiled artifacts
├── pom.xml                # Maven configuration
└── README.md              # This file
```

## 🛠️ Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd BigDataProject/TP_Spark
   ```

2. **Build the project**
   ```bash
   mvn clean package
   ```

3. **Run the application**
   ```bash
   spark-submit --class com.retail.analytics.SalesAnalyzer target/TP_Spark-1.0-SNAPSHOT.jar
   ```

## 📊 Sample Output

The application generates the following analytics:

1. **Total Sales by City**
   ```
   City        | Total Sales
   ------------|------------
   Tangier     | $1,234,567
   Casablanca  | $1,123,456
   Rabat       | $987,654
   ```

2. **Sales by City and Year**
   ```
   City        | Year | Total Sales
   ------------|------|------------
   Tangier     | 2024 | $456,789
   Tangier     | 2023 | $389,012
   Casablanca  | 2024 | $512,345
   ```

## 🛠️ Technology Stack

- **Java 17**: Modern Java version for better performance
- **Apache Spark 3.5.0**: Distributed processing engine
- **Maven**: Dependency management
- **Log4j**: Logging framework

## 📝 Notes

- The application is configured to run in local mode by default
- For production deployment, update the Spark configuration in `SalesAnalyzer.java`
- Sample data is provided in the `data` directory

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](../LICENSE) file for details.

---
👩‍💻 **Author**: Aisha Saasaa  
📅 **Last Updated**: August 2024
- **Git** - Version control

---

## 🚀 Local Development

### Prerequisites
- Java 17 or higher
- Maven 3.8.1 or higher
- (Optional) Docker & Docker Compose

### Building the Project
```bash
mvn clean package
```

### Running Locally
```bash
spark-submit --class Main --master local[*] target/TP_Spark-1.0-SNAPSHOT.jar
```

---

## 🐳 Cluster Deployment with Docker

### 1. Project Structure

```
sales-analytics/
├── docker-compose.yml    # Docker Compose configuration
├── app/
│   ├── target/
│   │   └── sales-analytics-1.0.0.jar  # Built application
│   └── data/
│       └── sales_data.txt             # Sample sales data
└── README.md
```

### 2. Starting the Cluster

```bash
docker-compose up -d
```

### 3. Accessing the Web UI
- Spark Master: [http://localhost:8080](http://localhost:8080)
- Spark Worker: [http://localhost:8081](http://localhost:8081)

### 4. Submitting the Application

```bash
docker exec -it spark-master \
  spark-submit \
  --class com.yourname.sales.Main \
  --master spark://spark-master:7077 \
  /app/target/sales-analytics-1.0.0.jar
```

## 📊 Sample Output

```
City Sales Report:
-----------------
City: Fes, Total Sales: 120,450 MAD
City: Casablanca, Total Sales: 98,750 MAD
City: Rabat, Total Sales: 85,200 MAD

Annual Sales by City:
--------------------
2023 - Fes: 45,600 MAD
2023 - Casablanca: 38,200 MAD
2024 - Fes: 74,850 MAD
2024 - Casablanca: 60,550 MAD
```

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

Contributions are welcome! Please read our [Contributing Guide](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.
