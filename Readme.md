
## Using KCat for Producing from File

##### Using relative path (running from directory with messages)

```
docker run -it --mount type=bind,src=%cd%,target=/tmp --network=kafka-nw edenhill/kcat:1.7.1 -b kafka:9092 -P -t input-topic /tmp/order1.json
```



## Running Kafdrop

```
docker run -d --rm -p 9000:9000 --network=kafka-nw -e KAFKA_BROKERCONNECT=kafka:9092 -e JVM_OPTS="-Xms32M -Xmx64M" -e SERVER_SERVLET_CONTEXTPATH="/" obsidiandynamics/kafdrop
```



# Great Links

[Kafka Offset Management Confluent](https://docs.confluent.io/platform/current/clients/consumer.html#offset-management)

[Consumer Configs](https://kafka.apache.org/documentation/#consumerconfigs)

[Spring Kakfa Committing Offsets](https://docs.spring.io/spring-kafka/reference/html/#committing-offsets)
