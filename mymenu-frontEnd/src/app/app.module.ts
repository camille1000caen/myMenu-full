import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomebodyComponent } from './homebody/homebody.component';
import { ObjectifComponent } from './objectif/objectif.component';
import { MenuComponent } from './menu/menu.component';
import { PlanningComponent } from './planning/planning.component';
import { PlatComponent } from './plat/plat.component';
import { RecetteComponent } from './recette/recette.component';
import { IngredientComponent } from './ingredient/ingredient.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { AdresseComponent } from './adresse/adresse.component';
import { PreferenceAlimentaireComponent } from './preference-alimentaire/preference-alimentaire.component';
import { RepasComponent } from './repas/repas.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { MenuCardComponent } from './menu-card/menu-card.component';
import { HomeComponent } from './home/home.component';
import {ListeCoursesComponent} from "./liste-courses/liste-courses.component";
import {AjustementQuantiteComponent} from "./ajustement-quantite/ajustement-quantite.component";




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomebodyComponent,
    ObjectifComponent,
    MenuComponent,
    PlanningComponent,
    AppComponent,
    PlatComponent,
    RecetteComponent,
    IngredientComponent,
    UtilisateurComponent,
    AdresseComponent,
    PreferenceAlimentaireComponent,
    RepasComponent,
    MenuCardComponent,
    HomeComponent,
    ListeCoursesComponent,
    AjustementQuantiteComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
