import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { MapComponent } from './map/map.component';
import { AccueilComponent } from './accueil/accueil.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';


@NgModule({
  declarations: [
    MainLayoutComponent,
    MapComponent,
    AccueilComponent
  ],
  imports: [
    CommonModule,
    MainRoutingModule, 
    ReactiveFormsModule,
    FormsModule,
    LeafletModule,
    HttpClientModule
  ]
})
export class MainModule { }
