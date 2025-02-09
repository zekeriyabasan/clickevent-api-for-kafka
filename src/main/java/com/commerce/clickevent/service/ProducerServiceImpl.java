package com.commerce.clickevent.service;

import com.commerce.clickevent.model.ClickEventRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("click")
public class ProducerServiceImpl implements ProducerService{
    @Override
    public ClickEventRequest producer(ClickEventRequest request) {

    }
}
