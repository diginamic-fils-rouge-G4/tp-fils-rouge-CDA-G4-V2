import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RubriqueComponent } from './rubrique.component';

const routes: Routes = [
  {
    path: '', component: RubriqueComponent
  },
  {
    path: ':id', loadChildren: () => import('./topic/topic.module')
      .then(m => m.TopicModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RubriqueRoutingModule { }
