import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SidebarComponent } from './sidebar/sidebar.component';
import { PointComponent } from './point/point.component';
import { MaxScroreCDRComponent } from './max-scrore-cdr/max-scrore-cdr.component';
import { ListSubjectsComponent } from './list-subjects/list-subjects.component';
import { AddSubjectComponent } from './add-subject/add-subject.component';
import { ShowPointComponent } from './show-point/show-point.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'subject',
    pathMatch: 'full'
  },
  {
    path: 'point',
    component: PointComponent
  },
  {
    path: 'showPoint',
    component: ShowPointComponent
  },
  {
    path: 'maxCDR',
    component: MaxScroreCDRComponent
  },
  {
    path: 'subject',
    component: ListSubjectsComponent
  },
  {
    path: 'addSubject',
    component: AddSubjectComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
