package backend.database;

public class vehicle {
    /**this class is for the vehicles and their components
     * 
     */
	private String vehicle_id;
	private int parking_in;
	private int parking_out;
	private int garageIndex;
	private boolean parked;
	
	// default constructor
	public vehicle() {
		vehicle_id = "";
		parking_in = 0;
		parking_out = 0;
		garageIndex = -1;
		parked = false;
	}
	
	//constructor
	public vehicle(String theVehicle_id, int theParking_in, int theParking_out, int theGarageIndex, boolean theParked) {
		vehicle_id = theVehicle_id;
		parking_in = theParking_in;
		parking_out = theParking_out;
		garageIndex = theGarageIndex;
		parked = theParked;
	}
	
	// return vehicle ID
	public String getVehicle_id() {
		return vehicle_id;
	}
	
	// return parking in time
	public int getParking_in() {
		return parking_in;
	}
		
	// return parking out time
	public int getparking_out() { return parking_out; }

	public int getGarageIndex() { return garageIndex; }

	// return parked bool
	public boolean getParked() { return parked; }

	//set vehicle ID
	public void setVehicle_id(String theVehicle_id) {
		vehicle_id = theVehicle_id;
	}

	//set parking in time
	public void setParking_in(int theParking_in) {
		parking_in = theParking_in;
	}

	//set parking out time
	public void setparking_out(int theParking_out) {
		parking_out = theParking_out;;
	}

	public void setGarageIndex(int theGarageIndex) {
		garageIndex = theGarageIndex;
	}

	public void setParked(boolean theParked) {
		parked = theParked;
	}

	/** @return total parking time of the vehicle in the garage
	 * 
	 */
	
	public Double parkingDuration() {
		double totalParkingTime = 0.0;
		totalParkingTime = parking_out - parking_in;
		return totalParkingTime;
		
	}
	@Override
	public String toString() {
		return "The Vehicle with ID number" + vehicle_id + 
				"enter the parking lot at " + parking_in +
				"and departed at" + parking_out + ".";
	}
	
}

