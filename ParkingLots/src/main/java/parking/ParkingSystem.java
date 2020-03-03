package parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSystem {

    private int actualCapacity;
    private List vehicles;
    private ParkingLotObserver parkingLotObserver;

    public ParkingSystem(int capacity) {
        this.vehicles=new ArrayList();
        this.actualCapacity = capacity;

    }

    public void registerOwner(ParkingLotOwner owner) { this.parkingLotObserver = owner; }
    public void setCapacity(int capacity) { this.actualCapacity=capacity; }
    public void registerSecurity(AirportSecurity airportSecurty) { this.parkingLotObserver =airportSecurty;}


    public void park(Object vehicle) throws ParkingLotException {
        if (this.vehicles.size() == this.actualCapacity){
            parkingLotObserver.capacityIsFull();
            throw new ParkingLotException("parkinglot is full");
    }
            if(isVehicalParked(vehicle))
                throw new ParkingLotException("vehicle already parked");
            this.vehicles.add(vehicle);
    }

    public boolean isVehicalParked(Object vehicle) {
        if (this.vehicles.contains(vehicle))
            return true;
        return false;
    }

    public boolean unPark(Object vehicle) {
        if ( vehicle == null)  return false;
            if (this.vehicles.contains(vehicle)) {
                this.vehicles.remove(vehicle);
                return true;
            }
            return false;

    }



}