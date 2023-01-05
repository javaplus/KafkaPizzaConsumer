## Outline

- Have Kafka running in Docker
- Use console consumer and producer to test
- Use Kcat to consume and produce
- Create SpringBoot App and create simple consumer 
- Show group console commands to show offsets
- Use KafDrop to show offsets.
- put delay in consumer and show what happens when sending a batch of records and then killing the app
- Talk about "at least once", "at most once", and "exactly once"???
- Print out Offset and Partition of message.
- Make code error out (throw exception) and see loop/retry then seek ahead.
- Create errorhandler.
- 



## Getting an Offset in the first place.
Consumers use `auto.offset.reset.`  to determine the starting offset.  Only applies if there are no committed offsets for that group.  **earliset** or **latest** are the common options.  Demonstrate this.


## How are Commits Handle by Default

- Commits by default auto commit based on time interval.  But for SpringBoot KafkaListener, seems to be more if no exceptions for batch.  This give you **"at least once"** delivery.  SO, you can have duplicats.  Lowering the `auto.commit.interval.ms` can lower the number of duplicate processing (again doesn't seem to work in Spring's Kafka Listener).
- *NOTE* "Exactly Once Delivery" is really hard in Kafka.  "At most once" is complicated, but most likely doable.  Architecting and planning for "at least once" is your best option.  So, build idempotence into the design.
  From Kafka Docs:
  "So effectively Kafka supports exactly-once delivery in Kafka Streams, and the transactional producer/consumer can be used generally to provide exactly-once delivery when transferring and processing data between Kafka topics. Exactly-once delivery for other destination systems generally requires cooperation with such systems, but Kafka provides the offset which makes implementing this feasible (see also Kafka Connect). Otherwise, Kafka guarantees at-least-once delivery by default, and allows the user to implement at-most-once delivery by disabling retries on the producer and committing offsets in the consumer prior to processing a batch of messages." - https://kafka.apache.org/documentation/#semantics
- Show in SpringBoot default behavior with KafkaListener.


## Manual commits

- Manual commits.  Using `enable.auto.commit` set to false will allow you to manually commit.




## References

https://docs.confluent.io/platform/current/clients/consumer.html#offset-management

##### Consumer config(Confluent):

https://docs.confluent.io/platform/current/installation/configuration/consumer-configs.html#ak-consumer-configurations-for-cp

##### Consumer config(Kafka):
https://kafka.apache.org/documentation/#consumerconfigs

##### Kafka Listener

https://docs.spring.io/spring-kafka/api/org/springframework/kafka/annotation/KafkaListener.html

https://docs.spring.io/spring-boot/docs/current/reference/html/messaging.html#messaging.kafka

- Config Properties:  
https://docs.spring.io/spring-boot/docs/current/reference/html/messaging.html#messaging.kafka.additional-properties

https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.integration

##### Error Hanlding:

https://docs.spring.io/spring-kafka/reference/html/#annotation-error-handling
