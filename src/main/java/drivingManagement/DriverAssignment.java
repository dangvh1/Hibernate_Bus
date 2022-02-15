package drivingManagement;

import entity.Driver;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverAssignment implements Serializable {
    private Driver driver;
    private List<BuslineList> busLineLists = new ArrayList<>();
    private int busLineSum;
    private float distanceSum;

    public DriverAssignment(Driver driver, List<BuslineList> busLineLists) {
        this.driver = driver;
        this.busLineLists = busLineLists;
    }

}
