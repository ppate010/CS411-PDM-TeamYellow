
import backend.database.parkingStructure;
import backend.algorithms.garageAvailabilityAlgorithm;

import java.util.LinkedList;
import test.dataGen;
import backend.database.vehicle;

public class Main {
    public static void main(String[] args) {

        //Execute sim SIM WILL LAST 6 HOURS

        //Create 2 parking structure objects
        //set size of parking structures
        //start time = 1200
        //set average parking time
        //set vehicles per minute

        //updatable variables: occupancy, prio reccomendation, time, notifications

        //input from user: hardcoded temporarily
        int sizeOfLots = 100;
        int avgParkTime = 30;
        int vehPerMin = 1;
        int prioGarage = 1;
        int secondaryGarage = 2;

        //Create parking structures
        parkingStructure struct1 = new parkingStructure("1", sizeOfLots, 0, 0, 0); //last 3 variables temp irrelevant
        parkingStructure struct2 = new parkingStructure("2", sizeOfLots, 0, 0, 0);

        parkingStructure[] structArray = new parkingStructure[3];
        structArray[1] = struct1;
        structArray[2] = struct2;

        //make 2 queues to remove vehicles from structures
        LinkedList<Integer> struct1out = new LinkedList<Integer>();
        LinkedList<Integer> struct2out = new LinkedList<Integer>();

        String notification = "";
        int time = 1200;

        while (time <= 1800) { //iterate every minute until 1800

            //remove vehicles from garage 1
            if (!(struct1out.isEmpty())) {
                while (struct1out.contains(time)) { //see if a car is leaving during current minute
                    struct1out.removeFirstOccurrence(time); //remove car from out list
                    structArray[prioGarage].setCurrent_capacity(structArray[prioGarage].getCurrent_capacity() - 1); //remove vehicle from structure1
                }
            }

            //remove vehicles from garage 2
            if (!(struct2out.isEmpty())) {
                while (struct2out.contains(time)) { //see if a car is leaving during current minute
                    struct2out.removeFirstOccurrence(time); //remove car from out list
                    structArray[secondaryGarage].setCurrent_capacity(structArray[secondaryGarage].getCurrent_capacity() - 1); //remove vehicle from structure1
                }
            }

            for (int i = 0; i < vehPerMin; i++) { //add vehicles

                //Determine which garage:
                if (!(garageAvailabilityAlgorithm.garageFull(structArray[prioGarage].getTotal_capacity(), structArray[prioGarage].getCurrent_capacity()))) { //priority garage not full

                    //add vehicle to garage
                    structArray[prioGarage].setCurrent_capacity(structArray[prioGarage].getCurrent_capacity() + 1);

                    int randParkDur = (avgParkTime - 10) + (int)(Math.random() * (((avgParkTime + 10) - (avgParkTime - 10)) + 1)); //from stackoverflow random int in range
                    vehicle newVeh = dataGen.genVehicle("vehicle id", time, randParkDur); //create new vehicle object
                    struct1out.add(newVeh.getparking_out());

                    notification = "Sending to Garage 1";

                    //TEST
                    System.out.println("Time: " + time + "  G1 occ: " + struct1.getCurrent_capacity() + "/" + struct1.getTotal_capacity() + "  G2 occ: " + struct2.getCurrent_capacity() + "/" + struct2.getTotal_capacity() + "  Notification: " + notification);

                } else if (!(garageAvailabilityAlgorithm.garageFull(structArray[secondaryGarage].getTotal_capacity(), structArray[secondaryGarage].getCurrent_capacity()))) { //secondary garage not full

                    //add vehicle to garage
                    structArray[secondaryGarage].setCurrent_capacity(structArray[secondaryGarage].getCurrent_capacity() + 1);

                    int randParkDur = (avgParkTime - 10) + (int)(Math.random() * (((avgParkTime + 10) - (avgParkTime - 10)) + 1)); //from stackoverflow random int in range
                    vehicle newVeh = dataGen.genVehicle("vehicle id", time, randParkDur); //create new vehicle object
                    struct2out.add(newVeh.getparking_out());

                    notification = "Sending to Garage 2";

                    //TEST
                    System.out.println("Time: " + time + "  G1 occ: " + struct1.getCurrent_capacity() + "/" + struct1.getTotal_capacity() + "  G2 occ: " + struct2.getCurrent_capacity() + "/" + struct2.getTotal_capacity() + "  Notification: " + notification);

                } else {
                    notification = "Both garages full!";

                    //TEST
                    System.out.println("Time: " + time + "  G1 occ: " + struct1.getCurrent_capacity() + "/" + struct1.getTotal_capacity() + "  G2 occ: " + struct2.getCurrent_capacity() + "/" + struct2.getTotal_capacity() + "  Notification: " + notification);
                }

            }

            //iterate time
            if (time % 100 == 59) {
                time += 41; //go to next hour
            } else {
                time++;
            }

        }

        //end simulation
        System.out.println("END SIM");



    }
}
