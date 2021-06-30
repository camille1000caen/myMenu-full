import {Component, Input, OnInit} from '@angular/core';
import {Recette} from "../model/recette";
import {RecetteHttpService} from "../recette/recette-http.service";
import {newArray} from "@angular/compiler/src/util";

@Component({
  selector: 'app-selection-menu',
  templateUrl: './selection-menu.component.html',
  styleUrls: ['./selection-menu.component.scss']
})
export class SelectionMenuComponent implements OnInit {

  nBMenuPerRow = new Array(4); //0 - 3
  recette: Recette = null;
  tab: Array<Recette>=new Array<Recette>();

  constructor(private recetteService: RecetteHttpService) {
    this.findByRisingNote();
  }

  ngOnInit(): void {
  }

  findByRisingNote() {
    this.recetteService.findAllByRisingNote().subscribe(resp => {
      this.tab=resp;
      //console.log(this.tab);
    })
  }

  tabFirst4(): Array<Recette> {
    return this.tab.filter((rec, i) => i < 4);
  }

  tabLast4(): Array<Recette> {
    return this.tab.filter((rec, i) => i >= 4);
  }


}
