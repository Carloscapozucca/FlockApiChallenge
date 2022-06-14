package com.challenge.ChallengeAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Provincia {

    private int id;
    private String name;
    private double lat;
    private double lon;

    public Provincia(){
    }

    public Provincia(int id, String name, double lon, double lat) {
        this.id = id;
        this.name = name;
        this.lon = lon;
        this.lat = lat;
    }
}
