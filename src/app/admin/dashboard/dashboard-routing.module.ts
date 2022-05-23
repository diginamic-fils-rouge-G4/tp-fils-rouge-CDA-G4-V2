import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RubriqueComponent } from './rubrique/rubrique.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'rubrique', pathMatch: 'full'
  },
  {
    path: 'rubrique', component: RubriqueComponent
  },
  {
    path: 'user', component: UserComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
