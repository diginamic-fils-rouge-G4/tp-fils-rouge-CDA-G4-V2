import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { MapComponent } from './map/map.component';
import { AccueilComponent } from './accueil/accueil.component';


@NgModule({
  declarations: [
    MainLayoutComponent,
    MapComponent,
    AccueilComponent
  ],
  imports: [
    CommonModule,
    MainRoutingModule
  ]
})
export class MainModule { }
