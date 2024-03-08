package inc.temp.right.always.mongochangesstreamapi.repositories;

import inc.temp.right.always.mongochangesstreamapi.model.TemperatureMeasurement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TemperatureMeasurementsRepository extends ReactiveMongoRepository<TemperatureMeasurement, String> {

}
