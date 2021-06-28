import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';

import {Ingredient} from "../model/ingredient";
import {IngredientHttpService} from "./ingredient-http.service";
import {newArray} from "@angular/compiler/src/util";
import {RecetteHttpService} from "../recette/recette-http.service";
import {Recette} from "../model/recette";

import { jsPDF } from "jspdf";
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-ingredient',
  templateUrl: './ingredient.component.html',
  styleUrls: ['./ingredient.component.scss'],
  // template: `<canvas #myCanvas></canvas>`
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

//  listByRecette(id: number) {
//     return this.ingredientService.findByRecette(id);
// }


  //  canvas = document.querySelector('canvas');
  //  getCursorPosition(canvas, event: { clientX: number; clientY: number; }) {
  //
  //   const rect = canvas.getBoundingClientRect()
  //   const x = event.clientX - rect.left
  //   const y = event.clientY - rect.top
  //   console.log("x: " + x + " y: " + y)
  // }

  // @ViewChild('myCanvas')
  // myCanvas: ElementRef<HTMLCanvasElement>;

  // public context: CanvasRenderingContext2D;

  // ngAfterViewInit(): void {
  //   this.context = this.myCanvas.nativeElement.getContext('2d');
  //   console.log(this.context);
  // }

  // canvas.addEventListener('mousedown', function(e) {
  //   getCursorPosition(canvas, e)
  // })

  pdfDownload() {
    var doc = new jsPDF();
    var interligne = 40;
    var indentation=15;
    var nbLignes=0;
    var nbIngredient=0;
    var nbPage=1;
    var dateDuJour=new Date();
    var mois=dateDuJour.getUTCMonth()+1;//décompte des mois de 0 à 11

    doc.setDrawColor(23,162,184);
    doc.setTextColor(23,162,184);
    doc.text("Ma liste de courses du : "+dateDuJour.getUTCDate()+'/'+mois+'/'+dateDuJour.getUTCFullYear(),70, interligne-25);
    doc.text("Ingrédients : ",indentation, interligne-8);
    doc.text("Quantité (g) : ",indentation+50, interligne-8);
    doc.setTextColor(0, 0, 0);
    if(this.ingredientService.findAll().length>1){
      doc.setTextColor(23,162,184);
        doc.text("Ingrédients : ",115, interligne-8);
        doc.text("Quantité (g) : ",115+50, interligne-8);
        doc.setTextColor(0, 0, 0);
    }

    for (let ingred of this.ingredientService.findAll()){
      nbIngredient+=1;
      if(nbIngredient%2!=0){
        indentation=15;
        doc.circle(indentation-6, interligne-2,2,"S");
        doc.text(ingred.nom,indentation, interligne);
        doc.text(ingred.quantite.toString(), indentation+60, interligne);
        doc.line(indentation,interligne+1,indentation+85,interligne+1);
        nbLignes=nbLignes+1;
      }else{
         indentation=115;
        doc.circle(indentation-6, interligne-2,2,"S");
        doc.text(ingred.nom,indentation, interligne);
        doc.text(ingred.quantite.toString(), indentation+60, interligne);
        doc.line(indentation,interligne+1,indentation+85,interligne+1);
         interligne=interligne+7;
      }
      if((nbIngredient%70)==0){
          nbPage+=1;
          doc.text("2021 Copyright - MyMenu",70,290);
          doc.addPage();
          nbLignes=0;
          interligne=40;
          indentation=15;
          doc.setTextColor(23,162,184);
        doc.text("Ingrédients : ",indentation, interligne-8);
        doc.text("Quantité (g) : ",indentation+50, interligne-8);
          doc.setTextColor(0, 0, 0);
        if(this.ingredientService.findAll().length>70*(nbPage-1)+1){
          doc.setTextColor(23,162,184);
          doc.text("Ingrédients : ",115, interligne-8);
          doc.text("Quantité (g) : ",115+50, interligne-8);
          doc.setTextColor(0, 0, 0);
        }
      }
    }
    doc.setTextColor(23,162,184);
    doc.text("Ma liste personnelle : ",80, interligne+37);
    doc.line(10,interligne+30,200,interligne+30);
    doc.line(10,interligne+135,200,interligne+135);
    doc.line(10,interligne+30,10,interligne+135);
    doc.line(200,interligne+30,200,interligne+135);
    doc.setTextColor(0, 0, 0);

    var newInterligne=interligne+44;
    for(var i=interligne+44; i<interligne+57;i++){
      doc.circle(15, newInterligne-2,2,"S");
      doc.line(20,newInterligne+1,72,newInterligne+1);
      doc.circle(78, newInterligne-2,2,"S");
      doc.line(81,newInterligne+1,133,newInterligne+1);
      doc.circle(139, newInterligne-2,2,"S");
      doc.line(142,newInterligne+1,194,newInterligne+1);
      newInterligne+=7;
    }
    doc.text("2021 Copyright - MyMenu",70,290);
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


