package dev.entite.api;

public class ApiForecast {

    ApiDaily DailyObject;


    // Getter Methods

    public ApiDaily getDaily() {
        return DailyObject;
    }

    // Setter Methods

    public void setDaily(ApiDaily dailyObject) {
        this.DailyObject = dailyObject;
    }

}
