package com.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author
 * @version 2017/7/5.22:12
 */
public class Producer {
    private final KafkaProducer<Object, String> producer;
    private final String topic;

    public Producer(String topic, String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.217.128:9092");
        props.put("client.id", "DemoProducer");
        props.put("batch.size", 16384);//16M
        props.put("linger.ms", 10);
        props.put("buffer.memory", 33554432);//32M
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<Object, String>(props);
        this.topic = topic;
    }

    public void producerMsg() throws InterruptedException {
        int events = 10;
        for (long nEvents = 0; nEvents < events; nEvents++) {
            try {
                producer.send(new ProducerRecord<Object, String>(topic ,nEvents + 1 + ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer("TOPIC-0002", args);
        producer.producerMsg();
        Thread.sleep(20);
    }
}