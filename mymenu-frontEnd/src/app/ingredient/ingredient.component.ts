import { Component, OnInit } from '@angular/core';

import {Ingredient} from "../model/ingredient";
import {IngredientHttpService} from "./ingredient-http.service";

@Component({
  selector: 'app-ingredient',
  templateUrl: './ingredient.component.html',
  styleUrls: ['./ingredient.component.scss']
})
export class IngredientComponent implements OnInit {

  ingredientForm: Ingredient = null;
  ingredients: Array<Ingredient>;

  constructor(private ingredientService: IngredientHttpService) {

  }

  ngOnInit(): void {
  }
  list(): Array<Ingredient> {
    return this.ingredientService.findAll();
  }

  add() {
    this.ingredientForm = new Ingredient();
  }

  moins(id : number){
    this.ingredientService.findById(id).subscribe(resp=> {
       this.ingredientForm=resp;
       this.ingredientForm.quantite-=1;
       this.save();

    }, err => console.log(err));
  }

  plus(id : number){
    this.ingredientService.findById(id).subscribe(resp=> {
      this.ingredientForm=resp;
      this.ingredientForm.quantite+=1;
      this.save();

    }, err => console.log(err));
  }

  edit(id: number) {

    this.ingredientService.findById(id).subscribe(resp=> {
      this.ingredientForm = resp;

    }, err => console.log(err));
  }

  save() {

    if (!this.ingredientForm.id) {
      this.ingredientService.create(this.ingredientForm);
    } else {
      this.ingredientService.modify(this.ingredientForm).subscribe(resp => {
        this.ingredientService.load();
      }, error => console.log(error));
    }
    this.ingredientForm = null;
  }

  cancel() {
    this.ingredientForm = null;
  }

  delete(id: number) {
    this.ingredientService.deleteById(id);
  }

}


