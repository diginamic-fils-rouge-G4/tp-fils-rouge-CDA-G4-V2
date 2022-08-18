package dev.entite.api;

public class ApiForecast {

    ApiDaily Daily;


    // Getter Methods

    public ApiDaily getDaily() {
        return Daily;
    }

    // Setter Methods

    public void setDaily(ApiDaily dailyObject) {
        this.Daily = dailyObject;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiForecast{");
        sb.append("Daily=").append(Daily);
        sb.append(", daily=").append(getDaily());
        sb.append('}');
        return sb.toString();
    }
}
