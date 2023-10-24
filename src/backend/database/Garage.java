package backend.database;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Garage {
    private String name;
    private int maxCapacity;
    private int occupancy;
    private int numVehiclesEnteringPerMin;
    private int avgParkingDuration;
    private int avgTimeToPark;

    public List<vehicle> parkingVehicleList;

    public Garage(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.occupancy = 0;
        this.numVehiclesEnteringPerMin = 0;
        this.avgParkingDuration = 0;
        this.avgTimeToPark = 0;
        this.parkingVehicleList = new CopyOnWriteArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getOccupancy() {return occupancy;}

    public void setOccupancy(int newOccupancy) {occupancy = newOccupancy;}

    public int getNumVehiclesEnteringPerMin() {return numVehiclesEnteringPerMin;}
    public void setNumVehiclesEnteringPerMin(int newVehPerMin) {numVehiclesEnteringPerMin = newVehPerMin;}

    public int getAvgParkingDuration() {return avgParkingDuration;}
    public void setAvgParkingDuration(int newParkDur) {avgParkingDuration = newParkDur;}
    public int getAvgTimeToPark() {return avgTimeToPark;}
    public void setAvgTimeToPark(int newAvgTimeToPark) {avgTimeToPark = newAvgTimeToPark;}

}