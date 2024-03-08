package inc.temp.right.always.mongochangesstreamapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("anomalies")
public class TemperatureMeasurement implements Serializable {
    @Id
    private String identity;
    @Field("thermometerid")
    private String thermometerId;
    @Field("measuredat")
    private long measuredAt;
    @Field("roomid")
    private String roomId;
    @Field("temperature")
    private double temperature;
}
