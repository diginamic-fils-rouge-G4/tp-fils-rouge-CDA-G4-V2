import { ElementRef, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as L from 'leaflet';
const iconUrl = './leaflet/marker-icon.png';
const shadowUrl = './leaflet/marker-shadow.png';
@Injectable({
  providedIn: 'root'
})
export class ApiMapService {
  showFavoris:boolean = true
  currentData:any
  map: any;
  stations: any[] = []
  markerMap: any;
  allMarkerMap = L.layerGroup([]);
  favoritData :any =[
    {name:"Nantes",stations:[{name:"Bouteillerie",status:true},{name:"Bouteillerie",status:false}]},
  ]
  icon = {
    icon: L.icon({
      iconSize: [ 25, 41 ],
      iconAnchor: [ 13, 0 ],
      // specify the path here
      iconUrl,
      shadowUrl
    })
  };

  token_api: string = "dbbd6bd16593d05023748919d281d871c3f79a33"
  url_api: string = "https://api.waqi.info/feed/beijing/?token=dbbd6bd16593d05023748919d281d871c3f79a33"

  constructor(private http: HttpClient) { }

  initMap(): void {
    this.map = L.map('map', {
      center: [47.47621157665071, -1.2676804621092463],
      zoom: 8
    });
    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 7,
    });
    tiles.addTo(this.map)
    
  }

  initApi(city: string) {
    return this.http.get(`https://api.waqi.info/feed/${city}/?token=${this.token_api}`)
      .subscribe((data: any) => {
        if (data.status === "error") {
          const errMsg: any = document.querySelector('.err')
          errMsg.innerHTML = `Nous n'avons aucune informations sur la ville de ${city}`
        } else {
          this.afficheDonneVille(data)
        }
      })
  }
  /**
     * affiche les données de la ville
     * @param data retour de l'api
  */
  afficheDonneVille(data:any){
    console.log(data);
    
    const errMsg: any = document.querySelector('.err')
    errMsg.innerHTML = ``
    this.searchByCity(data.data.city.geo[0], data.data.city.geo[1])
    this.showFavoris = false
    this.currentData=data.data
    
  }

  searchByCity(long: number, lat: number) {
    this.map.panTo(new L.LatLng(long, lat));
    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 7,
    });
    tiles.addTo(this.map);
  }

  showStationsVisible() {
    let mapBounds = this.map.getBounds()
    // console.log(mapBounds)
    this.showAllStations(mapBounds._northEast.lat, mapBounds._northEast.lng, mapBounds._southWest.lat, mapBounds._southWest.lng)
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
          this.markerMap = L.marker([arrayStations[i].lat, arrayStations[i].lon], this.icon)
          this.markerMap.on('click', (event: any) => this.markerClick(event))
          // place tout les layers dans un groupe de layer
          this.allMarkerMap.addLayer(this.markerMap)
        }
        // applique le groupe de layer à la map
        this.map.addLayer(this.allMarkerMap)
      })
  }

  markerClick(marker: any) {    
    return this.http.get(`https://api.waqi.info/feed/geo:${marker.latlng.lat};${marker.latlng.lng}/?token=${this.token_api}`)
      .subscribe((data: any) => {
        this.afficheDonneVille(data)         
      })
  }

  mapMoveEnd() {
    this.map.on('moveend', () => {
      this.showStationsVisible()
    })
  }

  /**
   * 
   * @param nomVille string 
   * @param target string
   * @returns toute les station dans la ville
   */
   showStationsByName(nom:string){
    let nomVille = nom.split(',')[1]
    this.http.get(`https://api.waqi.info/search/?keyword=${nomVille}&token=${this.token_api}`)
    .subscribe((data:any)=>{
      console.log(data.data);
      
      let cityStations:any=[]
      data.data.forEach((infostation:any) => {
        console.log(infostation.station.name.split(',')[0]);
        const city = {
          name: infostation.station.name.split(',')[0],
          status: true
        }
        cityStations.push(city)
      });
      let obj={
        name:nomVille,
        stations:cityStations
      }
      console.log(obj);
      
      this.favoritData.push(obj)
      console.log(this.favoritData)
      
    })
    //A enlever quand on va faire le back
    const test:any = document.querySelector('.fa-heart')
    test.style.color = 'red'
    //
  }
  showStationsFavoris( stations:string) {
    
    this.http.get(`https://api.waqi.info/search/?keyword=${stations}&token=${this.token_api}`)
      .subscribe((data: any) => {
        console.log(data)
        let obj = {
          latlng:{
            lat:data.data[0].station.geo[0],
            lng:data.data[0].station.geo[1]
          }
        }
        this.markerClick(obj)
      })
  }

  onSubmit(form: any) {
    if(form.value.name === ""){

      this.showFavoris = true      
    }
    else{
      this.initApi(form.value.name)
    }
  }

  showFavori(form:any) {
    this.showFavoris = true
    form.reset()
  }
}
