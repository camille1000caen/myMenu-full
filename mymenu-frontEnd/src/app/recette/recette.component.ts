import {Component, Input, OnInit} from '@angular/core';
import {RecetteHttpService} from "./recette-http.service";
import {Recette} from "../model/recette";

@Component({
  selector: 'app-recette',
  templateUrl: './recette.component.html',
  styleUrls: ['./recette.component.scss']
})
export class RecetteComponent implements OnInit {

  @Input()
  idRecette : number;

  recette: Recette = null;
  typeRecette: Array<String> =  new Array<String>();
  tab: Array<Recette>;

  constructor(private recetteService: RecetteHttpService) {
    this.recetteService.findById(this.idRecette).subscribe(resp=> {
      this.recette = resp;
    })
  }

  ngOnInit(): void {
  }
  list(): Array<Recette> {
    return this.recetteService.findAll();
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

}

