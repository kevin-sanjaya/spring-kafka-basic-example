# spring-kafka-basic-example

#### Start Zookeeper in `bin` folder:
`./zookeeper-server-start.sh ../config/zookeeper.properties`

#### Start Kafka Broken in `bin` folder:
`./kafka-server-start.sh ../config/server.properties`

#### Create new Kafka Topic:
`./kafka-topics.sh --create --topic <TOPIC_NAME> -zookeeper \ localhost:2181 --replication-factor 1 --partitions 1`

#### Spring Initializer dependencies:
`Spring for Apache Kafka` `Spring Web`
