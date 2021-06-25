import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
<<<<<<< HEAD
<<<<<<< HEAD
import {AdresseComponent} from "./adresse/adresse.component";

const routes: Routes = [

  {path: "adresse", component: AdresseComponent},

=======
import {ListeCoursesComponent} from "./liste-courses/liste-courses.component";
import {AjustementQuantiteComponent} from "./ajustement-quantite/ajustement-quantite.component";
import {UtilisateurComponent} from "./utilisateur/utilisateur.component";
import {IngredientComponent} from "./ingredient/ingredient.component";

const routes: Routes = [
  {path: "ajustementQuantite", component: AjustementQuantiteComponent},
  {path: "listeCourse", component: ListeCoursesComponent},
  {path: "utilisateur", component: UtilisateurComponent},
  {path: "ingredient", component: IngredientComponent},
>>>>>>> Camille
=======
import {RecetteComponent} from "./recette/recette.component";
import {PlatComponent} from "./plat/plat.component";
import {IngredientComponent} from "./ingredient/ingredient.component";

const routes: Routes = [

  {path:"recette", component: RecetteComponent},
  {path:"plat", component: PlatComponent},
  {path:"ingredient", component: IngredientComponent}


>>>>>>> Solenn
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
