package backend.database;
import backend.database.Schedule;
import java.util.ArrayList;

public class userProfile {
    private String vehicleId;
    private String userFirstName;
    private String userLastName;
    private String permitType;
    private String parkingCost;
    private String parkingMeter;
    private String userRole;
    private Schedule schedule;
    private ArrayList<Integer> dailyStartTimes;

    // Constructor
    public userProfile(String vehicleId, String userFirstName, String userLastName, String permitType, String parkingCost, String parkingMeter, String userRole, Schedule schedule, ArrayList<Integer> dailyStartTimes) {
        this.vehicleId = vehicleId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.permitType = permitType;
        this.parkingCost = parkingCost;
        this.parkingMeter = parkingMeter;
        this.userRole = userRole;
        this.dailyStartTimes = new ArrayList<Integer>(7);

        // Set each daily start time to 7AM by default
        for (int i = 0; i < 7; i++) {
            this.dailyStartTimes.add(420);
        }

    }

    // Getter and Setter methods for vehicleId
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    // Getter and Setter methods for userFirstName
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    // Getter and Setter methods for userLastName
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    // Getter and Setter methods for permitType
    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    // Getter and Setter methods for parkingCost
    public String getParkingCost() {
        return parkingCost;
    }

    public void setParkingCost(String parkingCost) {
        this.parkingCost = parkingCost;
    }

    // Getter and Setter methods for parkingMeter
    public String getParkingMeter() {
        return parkingMeter;
    }

    public void setParkingMeter(String parkingMeter) {
        this.parkingMeter = parkingMeter;
    }

    // Getter and Setter methods for userRole
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    public void setSchedule(Schedule schedule){
        this.schedule = schedule;
    }
    public Schedule getSchedule(){
        return this.schedule;
    }

    // Takes a day index 0-6 (Monday == 0, Tuesday == 1, etc.) and sets its value equal to the time parameter
    public void setDailyStartTime(int dayToSet, int time) { this.dailyStartTimes.set(dayToSet, time); }

    // Takes a day index 0-6 (Monday == 0, Tuesday == 1, etc.) and returns the start time associated with that day.
    public int getDailyStartTime(int dayToGet) { return this.dailyStartTimes.get(dayToGet); }
    // You can also add any additional methods or functionality here as needed
}

