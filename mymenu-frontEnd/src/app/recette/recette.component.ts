import {Component, Input, OnInit} from '@angular/core';
import {RecetteHttpService} from "./recette-http.service";
import {Recette} from "../model/recette";
import {jsPDF} from "jspdf";

@Component({
  selector: 'app-recette',
  templateUrl: './recette.component.html',
  styleUrls: ['./recette.component.scss']
})
export class RecetteComponent implements OnInit {

  @Input()
  idRecette : number;

  recette: Recette = new Recette();
  typeRecette: Array<String> =  new Array<String>();
  tab: Array<Recette>;

  constructor(private recetteService: RecetteHttpService) {

  }

  ngOnInit(): void {
    this.recetteService.findById(this.idRecette).subscribe(resp=> {
      this.recette = resp;
    });
  }
  list(): Array<Recette> {
    return this.recettes = this.recetteService.findAll();
  }


  listPlat(): Array<Recette> {
    return this.recetteService.findAll();
  }



  edit(id: number) {

    this.recetteService.findById(id).subscribe(resp=> {
      this.recette = resp;

    }, err => console.log(err));
  }

  save() {

    if (!this.recette.id) {
      this.recetteService.create(this.recette);
    } else {
      this.recetteService.modify(this.recette).subscribe(resp => {
        this.recetteService.load();
      }, error => console.log(error));
    }
    this.recette = null;
  }

  cancel() {
    this.recette = null;
  }

  delete(id: number) {
    this.recetteService.deleteById(id);
  }
  pdfDownload() {
    var doc = new jsPDF();
    var interligne = 40;
    var indentation=15;
    var nbLignes=0;
    var nbRct=0;
    var nbPage=1;
   // var dateDuJour=new Date();
   // var mois=dateDuJour.getUTCMonth()+1;//décompte des mois de 0 à 11

    doc.setDrawColor(23,162,184);
    doc.setTextColor(23,162,184);
    //doc.text("Ma liste de courses du : "+dateDuJour.getUTCDate()+'/'+mois+'/'+dateDuJour.getUTCFullYear(),70, interligne-25);
    doc.text("nom recettes : ",indentation, interligne-8);
    doc.text("étape : ",indentation+50, interligne-8);
    doc.setTextColor(0, 0, 0);
    for (let rct of  this.recettes) {
      doc.text("blabla",10,10);
    }
    for (let rct of  this.recettes) {
      nbRct += 1;
      if (nbRct % 2 != 0) {
        indentation = 15;
        doc.circle(indentation - 6, interligne - 2, 2, "S");
        doc.text(rct.nom, indentation, interligne);
        doc.text(rct.etapes, indentation + 60, interligne);
        doc.line(indentation, interligne + 1, indentation + 85, interligne + 1);
        nbLignes = nbLignes + 1;
    //   } else {
        indentation = 115;
        doc.circle(indentation - 6, interligne - 2, 2, "S");
        doc.text(rct.nom, indentation, interligne);
        doc.text(rct.etapes, indentation + 60, interligne);
        doc.line(indentation, interligne + 1, indentation + 85, interligne + 1);
        interligne = interligne + 7;
      }
        // if((nbRct%70)==0){
        //   nbPage+=1;
        //   doc.text("2021 Copyright - MyMenu",70,290);
        //   doc.addPage();
        //   nbLignes=0;
        //   interligne=40;
        //   indentation=15;
        //   doc.setTextColor(23,162,184);
        //   doc.text("Ingrédients : ",indentation, interligne-8);
        //   doc.text("Quantité (g) : ",indentation+50, interligne-8);
        //   doc.setTextColor(0, 0, 0);
        //   if( this.listeCourse.length>70*(nbPage-1)+1){
        //     doc.setTextColor(23,162,184);
        //     doc.text("Ingrédients : ",115, interligne-8);
        //     doc.text("Quantité (g) : ",115+50, interligne-8);
        //     doc.setTextColor(0, 0, 0);
        //   }
        // }
      }
      // doc.setTextColor(23,162,184);
      // doc.text("Ma liste personnelle : ",80, interligne+37);
      // doc.line(10,interligne+30,200,interligne+30);
      // doc.line(10,interligne+135,200,interligne+135);
      // doc.line(10,interligne+30,10,interligne+135);
      // doc.line(200,interligne+30,200,interligne+135);
      // doc.setTextColor(0, 0, 0);
      //
      // var newInterligne=interligne+44;
      // for(var i=interligne+44; i<interligne+57;i++){
      //   doc.circle(15, newInterligne-2,2,"S");
      //   doc.line(20,newInterligne+1,72,newInterligne+1);
      //   doc.circle(78, newInterligne-2,2,"S");
      //   doc.line(81,newInterligne+1,133,newInterligne+1);
      //   doc.circle(139, newInterligne-2,2,"S");
      //   doc.line(142,newInterligne+1,194,newInterligne+1);
      //   newInterligne+=7;
      // }
      doc.text("2021 Copyright - MyMenu", 70, 290);
      doc.save("Ma liste de course.pdf");

  }

}

