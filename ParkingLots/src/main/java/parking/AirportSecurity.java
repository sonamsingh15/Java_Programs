package parking;

public  class AirportSecurity implements ParkingLotObserver {
    private boolean isFullcapacity;

    public void capacityIsFull() {
        isFullcapacity=true;
    }


    public boolean isCapacityFull() {
        return this.isFullcapacity;
    }

}
