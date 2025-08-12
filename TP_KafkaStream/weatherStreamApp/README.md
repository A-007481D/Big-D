# 🌦️ Real-time Weather Data Processing with Kafka Streams

A Kafka Streams application that processes real-time weather data, applies transformations, and calculates aggregated metrics. This project demonstrates stream processing capabilities including filtering, mapping, and windowed aggregations.

## 🌟 Features

- **Real-time Processing**: Processes weather data as it arrives
- **Temperature Filtering**: Filters out temperatures below 30°C
- **Unit Conversion**: Converts temperatures from Celsius to Fahrenheit
- **Aggregation**: Calculates average temperature and humidity per weather station
- **Scalable**: Built on Kafka Streams for distributed processing

## 🏗️ Architecture

```
┌─────────────────┐     ┌─────────────────────┐     ┌───────────────────────┐
│  Weather Data   │────▶│  Kafka Topic:       │────▶│  Kafka Streams App    │
│  Producer       │     │  weather-data       │     │  (Processing Logic)   │
└─────────────────┘     └─────────────────────┘     └───────────┬───────────┘
                                                               │
                                                               ▼
┌─────────────────┐     ┌─────────────────────┐     ┌───────────────────────┐
│  Data Consumers │◀────│  Kafka Topic:       │◀────│  Aggregated Results  │
│  (Dashboards,   │     │  station-averages   │     │  (Averages by Station)│
│   Analytics)    │     │                     │     │                       │
└─────────────────┘     └─────────────────────┘     └───────────────────────┘
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Apache Kafka 3.0+
- Maven 3.6.3+
- Docker (optional, for running Kafka)

### Data Format

The application expects weather data in the following CSV format:
```
StationName,TemperatureInCelsius,Humidity
```
Example:
```
StationA,32.5,65.2
StationB,28.7,70.1
```

### Running with Docker Compose

The easiest way to run the application is using the provided `docker-compose.yml` in the parent directory:

```bash
# From the TP_KafkaStream directory
docker-compose up -d
```

This will start:
- Zookeeper
- Kafka Broker
- Kafka UI (accessible at http://localhost:8080)

### Manual Setup

1. **Start Kafka**
   ```bash
   # Start Zookeeper
   bin/zookeeper-server-start.sh config/zookeeper.properties
   
   # Start Kafka
   bin/kafka-server-start.sh config/server.properties
   ```

2. **Create Kafka Topics**
   ```bash
   # Create topics
   kafka-topics --create --topic weather-data --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092
   kafka-topics --create --topic station-averages --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092
   ```

3. **Build and Run the Application**
   ```bash
   mvn clean package
   java -jar target/weatherStreamApp-1.0-SNAPSHOT.jar
   ```

## 🔍 Data Processing Pipeline

The application implements the following processing steps:

1. **Source**: Consumes messages from the `weather-data` topic
2. **Filter**: Keeps only records where temperature > 30°C
3. **Transform**: Converts temperature from Celsius to Fahrenheit
4. **Aggregate**: Calculates average temperature and humidity per station
5. **Sink**: Writes results to the `station-averages` topic

## 📊 Monitoring

You can monitor the Kafka topics using the Kafka UI at http://localhost:8080 or using the Kafka CLI:

```bash
# View raw weather data
kafka-console-consumer --bootstrap-server localhost:9092 --topic weather-data --from-beginning

# View processed averages
kafka-console-consumer --bootstrap-server localhost:9092 --topic station-averages --from-beginning
```

## 📝 Sample Data

To test the application, you can produce sample weather data:

```bash
kafka-console-producer --broker-list localhost:9092 --topic weather-data
>StationA,32.5,65.2
>StationB,28.7,70.1
>StationA,35.1,62.8
>StationC,31.2,68.5
```

## 🛠️ Technology Stack

- **Kafka Streams**: Real-time stream processing
- **Apache Kafka 3.0+**: Message broker
- **Maven**: Build and dependency management
- **Java 17+**: Programming language

## 📸 Screenshots

### Raw Weather Data Input
Shows the Kafka producer sending raw weather data to the `weather-data` topic.
![producer-input](imgs/weather-producer-input.png)

### Stream Processing Logs
Displays the real-time processing logs showing filtered and transformed data.
![stream-processing](imgs/weather-stream-processing.png)

### Processed Output
Example of the final aggregated data in the `station-averages` topic.
![processed-output](imgs/weather-processed-output.png)

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](../../LICENSE) file for details.

---
👩‍💻 **Author**: Aisha Saasaa  
📅 **Last Updated**: August 2024

![consumer-output](imgs/weather-consumer-output.png.png)




