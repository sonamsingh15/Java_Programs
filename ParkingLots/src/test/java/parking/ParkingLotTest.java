package parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingSystem parkingSystem = null;
    Object vehicle = null;

    @Before
    public void setUp() throws Exception {
        vehicle = new Object();
        parkingSystem = new ParkingSystem(2);
    }

    @Test
    public void givenVehical_WhenParked_ShouldReturnTrue() throws ParkingLotException {
        parkingSystem.park(vehicle);
        boolean Isparked = parkingSystem.isVehicalParked(vehicle);
        Assert.assertTrue(Isparked);
    }

    @Test
    public void givenVechical_WhenAlReadyParked_ShouldReturnFalse() {
        try {
            parkingSystem.park(vehicle);
            parkingSystem.park(new Object());
        } catch (ParkingLotException e) {
            Assert.assertEquals("parkinglot is full", e.getMessage());
        }
    }

    @Test
    public void givenVehicle_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        parkingSystem.park(vehicle);
        boolean isUnparked = parkingSystem.unPark(vehicle);
        Assert.assertTrue(isUnparked);
    }

    @Test
    public void givenWhenParkingLotIsFull_ShoulInformTheOwner() {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingSystem.registerOwner(owner);
        try {
            parkingSystem.park(vehicle);
            parkingSystem.park(new Object());
        } catch (ParkingLotException e) {
            boolean capacityFull = owner.isCapacityFull();
            Assert.assertTrue(capacityFull);
        }
    }

    @Test
    public void givenCapacityIs2_ShouldAbleToPark2Vechile() throws ParkingLotException {
        Object vehical2 = new Object();
        parkingSystem.setCapacity(2);
        parkingSystem.park(vehicle);
        parkingSystem.park(vehical2);
        boolean isParked1 = parkingSystem.isVehicalParked(vehicle);
        boolean isParked2 = parkingSystem.isVehicalParked(vehical2);
        Assert.assertTrue(isParked1 && isParked2);

    }

    @Test
    public void givenWhenLotIsFull_ShouldInformTheSecurity() {
        AirportSecurity airportSecurity = new AirportSecurity();
        parkingSystem.registerSecurity(airportSecurity);
        try {
            parkingSystem.park(vehicle);
            parkingSystem.park(new Object());
        } catch (ParkingLotException e) {
            boolean capacityFull = airportSecurity.isCapacityFull();
            Assert.assertTrue(capacityFull);
        }
    }

    @Test
    public void givenWhenLotSpaceAgain_ShouldInformTheOwner() {
        ParkingLotOwner owner = new ParkingLotOwner();
        try {
            parkingSystem.park(vehicle);
            parkingSystem.park(new Object());
        } catch (ParkingLotException e) {
            boolean capacityFull = owner.isCapacityFull();
            Assert.assertTrue(capacityFull);
        }
    }


}
