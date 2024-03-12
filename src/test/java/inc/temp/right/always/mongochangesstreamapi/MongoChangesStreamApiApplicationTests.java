package inc.temp.right.always.mongochangesstreamapi;

import inc.temp.right.always.mongochangesstreamapi.model.TemperatureMeasurement;
import inc.temp.right.always.mongochangesstreamapi.services.TemperatureMeasurementsService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import inc.temp.right.always.mongochangesstreamapi.controllers.TemperatureMeasurementsController;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class MongoChangesStreamApiApplicationTests {
	@Test
	void TemperatureMeasurementsController_anomalies_Test() {
		TemperatureMeasurementsController temperatureMeasurementsController = new TemperatureMeasurementsController();
		TemperatureMeasurementsService temperatureMeasurementsService = mock(TemperatureMeasurementsService.class);

		TemperatureMeasurement temperatureMeasurement1 = new TemperatureMeasurement("thermometer-1-" + Timestamp.valueOf("2024-02-01 00:00:01").toInstant().toEpochMilli(), "thermometer-1", Timestamp.valueOf("2024-02-01 00:00:01").toInstant().toEpochMilli(), "room-1", 20.0);
		TemperatureMeasurement temperatureMeasurement2 = new TemperatureMeasurement("thermometer-1-" + Timestamp.valueOf("2024-02-01 00:00:02").toInstant().toEpochMilli(), "thermometer-1", Timestamp.valueOf("2024-02-01 00:00:02").toInstant().toEpochMilli(), "room-1", 25.0);
		TemperatureMeasurement temperatureMeasurement3 = new TemperatureMeasurement("thermometer-1-" + Timestamp.valueOf("2024-02-01 00:00:03").toInstant().toEpochMilli(), "thermometer-1", Timestamp.valueOf("2024-02-01 00:00:03").toInstant().toEpochMilli(), "room-1", 30.0);

		Flux<TemperatureMeasurement> expectedResult = Flux.just(temperatureMeasurement1, temperatureMeasurement2, temperatureMeasurement3);

		when(temperatureMeasurementsService.anomalies()).thenReturn(Flux.just(temperatureMeasurement1, temperatureMeasurement2, temperatureMeasurement3));

		temperatureMeasurementsController.setTemperatureMeasurementsService(temperatureMeasurementsService);

		Flux<TemperatureMeasurement> result = temperatureMeasurementsController.anomalies();

		verify(temperatureMeasurementsService, times(1)).anomalies();

		assertIterableEquals(expectedResult.toIterable(), result.toIterable(), String.format("Expected result: %s and returned result: %s are not the same when returning stream of anomalies.", expectedResult.toIterable(), result.toIterable()));
	}
}
