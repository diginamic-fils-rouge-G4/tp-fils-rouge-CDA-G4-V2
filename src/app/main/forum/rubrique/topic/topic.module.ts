import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TopicRoutingModule } from './topic-routing.module';
import { TopicIndexComponent } from './topic-index/topic-index.component';


@NgModule({
  declarations: [
    TopicIndexComponent
  ],
  imports: [
    CommonModule,
    TopicRoutingModule
  ]
})
export class TopicModule { }
