import {Component, Input, OnInit, Output} from '@angular/core';
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

  @Output()
  nomRecette: string;

  recette: Recette = new Recette();
  recettes: Array<Recette> =  new Array<Recette>();
  tab: Array<Recette>;
  recettes:Array<Recette>;

  menuChecked : Array<number> = new Array(); // recréé à chaque fois ?
  constructor(private recetteService: RecetteHttpService) {

  }

  ngOnInit(): void {
    this.recetteService.findById(this.idRecette).subscribe(resp=> {
      this.recette = resp;
    });
    this.nomRecette = this.recette.nom;
  }

  getMenuId(event:any, id:number){
    //console.log(event);
    if(event.target.checked){
      console.log("ID Menu : " + id + " Checked!");
      this.menuChecked.push(id);
    } else {
      console.log("ID Menu : " + id + " UNchecked!");
      this.menuChecked = this.menuChecked.filter((menuIdChecked) => menuIdChecked!=id);
    }
    console.log(this.menuChecked);
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


  /*pdfDownload() {
    var doc = new jsPDF();
    var interligne = 40;
    var indentation=15;
    doc.setTextColor(23, 162, 184);
    doc.text("Mes menus de la semaine", 72, 20);

    for (let rct of  this.recettes) {

      interligne = interligne + 7;
      doc.setTextColor(23, 162, 184);
      doc.text("Ma recette : ", indentation, interligne - 7);
      doc.setTextColor(0, 0, 0);
      doc.text(rct.nom, indentation, interligne);
      interligne = interligne + 7;
      doc.setTextColor(23, 162, 184);
      doc.text("Mes étapes : ", indentation, interligne);
      doc.setTextColor(0, 0, 0);
      doc.text(rct.etapes, indentation, interligne + 7);
      doc.text("2021 Copyright - MyMenu", 70, 290);
      doc.addPage();
      interligne=15;
    }

  }*/

}

