package com.commerce.clickevent.api;

import com.commerce.clickevent.model.ClickEventRequest;
import com.commerce.clickevent.model.ClickEventResponse;
import com.commerce.clickevent.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClickEventController {

    @Autowired
    @Qualifier("click")
    ProducerService producerService;

    @PostMapping("/click")
    ClickEventResponse clickEventRequest(@RequestBody ClickEventRequest request){
        ClickEventResponse response = producerService.producer(request);
        return  response;
    }
}
