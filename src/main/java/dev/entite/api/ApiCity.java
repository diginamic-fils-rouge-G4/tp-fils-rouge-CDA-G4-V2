package dev.entite.api;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Object> getGeo() {
        return geo;
    }

    public void setGeo(ArrayList<Object> geo) {
        this.geo = geo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiCity{");
        sb.append("geo=").append(geo);
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
