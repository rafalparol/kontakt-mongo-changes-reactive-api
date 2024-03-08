package inc.temp.right.always.mongochangesstreamapi.controllers;

import inc.temp.right.always.mongochangesstreamapi.model.TemperatureMeasurement;
import inc.temp.right.always.mongochangesstreamapi.repositories.TemperatureMeasurementsRepository;
import inc.temp.right.always.mongochangesstreamapi.services.TemperatureMeasurementsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Log4j2
public class TemperatureMeasurementsController {
    @Autowired
    private TemperatureMeasurementsService temperatureMeasurementsService;

    @Autowired
    private TemperatureMeasurementsRepository temperatureMeasurementsRepository;

    @GetMapping(value = "/anomaliesStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TemperatureMeasurement> anomalies() {
        return temperatureMeasurementsService.anomalies();
    }

    @PostMapping(value = "/anomaly", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TemperatureMeasurement> anomaly(@RequestBody TemperatureMeasurement temperatureMeasurement) {
        return temperatureMeasurementsRepository.save(temperatureMeasurement);
    }
}
