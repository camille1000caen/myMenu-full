import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AjustementQuantiteComponent} from "./ajustement-quantite/ajustement-quantite.component";
import {ListeCoursesComponent} from "./liste-courses/liste-courses.component";

const routes: Routes = [
  {path: "ajustementQuantite", component: AjustementQuantiteComponent},
  {path: "listeCourse", component: ListeCoursesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
