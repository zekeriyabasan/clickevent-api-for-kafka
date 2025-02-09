package com.commerce.clickevent.service;

import com.commerce.clickevent.model.ClickEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("click")
public class ProducerServiceImpl implements ProducerService{

    @Autowired
    KafkaCustomProducer kafkaCustomProducer;

    @Override
    public ClickEventRequest producer(ClickEventRequest request) {
        kafkaCustomProducer.send(request);
        return request;
    }
}
