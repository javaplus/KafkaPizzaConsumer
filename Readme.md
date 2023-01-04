
## Using KCat for Producing from File

##### Using relative path (running from directory with messages)

```
docker run -it --mount type=bind,src=%cd%,target=/tmp --network=kafka-nw edenhill/kcat:1.7.1 -b kafka:9092 -P -t input-topic /tmp/order1.json
```

## Useful Kafka Commands:
###### These examples are running from local kafka install
```CMD
kafka-topics --list --bootstrap-server=localhost:9092

kafka-topics --delete --topic input-topic --bootstrap-server=localhost:9092

kafka-consumer-groups.bat --list --bootstrap-server=localhost:9092

kafka-consumer-groups.bat --describe --group pizza-order-app --bootstrap-server=localhost:9092

```




## Running Kafdrop

```
docker run -d --rm -p 9000:9000 --network=kafka-nw -e KAFKA_BROKERCONNECT=kafka:9092 -e JVM_OPTS="-Xms32M -Xmx64M" -e SERVER_SERVLET_CONTEXTPATH="/" obsidiandynamics/kafdrop
```



