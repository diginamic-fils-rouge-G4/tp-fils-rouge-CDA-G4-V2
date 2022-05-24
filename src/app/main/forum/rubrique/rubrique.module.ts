import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RubriqueRoutingModule } from './rubrique-routing.module';
import { RubriqueComponent } from './rubrique.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    RubriqueComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RubriqueRoutingModule,
    FormsModule
  ]
})
export class RubriqueModule { }
