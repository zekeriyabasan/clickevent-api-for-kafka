package mapper;

import com.commerce.clickevent.model.ClickEventRequest;
import com.commerce.clickevent.model.ClickEventResponse;
import com.commerce.clickevent.model.KafkaDataModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KafkaRequestMapper {
    KafkaRequestMapper MAPPER = Mappers.getMapper(KafkaRequestMapper.class);
    KafkaDataModel ClickEventRequestToKafkaModel(ClickEventRequest request);
    ClickEventResponse CLICK_EVENT_RESPONSE(KafkaDataModel response);
}
