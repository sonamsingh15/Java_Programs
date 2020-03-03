package cabtestcases;

import invoiceservices.InvoiceServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.when;

public class InvoiceServiceTest {

    InvoiceServices invoiceServices = null;

    @Before
    public void setUp() {
        invoiceServices = new InvoiceServices(rideRepositoryMock);
    }

    @Mock
    RideRepository rideRepositoryMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceServices.calculateTotalFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare() {

        double distance = 0.4;
        int time = 0;
        double totalFare = invoiceServices.calculateTotalFare(distance, time);
        Assert.assertTrue(5.0 == totalFare);
    }

    @Test
    public void givenMultipleDistanceAndTime_ShouldReturnInvoiceSummary() {

        Ride[] ride1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)};

        InvoiceSummary invoiceSummary = invoiceServices.calculateTotalFare(ride1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30, 15);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {

        String userId = "Ab.com";

        Ride[] ride1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        invoiceServices.addRide(userId, ride1);
        InvoiceSummary invoiceSummary = this.invoiceServices.getInvoiceSummary(userId);
        InvoiceSummary expectecInvoiceSummary = new InvoiceSummary(2, 30, 15);
        Assert.assertEquals(expectecInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummaryUsingMockito() {

        String userId = "Ab.com";

        Ride[] ride1 = {new Ride(2.0, 5),
                new Ride(0.1, 0)
        };

        InvoiceServices invoiceServices = new InvoiceServices(rideRepositoryMock);
        Mockito.doNothing().when(rideRepositoryMock).addRide(userId, ride1);
         InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30, 15);
        when(rideRepositoryMock.getRide(userId)).thenReturn(ride1);

        InvoiceSummary invoiceSummary = invoiceServices.getInvoiceSummary(userId);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRide_ShoudThrowRuntimeExceptionUsingMockito() {
        String userId = "ngnnn";
        try {
            when(rideRepositoryMock.getRide(userId)).thenThrow(new RuntimeException("Invalid input"));
            invoiceServices.getInvoiceSummary(userId);

        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "Invalid input");
            e.printStackTrace();

        }
    }
    @Test
    public void givenUserIdAndRide_ShoudThrowNullPointerExceptionUsingMockito() {
        String userId =null;
        try {
            when(rideRepositoryMock.getRide(userId)).thenThrow(new NullPointerException("Invalid input"));
            invoiceServices.getInvoiceSummary(userId);

        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Invalid input");
            e.printStackTrace();

        }
    }

}
