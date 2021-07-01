import {Component, Input, OnInit} from '@angular/core';
import {Recette} from "../model/recette";
import {RecetteHttpService} from "../recette/recette-http.service";
import {RecetteComponent} from "../recette/recette.component";

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

  petitDejDetail: Array<string> = new Array();
  dejDetail: Array<string> = new Array();
  dinerDetail: Array<string> = new Array();

  constructor(private recetteService: RecetteHttpService) {

  }

  addRecette(id: number, nom:string) {
    this.menuChecked.push(id);
    let typeRepas :string;

    this.recetteService.findByIdWithPlatAndRepas(id).subscribe(resp=>{
      typeRepas=resp.plat.repas.typeRepas;
      console.log(typeRepas);
      if(typeRepas === "PETIT_DEJ"){
        this.petitDejDetail.push(nom);
        console.log("petitDejDetail = " + this.petitDejDetail);
      } else if (typeRepas === "DEJ"){
        this.dejDetail.push(nom);
        console.log("dejDetail = " + this.dejDetail);
      } else if (typeRepas === "DINNER") {
        this.dinerDetail.push(nom);
        console.log("dinerDetail = " + this.dinerDetail);
      }
    });

    console.log(this.menuChecked);

  }

  removeRecette(id: number, nom:string) {
    console.log(id);
    this.menuChecked = this.menuChecked.filter((menuIdChecked) => menuIdChecked != id);
    console.log(this.menuChecked);

    let typeRepas: string;

    this.recetteService.findByIdWithPlatAndRepas(id).subscribe(resp=>{
      typeRepas=resp.plat.repas.typeRepas;
      console.log(typeRepas);
      if(typeRepas === "PETIT_DEJ"){
        this.petitDejDetail = this.petitDejDetail.filter((menuNameChecked) => menuNameChecked != nom);
        console.log("petitDejDetail = " + this.petitDejDetail);
      } else if (typeRepas === "DEJ"){
        this.dejDetail = this.dejDetail.filter((menuNameChecked) => menuNameChecked != nom);
        console.log("dejDetail = " + this.dejDetail);
      } else if (typeRepas === "DINNER") {
        this.dinerDetail = this.dinerDetail.filter((menuNameChecked) => menuNameChecked != nom);
        console.log("dinerDetail = " + this.dinerDetail);
      }
    });

  }

  ngOnInit(): void {
    this.findByRisingNoteByTypeRepas("DINNER");
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
    if(typeRepas=="DINNER"){
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


}
