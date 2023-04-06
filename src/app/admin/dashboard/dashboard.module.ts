import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { RubriqueComponent } from './rubrique/rubrique.component';
import { UserComponent } from './user/user.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    RubriqueComponent,
    UserComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    ReactiveFormsModule
  ]
})
export class DashboardModule { }
