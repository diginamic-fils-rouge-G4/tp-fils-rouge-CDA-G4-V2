import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RubriqueRoutingModule } from './rubrique-routing.module';
import { RubriqueComponent } from './rubrique.component';


@NgModule({
  declarations: [
    RubriqueComponent
  ],
  imports: [
    CommonModule,
    RubriqueRoutingModule
  ]
})
export class RubriqueModule { }
