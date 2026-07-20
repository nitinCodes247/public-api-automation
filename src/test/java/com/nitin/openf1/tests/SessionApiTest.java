package com.nitin.openf1.tests;

import com.nitin.openf1.client.SessionService;
import com.nitin.openf1.constants.ConstantTestData;
import com.nitin.openf1.models.response.SessionResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionApiTest {
    String validCountryName = ConstantTestData.VALID_COUNTRY_NAME;
    String sessionName = ConstantTestData.SESSION_NAME;
    int sessionYear = ConstantTestData.SESSION_YEAR;

    @Test
    public void shouldReturnSessionForValidCountrySessionNameAndYear() {

        Response response = SessionService.getSessions(validCountryName, sessionName, sessionYear);

        Assert.assertEquals(response.statusCode(), 200, "Expected status code 200");
        Assert.assertTrue(response.contentType().contains("application/json"), "Expected JSON response");

        SessionResponse[] sessions = response.as(SessionResponse[].class);

        Assert.assertEquals(sessions.length, 1, "Expected exactly one matching session");

        SessionResponse session = sessions[0];

        Assert.assertEquals(session.getCountryName(), validCountryName);

        Assert.assertEquals(session.getSessionName(), sessionName);

        Assert.assertEquals(session.getYear(), Integer.valueOf(sessionYear));

        Assert.assertNotNull(session.getSessionKey(), "Session key should not be null");
        Assert.assertNotNull(session.getMeetingKey(), "Meeting key should not be null");
        Assert.assertNotNull(session.getDateStart(), "Session start date should not be null");
        Assert.assertNotNull(session.getDateEnd(), "Session end date should not be null");
    }

    @Test
    public void shouldReturnEmptyResponseForInvalidCountry() {

        String invalidCountryName = ConstantTestData.INVALID_COUNTRY_NAME;

        Response response = SessionService.getSessions(invalidCountryName, sessionName, sessionYear);

        Assert.assertEquals(response.statusCode(), 404, "Expected status code 404 for an invalid request with no matching data");

        String errorMessage = response.asString();

        Assert.assertTrue(errorMessage.contains(ConstantTestData.NOT_FOUND_ERROR), "Expected an error message for an invalid country");
    }
}
