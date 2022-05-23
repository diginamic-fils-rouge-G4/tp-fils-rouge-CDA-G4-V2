import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RubriqueRoutingModule } from './rubrique-routing.module';
import { RubriqueIndexComponent } from './rubrique-index/rubrique-index.component';


@NgModule({
  declarations: [
    RubriqueIndexComponent
  ],
  imports: [
    CommonModule,
    RubriqueRoutingModule
  ]
})
export class RubriqueModule { }
