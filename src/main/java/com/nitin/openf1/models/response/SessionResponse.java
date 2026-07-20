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
public class SessionResponse {

    @JsonProperty("circuit_key")
    private Integer circuitKey;

    @JsonProperty("circuit_short_name")
    private String circuitShortName;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_key")
    private Integer countryKey;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("date_end")
    private String dateEnd;

    @JsonProperty("date_start")
    private String dateStart;

    @JsonProperty("gmt_offset")
    private String gmtOffset;

    @JsonProperty("is_cancelled")
    private Boolean cancelled;

    private String location;

    @JsonProperty("meeting_key")
    private Integer meetingKey;

    @JsonProperty("session_key")
    private Integer sessionKey;

    @JsonProperty("session_name")
    private String sessionName;

    @JsonProperty("session_type")
    private String sessionType;

    private Integer year;
}