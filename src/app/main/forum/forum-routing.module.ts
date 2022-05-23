import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '', redirectTo: 'rubrique', pathMatch: 'full'
  }, 
  {
    path: 'rubrique', loadChildren: () => import('./rubrique/rubrique.module')
      .then(m => m.RubriqueModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ForumRoutingModule { }
