import { Component, OnInit } from '@angular/core';
import {RecetteHttpService} from "./recette-http.service";
import {Recette} from "../model/recette";

@Component({
  selector: 'app-recette',
  templateUrl: './recette.component.html',
  styleUrls: ['./recette.component.scss']
})
export class RecetteComponent implements OnInit {

  recetteForm: Recette = null;
  typeRecette: Array<String> =  new Array<String>();

  constructor(private recetteService: RecetteHttpService) {
    this.typeRecette.push("Halal");
    this.typeRecette.push("None");
    this.typeRecette.push("Vegan");
  }

  ngOnInit(): void {
  }
  list(): Array<Recette> {
    return this.recetteService.findAll();
  }



  add() {
    this.recetteForm = new Recette();

  }

  edit(id: number) {

    this.recetteService.findById(id).subscribe(resp=> {
      this.recetteForm = resp;

    }, err => console.log(err));
  }

  save() {

    if (!this.recetteForm.id) {
      this.recetteService.create(this.recetteForm);
    } else {
      this.recetteService.modify(this.recetteForm).subscribe(resp => {
        this.recetteService.load();
      }, error => console.log(error));
    }
    this.recetteForm = null;
  }

  cancel() {
    this.recetteForm = null;
  }

  delete(id: number) {
    this.recetteService.deleteById(id);
  }

}

