import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AjustementQuantiteComponent} from "./ajustement-quantite/ajustement-quantite.component";

const routes: Routes = [
  {path: "ajustementQuantite", component: AjustementQuantiteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
