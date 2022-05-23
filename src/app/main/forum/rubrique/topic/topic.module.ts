import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TopicRoutingModule } from './topic-routing.module';
import { TopicComponent } from './topic.component';


@NgModule({
  declarations: [
    TopicComponent
  ],
  imports: [
    CommonModule,
    TopicRoutingModule
  ]
})
export class TopicModule { }
