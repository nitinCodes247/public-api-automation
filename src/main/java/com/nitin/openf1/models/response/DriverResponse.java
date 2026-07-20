package com.nitin.openf1.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverResponse {

    @JsonProperty("broadcast_name")
    private String broadcastName;

    @JsonProperty("driver_number")
    private Integer driverNumber;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("headshot_url")
    private String headshotUrl;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("meeting_key")
    private Integer meetingKey;

    @JsonProperty("name_acronym")
    private String nameAcronym;

    @JsonProperty("session_key")
    private Integer sessionKey;

    @JsonProperty("team_colour")
    private String teamColour;

    @JsonProperty("team_name")
    private String teamName;
}