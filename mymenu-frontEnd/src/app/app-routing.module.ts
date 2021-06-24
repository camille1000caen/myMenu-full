import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListeCoursesComponent} from "./liste-courses/liste-courses.component";
import {AjustementQuantiteComponent} from "./ajustement-quantite/ajustement-quantite.component";
import {UtilisateurComponent} from "./utilisateur/utilisateur.component";

const routes: Routes = [
  {path: "ajustementQuantite", component: AjustementQuantiteComponent},
  {path: "listeCourse", component: ListeCoursesComponent},
  {path: "utilisateur", component: UtilisateurComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
