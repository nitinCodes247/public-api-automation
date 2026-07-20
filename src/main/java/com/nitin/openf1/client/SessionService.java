package com.nitin.openf1.client;

import com.nitin.openf1.constants.Endpoints;
import io.restassured.response.Response;

import java.util.Map;

public final class SessionService {

    private SessionService() {
    }

    public static Response getSessions(String countryName, String sessionName, int year) {
        return OpenF1Client.get(
                Endpoints.SESSIONS,
                Map.of(
                        "country_name", countryName,
                        "session_name", sessionName,
                        "year", year
                )
        );
    }
}