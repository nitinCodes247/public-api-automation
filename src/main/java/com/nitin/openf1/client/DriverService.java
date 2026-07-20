package com.nitin.openf1.client;

import com.nitin.openf1.constants.Endpoints;
import io.restassured.response.Response;

import java.util.Map;

public final class DriverService {

    private DriverService() {
    }

    public static Response getDriverDetails(int driverNumber, int sessionKey) {
        return OpenF1Client.get(
                Endpoints.DRIVERS,
                Map.of(
                        "driver_number", driverNumber,
                        "session_key", sessionKey
                )
        );
    }

}