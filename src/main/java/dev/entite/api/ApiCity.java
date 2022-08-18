package dev.entite.api;

import java.util.ArrayList;

public class ApiCity {

    ArrayList< Object > geo = new ArrayList < Object > ();
    private String name;
    private String url;
    private String location;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getLocation() {
        return location;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
