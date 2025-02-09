package com.commerce.clickevent.service;

import com.commerce.clickevent.model.ClickEventRequest;
import com.commerce.clickevent.model.ClickEventResponse;

public interface ProducerService {

    ClickEventResponse producer(ClickEventRequest request);
}
