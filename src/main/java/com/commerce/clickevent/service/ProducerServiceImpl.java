package com.commerce.clickevent.service;

import com.commerce.clickevent.model.ClickEventRequest;
import com.commerce.clickevent.model.ClickEventResponse;
import com.commerce.clickevent.model.KafkaDataModel;
import mapper.KafkaRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Qualifier("click")
public class ProducerServiceImpl implements ProducerService{

    @Autowired
    KafkaCustomProducer kafkaCustomProducer;

    @Override
    public ClickEventResponse producer(ClickEventRequest request) {
        try{
            KafkaDataModel mappedRequest = KafkaRequestMapper.MAPPER.ClickEventRequestToKafkaModel(request);
            kafkaCustomProducer.send(mappedRequest);
            ClickEventResponse response = KafkaRequestMapper.MAPPER.CLICK_EVENT_RESPONSE((mappedRequest));
            response.setStatusCode(200);
            response.setStatus("SUCCESS");

            return response;
        }
        catch (Exception ex){
            ClickEventResponse res = new ClickEventResponse();
            res.setStatusCode(204);
            res.setDeviceId(request.getDeviceId());
            res.setTimestamp(Instant.now().toString());
            return  res;
        }

    }
}
