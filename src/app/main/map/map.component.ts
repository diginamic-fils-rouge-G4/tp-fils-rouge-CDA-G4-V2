import { AfterViewInit, Component, ElementRef } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import { ApiMapService } from 'src/app/_shared/services/api-map.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements AfterViewInit {
  currentData:any
  constructor(public api_map: ApiMapService) {}

  favoritData :any =[
    {name:"Nantes",stations:[{name:"Bouteillerie",status:true},{name:"Bouteillerie",status:false}]},
  ]
  testCurentData:any

  formSubmitted: boolean = false
  ngOnInit():void{
    

  }

  formMapSearch = new FormGroup({
    name: new FormControl('',
      [
        Validators.required, 
        Validators.minLength(2)
      ]
    )
  });

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  ngAfterViewInit(): void {
    
    this.api_map.initMap();
    this.api_map.showStationsVisible()
    this.api_map.mapMoveEnd()
  }

  onSubmit() {
    this.api_map.onSubmit(this.formMapSearch)
  }
}
