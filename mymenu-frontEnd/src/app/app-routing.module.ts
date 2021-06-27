import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {UtilisateurComponent} from "./utilisateur/utilisateur.component";
import {IngredientComponent} from "./ingredient/ingredient.component";
import {AdresseComponent} from "./adresse/adresse.component";
import {AjustementQuantiteComponent} from "./ajustement-quantite/ajustement-quantite.component";
import {ListeCoursesComponent} from "./liste-courses/liste-courses.component";
import {RecetteComponent} from "./recette/recette.component";
import {PlatComponent} from "./plat/plat.component";


const routes: Routes = [
  {path: "adresse", component: AdresseComponent},
  {path: "ajustementQuantite", component: AjustementQuantiteComponent},
  {path: "listeCourse", component: ListeCoursesComponent},
  {path: "utilisateur", component: UtilisateurComponent},
  {path: "ingredient", component: IngredientComponent},
  {path:"recette", component: RecetteComponent},
  {path:"plat", component: PlatComponent},
  {path:"ingredient", component: IngredientComponent},
  {path: "", component: HomeComponent},
  {path: "profil", component: UtilisateurComponent},

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
