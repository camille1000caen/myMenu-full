import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AdresseComponent} from "./adresse/adresse.component";

const routes: Routes = [

  {path: "adresse", component: AdresseComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
