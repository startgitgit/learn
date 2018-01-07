package com.test;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author
 * @version 2017/7/5.22:18
 */
public class Consumer {
    private final KafkaConsumer<Integer, String> consumer;
    private final String topic;

    public Consumer(String topic) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.217.128:9092");
        props.put("zookeeper.connect", "192.168.217.128:2181");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "GROUP-2333");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");//latest,earliest
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        consumer = new KafkaConsumer<Integer, String>(props);
        this.topic = topic;
    }

    public void consumerMsg(){
        try {
            consumer.subscribe(Collections.singletonList(this.topic));
            while(true){
                ConsumerRecords<Integer, String> records = consumer.poll(1000);
                for (ConsumerRecord<Integer, String> record : records) {
                    System.out.println("Received message: (" + record.key() + ", " + record.value() + ") at partition "+record.partition()+" offset " + record.offset());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Consumer Consumer = new Consumer("TOPIC-0002");
        Consumer.consumerMsg();
    }

}
