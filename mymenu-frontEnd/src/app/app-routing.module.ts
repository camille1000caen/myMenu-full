import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {UtilisateurComponent} from "./utilisateur/utilisateur.component";
import {IngredientComponent} from "./ingredient/ingredient.component";
import {AdresseComponent} from "./adresse/adresse.component";
import {ListeCoursesComponent} from "./liste-courses/liste-courses.component";
import {AjustementQuantiteComponent} from "./ajustement-quantite/ajustement-quantite.component";
import {RecetteComponent} from "./recette/recette.component";
import {PlatComponent} from "./plat/plat.component";
import { SelectionMenuComponent } from './selection-menu/selection-menu.component';


const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "adresse", component: AdresseComponent},
  {path: "ajustementQuantite", component: AjustementQuantiteComponent},
  {path: "listeCourse", component: ListeCoursesComponent},
  {path: "utilisateur", component: UtilisateurComponent},
  {path: "ingredient", component: IngredientComponent},
  {path: "recette", component: RecetteComponent},
  {path: "plat", component: PlatComponent},
  {path: "profil", component: UtilisateurComponent},
  {path: "selectionMenu", component: SelectionMenuComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
