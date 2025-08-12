
# 📊 Sales Analytics with Apache Spark

This project demonstrates **parallel** and **distributed** processing of sales data using **Apache Spark** with Java. It's designed to analyze retail sales data across different cities and products, with support for both local development and Docker-based cluster deployment.

---

## 🎯 Project Overview

This project includes two main analytical components:

1. **Sales Analysis by City**
   - Processes sales data from `ventes.txt`
   - Calculates total sales per city
   - Provides insights into regional sales performance

2. **Annual Sales Analysis**
   - Groups sales data by both city and year
   - Enables year-over-year sales comparison
   - Helps identify seasonal trends and growth patterns

### Sample Data Format
```
date        city        product         price
10/02/2024  Tangier     HPEnvy          6126
14/07/2023  Fes         Iphone15       10123
09/07/2023  Tangier     OppoReno11      8886
```

---

## 📁 Arborescence

```
TP_Spark/
├── src/
│   └── main/java/Main.java
├── ventes.txt
├── pom.xml
└── target/TP_Spark-1.0-SNAPSHOT.jar
```

---

## 🛠️ Technology Stack

- **Java 17** - Modern Java version for better performance
- **Apache Spark 3.5.0** - Distributed processing engine
- **Maven** - Dependency management
- **Docker & Docker Compose** - Containerization and orchestration
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

## ✍️ Auteur

**Saad El Mabrouk**  
📚 TP Big Data Spark
📅 Avril 2025
