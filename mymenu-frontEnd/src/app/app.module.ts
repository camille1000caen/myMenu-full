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
<<<<<<< HEAD
<<<<<<< HEAD
=======
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {ListeCoursesComponent} from "./liste-courses/liste-courses.component";
import {AjustementQuantiteComponent} from "./ajustement-quantite/ajustement-quantite.component";
>>>>>>> Camille
=======

>>>>>>> Solenn

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomebodyComponent,
    ObjectifComponent,
    MenuComponent,
    PlanningComponent,
<<<<<<< HEAD
    PlatComponent,
    RecetteComponent,
    IngredientComponent,
    AppComponent,
=======
    AppComponent,
    PlatComponent,
    RecetteComponent,
    IngredientComponent,

>>>>>>> Solenn
    UtilisateurComponent,
    AdresseComponent,
    PreferenceAlimentaireComponent,
    UtilisateurComponent,
    ListeCoursesComponent,
    AjustementQuantiteComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
<<<<<<< HEAD
<<<<<<< HEAD
    HttpClientModule,
    AppRoutingModule,
=======
    HttpClientModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
>>>>>>> Camille
=======
    HttpClientModule,


>>>>>>> Solenn
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
