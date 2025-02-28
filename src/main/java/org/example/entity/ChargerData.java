package org.example.entity;

public class ChargerData {
    private String stationId;
    private String time;

    public String getStationId() {
        return stationId;
    }
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public ChargerData(String stationId){
        this.stationId = stationId;
    }
}


