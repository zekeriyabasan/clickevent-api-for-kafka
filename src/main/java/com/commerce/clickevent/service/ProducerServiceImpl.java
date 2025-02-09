package com.commerce.clickevent.service;

import com.commerce.clickevent.model.ClickEventRequest;
import com.commerce.clickevent.model.KafkaDataModel;
import mapper.KafkaRequestMapper;
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
        KafkaDataModel mappedRequest = KafkaRequestMapper.MAPPER.ClickEventRequestToKafkaModel(request);
        kafkaCustomProducer.send(mappedRequest);
        return request;
    }
}
