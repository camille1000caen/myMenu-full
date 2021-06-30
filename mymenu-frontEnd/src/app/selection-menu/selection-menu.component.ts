import {Component, Input, OnInit} from '@angular/core';
import {Recette} from "../model/recette";
import {RecetteHttpService} from "../recette/recette-http.service";

@Component({
  selector: 'app-selection-menu',
  templateUrl: './selection-menu.component.html',
  styleUrls: ['./selection-menu.component.scss']
})
export class SelectionMenuComponent implements OnInit {

  nBMenuPerRow = new Array(4); //0 - 3
  recette: Recette = null;
  tab: Array<Recette>;

  constructor(private recetteService: RecetteHttpService) {
    this.findByRisingNote();
  }

  ngOnInit(): void {
  }

  findByRisingNote() {
    this.recetteService.findAllByRisingNote().subscribe(resp => {
      this.tab=resp;
      console.log(this.tab);
    })
  }
  randomRecette():Recette {
    //console.log("this.tab.length = " + this.tab.length);
    if(this.tab.length==0){
      this.findByRisingNote();
    }
    var idx =Math.floor(Math.random()*this.tab.length);
    this.recette = this.tab[idx];
    this.tab.splice(idx,1);

    return this.recette;
  }

}
