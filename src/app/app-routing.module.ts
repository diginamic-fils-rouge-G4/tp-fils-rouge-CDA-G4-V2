import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './main/accueil/accueil.component';

const routes: Routes = [
  {
    path: '', component: AccueilComponent
  },
  {
    path: 'auth', loadChildren: () => import('./main/auth/auth.module')
      .then(m => m.AuthModule)
  },
  {
    path: 'home', loadChildren: () => import('./main/main.module')
      .then(m => m.MainModule)
  },
  {
    path: 'admin', loadChildren: () => import('./admin/admin.module')
      .then(m => m.AdminModule)
  },
  {
    path: '**', redirectTo: ''
  },
  {
    path: 'home/**', redirectTo: 'home'
  },
  {
    path: 'admin/**', redirectTo: 'admin'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
