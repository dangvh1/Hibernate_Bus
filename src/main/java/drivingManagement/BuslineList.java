package drivingManagement;


import entity.Busline;

import java.io.Serializable;

public class BuslineList implements Serializable {
     private Busline busLine;
     private int drivingTurnNumber;

     public BuslineList() {
     }

     public BuslineList(Busline busLine, int drivingTurnNumber) {
          this.busLine = busLine;
          this.drivingTurnNumber = drivingTurnNumber;
     }

     public Busline getRoute() {
          return busLine;
     }

     public void setBusLine(Busline busLine) {
          this.busLine = busLine;
     }

     public int getDrivingTurnNumber() {
          return drivingTurnNumber;
     }

     public void setDrivingTurnNumber(int drivingTurnNumber) {
          this.drivingTurnNumber = drivingTurnNumber;
     }


}
