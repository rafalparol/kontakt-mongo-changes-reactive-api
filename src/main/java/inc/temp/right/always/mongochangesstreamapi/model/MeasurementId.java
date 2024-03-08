package inc.temp.right.always.mongochangesstreamapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementId implements Serializable {
    @Field("thermometerid")
    private String thermometerId;
    @Field("measuredat")
    private long measuredAt;
}

