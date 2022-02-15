package entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "driving_assignment")
public class DrivingEntity implements Serializable {
    @Id
    @ManyToOne(targetEntity = entity.Driver.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    Driver driver;

    @Id
    @ManyToOne(targetEntity = entity.Busline.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_line_id", nullable = false)
    Busline busline;

    @Column(name = "driving_turn_number", nullable = false)
    int drivingTurnNumber;
}
