import { Component, OnInit } from '@angular/core';
import {AjustementQuantite} from "../model/ajustementQuantite";
import {AjustementQuantiteHttpService} from "./ajustementQuantite-http.service";
import {Ingredient} from "../model/ingredient";
import {IngredientHttpService} from "../ingredient/ingredient-http.service";

@Component({
  selector: 'app-ajustement-quantite',
  templateUrl: './ajustement-quantite.component.html',
  styleUrls: ['./ajustement-quantite.component.scss']
})
export class AjustementQuantiteComponent implements OnInit {

  ajustementQuantiteForm : AjustementQuantite = null;

  constructor(private ajustementQuantiteService : AjustementQuantiteHttpService, private ingredientService : IngredientHttpService ) { }

  ngOnInit(): void {
  }

  list(): Array<AjustementQuantite> {
    return this.ajustementQuantiteService.findAll();
  }

  // listIngredients() : Array<Ingredient>{
  //   return this.in
  // }

  add() {
    this.ajustementQuantiteForm = new AjustementQuantite();
  }

  edit(id: number) {
    this.ajustementQuantiteService.findById(id).subscribe(resp=> {
      this.ajustementQuantiteForm = resp;
    }, err => console.log(err));


  }

  save() {
    if (!this.ajustementQuantiteForm.id) {
      this.ajustementQuantiteService.create(this.ajustementQuantiteForm);
    } else {
      this.ajustementQuantiteService.modify(this.ajustementQuantiteForm).subscribe(resp => {
        this.ajustementQuantiteService.load();
      }, error => console.log(error));
    }
    this.ajustementQuantiteForm = null;
  }

  cancel() {
    this.ajustementQuantiteForm = null;
  }

  delete(id: number) {
    this.ajustementQuantiteService.deleteById(id);
  }

}
