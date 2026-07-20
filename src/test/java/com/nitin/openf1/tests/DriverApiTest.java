package com.nitin.openf1.tests;

import com.nitin.openf1.client.DriverService;
import com.nitin.openf1.constants.ConstantTestData;
import com.nitin.openf1.models.response.DriverResponse;
import com.nitin.openf1.testdata.DriverTestData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverApiTest {
    @Test(dataProvider = "valid-driver-test", dataProviderClass = DriverTestData.class)
    public void shouldReturnDriverForValidDriverNumberAndSessionKey(int driverNumber, int sessionKey) {
        Response response = DriverService.getDriverDetails(driverNumber,sessionKey);

        Assert.assertEquals(response.statusCode(),200,"Expected status code of 200");

        DriverResponse[] drivers = response.as(DriverResponse[].class);

        Assert.assertEquals(drivers.length,1,"Only one driver details should be returned");

        DriverResponse driverDetails = drivers[0];

        Assert.assertEquals(driverDetails.getDriverNumber(),driverNumber);
        Assert.assertEquals(driverDetails.getSessionKey(),sessionKey);

        Assert.assertNotNull(driverDetails.getFullName(),"Driver Full Name should not be null");
        Assert.assertFalse(driverDetails.getFullName().isBlank(),"Driver Full Name should not be blank");
    }

    @Test
    public void shouldReturnEmptyResponseForInvalidDriverNumber(){
        int invalidDriverNumber = ConstantTestData.INVALID_DRIVER_NUMBER;

        Response response = DriverService.getDriverDetails(invalidDriverNumber, ConstantTestData.SESSION_KEY);

        Assert.assertEquals(response.statusCode(), 404, "Expected status code 404 for a valid request with no matching data");

        String errorMessage = response.asString();

        Assert.assertTrue(errorMessage.contains(ConstantTestData.NOT_FOUND_ERROR), "Expected no results message");
    }
}
