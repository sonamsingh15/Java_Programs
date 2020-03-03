package parking;

public class ParkingLotOwner implements ParkingLotObserver {
    private boolean isFullcapacity;

    public void capacityIsFull() {
        isFullcapacity=true;
    }

    public boolean isCapacityFull() {
        return this.isFullcapacity;
    }


}
