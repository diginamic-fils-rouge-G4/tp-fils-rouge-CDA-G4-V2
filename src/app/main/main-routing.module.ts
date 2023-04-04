import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { MapComponent } from './map/map.component';
import {AdminGuard} from "../_guard/admin.guard";
import {UserGuard} from "../_guard/user.guard";
import {LoggedGuard} from "../_guard/logged.guard";

const routes: Routes = [
  {
    path: '', component: MainLayoutComponent, children: [
      {
        path: '', redirectTo: 'auth', pathMatch: 'full'
      },
      {
        path: 'auth', loadChildren: () => import('./auth/auth.module')
          .then(m => m.AuthModule)
      },
      {
        path: 'map', component: MapComponent, canActivate: [LoggedGuard]
      },
      {
        path: 'forum', loadChildren: () => import('./forum/forum.module')
          .then(m => m.ForumModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
