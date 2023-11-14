import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { PointComponent } from './point/point.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MaxScroreCDRComponent } from './max-scrore-cdr/max-scrore-cdr.component';
import { ListSubjectsComponent } from './list-subjects/list-subjects.component';
import { AddSubjectComponent } from './add-subject/add-subject.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ShowPointComponent } from './show-point/show-point.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    PointComponent,
    MaxScroreCDRComponent,
    ListSubjectsComponent,
    AddSubjectComponent,
    ShowPointComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
