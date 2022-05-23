import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RubriqueComponent } from 'src/app/admin/dashboard/rubrique/rubrique.component';

const routes: Routes = [
  {
    path: '', component: RubriqueComponent
  },
  {
    path: ':idtopic', loadChildren: () => import('./topic/topic.module')
      .then(m => m.TopicModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RubriqueRoutingModule { }
