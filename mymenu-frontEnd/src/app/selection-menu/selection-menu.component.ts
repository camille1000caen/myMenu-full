import {Component, Input, OnInit} from '@angular/core';
import {Recette} from "../model/recette";
import {RecetteHttpService} from "../recette/recette-http.service";
import {RecetteComponent} from "../recette/recette.component";
import {jsPDF} from "jspdf";
import {Router} from "@angular/router";
import {Ingredient} from "../model/ingredient";
import {Observable} from "rxjs";

@Component({
  selector: 'app-selection-menu',
  templateUrl: './selection-menu.component.html',
  styleUrls: ['./selection-menu.component.scss']
})
export class SelectionMenuComponent implements OnInit {

  recette: Recette = null;
  tab : Array<Recette>=new Array<Recette>();
  tabdej: Array<Recette>=new Array<Recette>();
  tabpetitdej: Array<Recette>=new Array<Recette>();
  tabdiner: Array<Recette>=new Array<Recette>();
  menuChecked: Array<number> = new Array();
  recettes: Array<Recette>=new Array<Recette>();
  constructor(private router : Router,private recetteService: RecetteHttpService) {

  }

  addRecette(id: number) {
    console.log(id);
    this.menuChecked.push(id);

    console.log(this.menuChecked);
  }


  removeRecette(id: number) {
    console.log(id);
    this.menuChecked = this.menuChecked.filter((menuIdChecked) => menuIdChecked != id);
    console.log(this.menuChecked);
  }

  tableIdChecked() {
    sessionStorage.setItem("idRecette", JSON.stringify(this.menuChecked));
    this.router.navigate(["/listeCourse"]);
  }

  ngOnInit(): void {
    this.findByRisingNoteByTypeRepas("DINER");
    this.findByRisingNoteByTypeRepas("PETIT_DEJ");
    this.findByRisingNoteByTypeRepas("DEJ");
  }

  findByRisingNote() {
    this.recetteService.findAllByRisingNote().subscribe(resp => {
      this.tab=resp;
      //console.log(this.tab);
    })
  }

  findByRisingNoteByTypeRepas(typeRepas:string) {
    if(typeRepas=="DINER"){
      this.recetteService.findAllByRisingNoteByTypeRepas(typeRepas).subscribe(resp => {
        this.tabdiner=resp;
        console.log(this.tabdiner);
        console.log(typeRepas);
      })
    }
    else if (typeRepas=="DEJ"){
      this.recetteService.findAllByRisingNoteByTypeRepas(typeRepas).subscribe(resp => {
        this.tabdej=resp;
        console.log(this.tabdej);
      })
    }
    else if(typeRepas=="PETIT_DEJ"){
      this.recetteService.findAllByRisingNoteByTypeRepas(typeRepas).subscribe(resp => {
        this.tabpetitdej=resp;
        console.log(this.tabpetitdej);
      })
    }


  }

  tabFirst4(tab:Array<Recette>): Array<Recette> {
    return tab.filter((rec, i) => i < 4);
  }

  tabLast4(tab:Array<Recette>): Array<Recette> {
    return tab.filter((rec, i) => i >= 4);
  }

  list(): Array<Recette> {
    return this.recettes = this.recetteService.findAll();
  }

  pdfDownload() {
    var doc = new jsPDF();
    var interligne = 40;
    var indentation=15;
    doc.setTextColor(23, 162, 184);
    doc.text("Mes menus de la semaine", 72, 20);
    for (let rct of  this.recetteService.recettes) {

        if(this.menuChecked.includes(rct.id)){
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

    }
    doc.save("Mes menus.pdf");
  }
}


