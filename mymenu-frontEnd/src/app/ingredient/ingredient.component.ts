import { Component, OnInit } from '@angular/core';

import {Ingredient} from "../model/ingredient";
import {IngredientHttpService} from "./ingredient-http.service";

import { jsPDF } from "jspdf";

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

ListByRecette(id: number) {
    return this.ingredientService.findByRecette(id);
}

  pdfDownload() {
    var doc = new jsPDF();
    var interligne = 10;
    doc.setTextColor(255, 182, 18);
    doc.text("Ingrédients : ",10, interligne);
    doc.text("Quantité : ",70, interligne);
    doc.setTextColor(0, 0, 0);

    for (let ingred of this.ingredientService.findAll()){
      interligne=interligne+7;
      doc.text(ingred.nom,10, interligne);
      doc.text(ingred.quantite.toString(), 70, interligne);
  }
    doc.save("Ma liste de course.pdf");
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


