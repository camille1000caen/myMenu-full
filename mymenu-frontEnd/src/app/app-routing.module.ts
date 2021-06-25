import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RecetteComponent} from "./recette/recette.component";
import {PlatComponent} from "./plat/plat.component";
import {IngredientComponent} from "./ingredient/ingredient.component";

const routes: Routes = [

  {path:"recette", component: RecetteComponent},
  {path:"plat", component: PlatComponent},
  {path:"ingredient", component: IngredientComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
