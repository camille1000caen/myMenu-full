import { Component, OnInit } from '@angular/core';
import {Ingredient} from "../model/ingredient";
import {ListeCoursesHttpService} from "./liste-Courses-http.service";
import {AjustementQuantiteHttpService} from "../ajustement-quantite/ajustementQuantite-http.service";
import {AjustementQuantite} from "../model/ajustementQuantite";
import {IngredientHttpService} from "../ingredient/ingredient-http.service";
import {jsPDF} from "jspdf";
import {HttpClient} from "@angular/common/http";
import {AppConfigService} from "../app-config.service";
import {newArray} from "@angular/compiler/src/util";
import {isEmpty} from "rxjs/operators";
import {SelectionMenuComponent} from "../selection-menu/selection-menu.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-liste-courses',
  templateUrl: './liste-courses.component.html',
  styleUrls: ['./liste-courses.component.scss']
})
export class ListeCoursesComponent implements OnInit {

  listeCourseForm: Ingredient = null;
  listeCourse: Array<Ingredient> = new Array<Ingredient>();

  constructor(private router : Router,private listeService: ListeCoursesHttpService, private ingredientService : IngredientHttpService) {
    listeService.reload();
  }

  ngOnInit(): void {
  }

  list(): Array<Ingredient> {
    return this.listeService.findAll();
  }

  listCopie() : Array<Ingredient>{
    let listeIntermediaire=new Array<Ingredient>();
    var listeNom=new Array<String>();
    const isEmpty = (val: any) => val == null || !(Object.keys(val) || val).length;

    this.listeCourse=this.list();

    for(var ingred in this.listeCourse){
      if(listeNom.includes(this.listeCourse[ingred].nom)){
        let indice=0;
        for(let i=0; i<listeNom.length;i++){
          if(listeNom[i]===this.listeCourse[ingred].nom){
            indice=i;
          }
        }
          listeIntermediaire[indice].quantite+=this.listeCourse[ingred].quantite;
        this.listeCourse.splice(Number(ingred),1);
        if(isEmpty(listeIntermediaire)){
          break;
        }
      }else if(!listeNom.includes(this.listeCourse[ingred].nom)){
        listeNom.push(this.listeCourse[ingred].nom);
        listeIntermediaire.push(this.listeCourse[ingred]);
      }else{
        break;
      }
    }
    return this.listeCourse=listeIntermediaire;
  }



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
    if(this.listeCourse.length>1){
      doc.setTextColor(23,162,184);
      doc.text("Ingrédients : ",115, interligne-8);
      doc.text("Quantité (g) : ",115+50, interligne-8);
      doc.setTextColor(0, 0, 0);
    }

    for (let ingred of  this.listeCourse){
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
        if( this.listeCourse.length>70*(nbPage-1)+1){
          doc.setTextColor(23,162,184);
          doc.text("Ingrédients : ",115, interligne-8);
          doc.text("Quantité (g) : ",115+50, interligne-8);
          doc.setTextColor(0, 0, 0);
        }
      }
    }
    if(nbLignes>16){
      doc.text("2021 Copyright - MyMenu",70,290);
      doc.addPage();
      interligne=40;
    }

    doc.setTextColor(23,162,184);
    doc.text("Ma liste personnelle : ",80, interligne+37);
    doc.line(10,interligne+30,200,interligne+30);
    doc.line(10,interligne+135,200,interligne+135);
    doc.line(10,interligne+30,10,interligne+135);
    doc.line(200,interligne+30,200,interligne+135);
    doc.setTextColor(0, 0, 0);

    var newInterligne=interligne+44;
    for(var i=interligne+44; i<interligne+57;i++) {
      doc.circle(15, newInterligne - 2, 2, "S");
      doc.line(20, newInterligne + 1, 72, newInterligne + 1);
      doc.circle(78, newInterligne - 2, 2, "S");
      doc.line(81, newInterligne + 1, 133, newInterligne + 1);
      doc.circle(139, newInterligne - 2, 2, "S");
      doc.line(142, newInterligne + 1, 194, newInterligne + 1);
      newInterligne += 7;

       }
    doc.text("2021 Copyright - MyMenu",70,290);
    doc.save("Ma liste de course.pdf");
  }

  // add() {
  //   this.listeCourseForm = new Ingredient();
  // }

  moins(id : number){
    for(let i=0;i<this.listeCourse.length;i++){
      if(this.listeCourse[i].id==id){
        this.listeCourse[i].quantite=this.listeCourse[i].quantite-1;
      }
    }
  }

  plus(id : number){
    for(let i=0;i<this.listeCourse.length;i++) {
      if (this.listeCourse[i].id == id) {
        this.listeCourse[i].quantite = this.listeCourse[i].quantite + 1;
      }
    }
  }

  edit(id : number) {
    this.listeCourseForm=this.listeService.findById(id);
  }

  save() {
      this.listeCourseForm=null;
  }

  delete(id:number){
    this.listeService.deleteById(id);
}

}
