package dev.entite.donneeApiQualiteAir;

import java.util.ArrayList;

public class ApiDaily {

    ArrayList< Object > o3 = new ArrayList < Object > ();
    ArrayList < Object > pm10 = new ArrayList < Object > ();
    ArrayList < Object > pm25 = new ArrayList < Object > ();
    ArrayList < Object > uvi = new ArrayList < Object > ();

    public ArrayList<Object> getO3() {
        return o3;
    }

    public void setO3(ArrayList<Object> o3) {
        this.o3 = o3;
    }

    public ArrayList<Object> getPm10() {
        return pm10;
    }

    public void setPm10(ArrayList<Object> pm10) {
        this.pm10 = pm10;
    }

    public ArrayList<Object> getPm25() {
        return pm25;
    }

    public void setPm25(ArrayList<Object> pm25) {
        this.pm25 = pm25;
    }

    public ArrayList<Object> getUvi() {
        return uvi;
    }

    public void setUvi(ArrayList<Object> uvi) {
        this.uvi = uvi;
    }


    // Getter Methods



    // Setter Methods


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiDaily{");
        sb.append("o3=").append(o3);
        sb.append(", pm10=").append(pm10);
        sb.append(", pm25=").append(pm25);
        sb.append(", uvi=").append(uvi);
        sb.append('}');
        return sb.toString();
    }
}
