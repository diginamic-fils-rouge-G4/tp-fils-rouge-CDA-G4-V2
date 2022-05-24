import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TopicRoutingModule } from './topic-routing.module';
import { TopicComponent } from './topic.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    TopicComponent
  ],
  imports: [
    CommonModule,
    TopicRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class TopicModule { }
