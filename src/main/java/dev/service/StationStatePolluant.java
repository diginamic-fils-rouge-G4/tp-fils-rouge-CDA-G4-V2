package dev.service;

import dev.entite.lieu.Station;
import dev.repository.StationRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
public class StationStatePolluant {

    private StationRepository stationRepository;

    private StationService stationService;


    public StationStatePolluant(StationRepository stationRepository, StationService stationService) {
        this.stationRepository = stationRepository;
        this.stationService = stationService;
    }

    public List<Station> getAllStation(String id){
        return stationRepository.findAll();
    }

/*
@Scheduled(fixedDelay = 5000) //Per 5 second

*/
    @Scheduled(fixedDelay = 86400000) //Par Jour
    public void getActiveStation(){
        List<Station> activeStationList = stationRepository.FindActiveStation();
        for (Station station : activeStationList) {
            stationService.GetStationStats(station.getIdx());
        }
    }
}
