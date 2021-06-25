import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RecetteComponent} from "./recette/recette.component";
import {PlatComponent} from "./plat/plat.component";

const routes: Routes = [
<<<<<<< Updated upstream
=======
  {path:"recette", component: RecetteComponent},
  {path:"plat", component: PlatComponent}
>>>>>>> Stashed changes

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
