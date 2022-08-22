package dev.controller.dto.ville;

import dev.controller.dto.station.StationDTO;

import java.util.List;

public class VilleDTO {
    private String name;
    private List<StationDTO> stations;
    public VilleDTO() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VilleDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", stations=").append(stations);
        sb.append('}');
        return sb.toString();
    }
}
