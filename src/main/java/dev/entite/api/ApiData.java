package dev.entite.api;

import java.util.ArrayList;

public class ApiData {

    private float aqi;
    private float idx;
    ArrayList< Object > attributions = new ArrayList < Object > ();
    ApiCity City;
    private String dominentpol;
    ApiIaqi Iaqi;
    ApiTime Time;
    ApiForecast Forecast;
    ApiDebug Debug;

    public float getAqi() {
        return aqi;
    }

    public void setAqi(float aqi) {
        this.aqi = aqi;
    }

    public float getIdx() {
        return idx;
    }

    public void setIdx(float idx) {
        this.idx = idx;
    }

    public ArrayList<Object> getAttributions() {
        return attributions;
    }

    public void setAttributions(ArrayList<Object> attributions) {
        this.attributions = attributions;
    }

    public ApiCity getCity() {
        return City;
    }

    public void setCity(ApiCity city) {
        City = city;
    }

    public String getDominentpol() {
        return dominentpol;
    }

    public void setDominentpol(String dominentpol) {
        this.dominentpol = dominentpol;
    }

    public ApiIaqi getIaqi() {
        return Iaqi;
    }

    public void setIaqi(ApiIaqi iaqi) {
        Iaqi = iaqi;
    }

    public ApiTime getTime() {
        return Time;
    }

    public void setTime(ApiTime time) {
        Time = time;
    }

    public ApiForecast getForecast() {
        return Forecast;
    }

    public void setForecast(ApiForecast forecast) {
        Forecast = forecast;
    }

    public ApiDebug getDebug() {
        return Debug;
    }

    public void setDebug(ApiDebug debug) {
        Debug = debug;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiData{");
        sb.append("aqi=").append(aqi);
        sb.append(", idx=").append(idx);
        sb.append(", attributions=").append(attributions);
        sb.append(", City=").append(City);
        sb.append(", dominentpol='").append(dominentpol).append('\'');
        sb.append(", Iaqi=").append(Iaqi);
        sb.append(", Time=").append(Time);
        sb.append(", Forecast=").append(Forecast);
        sb.append(", Debug=").append(Debug);
        sb.append(", city=").append(getCity());
        sb.append(", iaqi=").append(getIaqi());
        sb.append(", time=").append(getTime());
        sb.append(", forecast=").append(getForecast());
        sb.append(", debug=").append(getDebug());
        sb.append('}');
        return sb.toString();
    }
}
