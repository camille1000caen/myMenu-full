import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AjustementQuantiteComponent } from './ajustement-quantite/ajustement-quantite.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ListeCoursesComponent } from './liste-courses/liste-courses.component';

@NgModule({
  declarations: [
    AppComponent,
    AjustementQuantiteComponent,
    ListeCoursesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
