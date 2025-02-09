package com.commerce.clickevent.service;

import com.commerce.clickevent.model.ClickEventRequest;
import com.commerce.clickevent.model.KafkaDataModel;
import config.YAMLConfig;
import io.confluent.kafka.serializers.KafkaJsonSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Component
public class KafkaCustomProducer {

    @Autowired
     YAMLConfig yamlConfig;

    Producer producer;
//    config clouds and kafka for init
    @PostConstruct
    public void init(){
        Properties config = new Properties();
        //        config.put("bootstrap.servers","139.59.176.171:9892,178.128.43.132:9892");
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,yamlConfig.getBootstrap_servers());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class.getName());

        producer = new KafkaProducer(config);
    }

    public  void send (KafkaDataModel request){
        ProducerRecord<String,KafkaDataModel> record = new ProducerRecord<String,KafkaDataModel>(yamlConfig.getTopic(),request);
        producer.send(record);
        producer.flush();
    }

    public void  close(){
        producer.close();
    }
}
