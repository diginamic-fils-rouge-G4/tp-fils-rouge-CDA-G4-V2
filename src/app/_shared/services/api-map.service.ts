import { ElementRef, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as L from 'leaflet';
import {
  Chart,
  ArcElement,
  LineElement,
  BarElement,
  PointElement,
  BarController,
  BubbleController,
  DoughnutController,
  LineController,
  PieController,
  PolarAreaController,
  RadarController,
  ScatterController,
  CategoryScale,
  LinearScale,
  LogarithmicScale,
  RadialLinearScale,
  TimeScale,
  TimeSeriesScale,
  Decimation,
  Filler,
  Legend,
  Title,
  Tooltip,
  SubTitle
} from 'chart.js';

Chart.register(
  ArcElement,
  LineElement,
  BarElement,
  PointElement,
  BarController,
  BubbleController,
  DoughnutController,
  LineController,
  PieController,
  PolarAreaController,
  RadarController,
  ScatterController,
  CategoryScale,
  LinearScale,
  LogarithmicScale,
  RadialLinearScale,
  TimeScale,
  TimeSeriesScale,
  Decimation,
  Filler,
  Legend,
  Title,
  Tooltip,
  SubTitle
);
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
    
    const errMsg: any = document.querySelector('.err')
    errMsg.innerHTML = ``
    this.searchByCity(data.data.city.geo[0], data.data.city.geo[1])
    this.showFavoris = false
    this.currentData=data.data
    console.log(this.currentData);
    this.graphics(this.currentData.forecast.daily)
    
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
    console.log(stations)
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

  graphics(polluant: any) {
    const arro3 = []
    const arrPM25 = []
    const arrPM10 = []
    const arrUv = []
    arro3.push(polluant.o3)
    arrPM25.push(polluant.pm25)
    arrPM10.push(polluant.pm10)
    arrUv.push(polluant.uvi)
    const avgO3 = []
    const avgPM25 = []
    const avgPM10 = []
    const arrDate = []
    const avgUIV = []
    const minO3 = []
    const maxO3 = []
    const minUV = []
    const maxUV = []
    const minPM25 = []
    const maxPM25 = []
    const minPM10 = []
    const maxPM10 = []
    console.log(arrUv[0])
    for (let i = 0; i < arrUv[0].length; i++) {
      arrDate.push(arrUv[0][i].day);
      avgUIV.push(arrUv[0][i].avg)
      minUV.push(arrUv[0][i].min) 
      maxUV.push(arrUv[0][i].max)
    }
    for (let i = 0; i < arro3[0].length; i++) {
      avgO3.push(arro3[0][i].avg) 
      minO3.push(arro3[0][i].min) 
      maxO3.push(arro3[0][i].max)
    }
    for (let i = 0; i < arrPM25[0].length; i++) {
      avgPM25.push(arrPM25[0][i].avg)  
      minPM25.push(arrPM25[0][i].min) 
      maxPM25.push(arrPM25[0][i].max) 
    }
    for (let i = 0; i < arrPM10[0].length; i++) {
      avgPM10.push(arrPM10[0][i].avg)   
      minPM10.push(arrPM10[0][i].min) 
      maxPM10.push(arrPM10[0][i].max) 
    }
    
    const dataAvg = {
      labels: arrDate,
      datasets: [{
        label: 'O3 moyenne journalière (prévision)',
        data: avgO3,
        fill: false,
        borderColor: 'rgb(75, 192, 192)'
      }, {
        label: 'PM25 moyenne journalière (prévision)',
        data: avgPM25,
        fill: false,
        borderColor: 'rgb(224, 75, 75)'
      }, {
        label: 'PM10 moyenne journalière (prévision)',
        data: avgPM10,
        fill: false,
        borderColor: 'rgb(112, 219, 79)'
      }, {
        label: 'UIV moyenne journalière (prévision)',
        data: avgUIV,
        fill: false,
        borderColor: 'rgb(172, 41, 224)'
      }]
    }
    const dataMinMax = {
      labels: arrDate,
      datasets: [{
        label: 'O3 minimum journalier (prévision)',
        data: minO3,
        fill: false,
        backgroundColor: 'rgb(75, 192, 192)'
      }, {
        label: 'O3 maximum journalier (prévision)',
        data: maxO3,
        fill: false,
        backgroundColor: 'rgb(75, 192, 192)'
      }, {
        label: 'UV minimum journalier (prévision)',
        data: minUV,
        fill: false,
        backgroundColor: 'rgb(172, 41, 224)'
      }, {
        label: 'UV maximum journalier (prévision)',
        data: maxUV,
        fill: false,
        backgroundColor: 'rgb(172, 41, 224)'
      }, {
        label: 'PM25 minimum journalier (prévision)',
        data: minPM25,
        fill: false,
        backgroundColor: 'rgb(224, 75, 75)'
      }, {
        label: 'PM25 maximum journalier (prévision)',
        data: maxPM25,
        fill: false,
        backgroundColor: 'rgb(224, 75, 75)'
      },  {
        label: 'PM10 minimum journalier (prévision)',
        data: minPM10,
        fill: false,
        backgroundColor: 'rgb(112, 219, 79)'
      }, {
        label: 'PM10 maximum journalier (prévision)',
        data: maxPM10,
        fill: false,
        backgroundColor: 'rgb(112, 219, 79)'
      }]
    }
    const line:any = document.querySelector('#o3Average')
    let chartLineStatus = Chart.getChart('o3Average')
    if(chartLineStatus != undefined) {
      chartLineStatus.destroy()
    }
    new Chart(line, {
      type: 'line',
      data: dataAvg,
      options: {
        responsive: true,
        scales: {
          y: {
            min: 0,
            max: 50,
            ticks: {
              // forces step size to be 50 units
              stepSize: 5
            }
          }
        }
      
      }
    })
    const bar: any = document.querySelector('#o3MinMax')
    let chartBarStatus = Chart.getChart('o3MinMax')
    if(chartBarStatus != undefined) {
      chartBarStatus.destroy()
    }
    new Chart(bar, {
      type: 'bar',
      data: dataMinMax,
      options: {
        responsive: true,
        scales: {
          y: {
            beginAtZero: true,
            min: 0,
            max: 50,
            ticks: {
              // forces step size to be 50 units
              stepSize: 5
            }
          }
        }
      
      }
    })
  }
}
