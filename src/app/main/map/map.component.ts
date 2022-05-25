import { AfterViewInit, Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import * as L from 'leaflet';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const iconUrl = './leaflet/marker-icon.png';
const shadowUrl = './leaflet/marker-shadow.png';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements AfterViewInit {

  formSubmitted: boolean = false
  private map: any;

  icon = {
    icon: L.icon({
      iconSize: [ 25, 41 ],
      iconAnchor: [ 13, 0 ],
      // specify the path here
      iconUrl,
      shadowUrl
    })
};

  stations: any[] = []

  markerMap: any;
  allMarkerMap = L.layerGroup([]);

  formMapSearch = new FormGroup({
    name: new FormControl('',
      [
        Validators.required, 
        Validators.minLength(2)
      ]
    )
  });

  token_api: string = "dbbd6bd16593d05023748919d281d871c3f79a33"
  url_api: string = "https://api.waqi.info/feed/beijing/?token=dbbd6bd16593d05023748919d281d871c3f79a33"

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  /*
  Initialisation de la map Leaflet
  */
  private initMap(): void {
    this.map = L.map('map', {
      center: [47.47621157665071, -1.2676804621092463],
      zoom: 8
    });
    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 7,
    });
    tiles.addTo(this.map);
  }

  constructor(private http: HttpClient) { }
  ngAfterViewInit(): void {
    this.initMap();
    this.showStationsVisible()
    this.showStationsByName()

    this.map.on('moveend', () => {
      this.showStationsVisible()
    })
  }

  onSubmit() {
    this.formSubmitted = true
    if(this.formMapSearch.valid) {
      this.initApi(this.formMapSearch.value.name)
    }
  }

  /*
  Méthode pour effectuer une recherche par ville via Leaflet
  @params : Longitude et latitude
  */
  searchByCity(long: number, lat: number) {
    this.map.panTo(new L.LatLng(long, lat));
    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 7,
    });
    tiles.addTo(this.map);

  }

  /*
  Méthode pour effectuer une recherche par ville à l'API de qualité de l'air
  @params : nom de la ville
  */
  initApi(city: string) {
    return this.http.get(`https://api.waqi.info/feed/${city}/?token=${this.token_api}`)
      .subscribe((data: any) => {
        console.log(data)
        if (data.status === "error") {
          const errMsg: any = document.querySelector('.err')
          errMsg.innerHTML = `Nous n'avons aucune informations sur la ville de ${city}`
        } else {
          const errMsg: any = document.querySelector('.err')
          errMsg.innerHTML = ``
          this.searchByCity(data.data.city.geo[0], data.data.city.geo[1])
          const printData: any = document.querySelector('.printData')
          printData.innerHTML =
            `
          <p>Ville : ${city}</p>
          <li>Moyenne indice qualité de l'air : ${data.data.aqi} AQI</li>
          <li>Température : ${data.data.iaqi.t?.v}°C</li>
          <li>PM 2.5 : ${data.data.iaqi.pm25?.v} AQI</li>
          <li>PM 10 : ${data.data.iaqi.pm10?.v} AQI</li>
          <li>Humidité : ${data.data.iaqi.h?.v}</li>
          <li>Pression : ${data.data.iaqi.p?.v}</li>
          <li>Vent : ${data.data.iaqi.w?.v}</li>
          `
        }
      })
  }


  showAllStations(lat1: number, lng1: number, lat2: number, lng2: number) {
    this.http.get(`https://api.waqi.info/map/bounds?latlng=${lat1},${lng1},${lat2},${lng2}&networks=all&token=${this.token_api}`)
      .subscribe((data: any): any => {
        const allStations = data.data

        // clear les multiples layers dans "allMarkerMap" pour éviter les doublons
        this.allMarkerMap.clearLayers()

        this.stations = [];
        this.stations.push(allStations);
        const arrayStations = this.stations[0]
        // console.log(arrayStations)
        for (let i = 0; i < arrayStations.length; i++) {
          // place le marker dans un layer
          this.markerMap = L.marker([arrayStations[i].lat, arrayStations[i].lon], this.icon).on('click', (event) => this.markerClick(event))
          // place tout les layers dans un groupe de layer
          this.allMarkerMap.addLayer(this.markerMap)
        }
        // applique le groupe de layer à la map
        this.map.addLayer(this.allMarkerMap)
      })
  }

  showStationsByName() {
    this.http.get(`https://api.waqi.info/search/?keyword=paris&token=${this.token_api}`)
      .subscribe((data: any) => {
        // console.log(data);
      })
  }

  showStationsVisible() {
    let mapBounds = this.map.getBounds()
    // console.log(mapBounds)
    this.showAllStations(mapBounds._northEast.lat, mapBounds._northEast.lng, mapBounds._southWest.lat, mapBounds._southWest.lng)
  }

  markerClick(marker: any) {
    // console.log("click ! =>", marker.latlng.lat)
    return this.http.get(`https://api.waqi.info/feed/geo:${marker.latlng.lat};${marker.latlng.lng}/?token=${this.token_api}`)
      .subscribe((data: any) => {
        // console.log(data)

          const errMsg: any = document.querySelector('.err')
          errMsg.innerHTML = ``
          this.searchByCity(data.data.city.geo[0], data.data.city.geo[1])
          const printData: any = document.querySelector('.printData')

          printData.innerHTML =
            `
          <p>Info : ${data.data.city.name}</p>
          <li>Moyenne indice qualité de l'air : ${data.data.aqi} AQI</li>
          <li>Température : ${data.data.iaqi.t?.v}°C</li>
          <li>PM 2.5 : ${data.data.iaqi.pm25?.v} AQI</li>
          <li>PM 10 : ${data.data.iaqi.pm10?.v} AQI</li>
          <li>Humidité : ${data.data.iaqi.h?.v}</li>
          <li>Pression : ${data.data.iaqi.p?.v}</li>
          <li>Vent : ${data.data.iaqi.w?.v}</li>
          `
      })
  }

}
