package inc.temp.right.always.mongochangesstreamapi.services;

import inc.temp.right.always.mongochangesstreamapi.model.TemperatureMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TemperatureMeasurementsService {
    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;
    public Flux<TemperatureMeasurement> anomalies() {
        return reactiveMongoTemplate
            .changeStream(TemperatureMeasurement.class)
            .watchCollection("anomalies")
            .listen()
            .map(ChangeStreamEvent::getBody);
    }
}
