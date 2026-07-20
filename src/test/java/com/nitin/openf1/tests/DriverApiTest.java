package com.nitin.openf1.tests;

import com.nitin.openf1.client.DriverService;
import com.nitin.openf1.client.OpenF1Client;
import com.nitin.openf1.constants.ConstantTestData;
import com.nitin.openf1.constants.Endpoints;
import com.nitin.openf1.models.response.DriverResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class DriverApiTest {
    int driverNumber = ConstantTestData.DRIVER_NUMBER;
    int sessionKey = ConstantTestData.SESSION_KEY;
    @Test
    public void shouldFetchDriverDetails() {
        Response response = DriverService.getDriverDetails(driverNumber,sessionKey);

        Assert.assertEquals(response.statusCode(),200,"Expected status code of 200");

        DriverResponse[] drivers = response.as(DriverResponse[].class);

        Assert.assertEquals(drivers.length,1,"Only one driver details should be returned");

        DriverResponse driverDetails = drivers[0];

        Assert.assertEquals(driverDetails.getDriverNumber(),driverNumber);
        Assert.assertEquals(driverDetails.getSessionKey(),sessionKey);

        Assert.assertNotNull(driverDetails.getFullName(),"Driver Full Name should not be null");
        Assert.assertFalse(driverDetails.getFullName().isBlank(),"Driver Full Name should not be blank");
        Assert.assertNotNull(driverDetails.getTeamName(),"Driver Team Name should not be null");
    }
}
