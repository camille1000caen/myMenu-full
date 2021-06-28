import { Component, OnInit } from '@angular/core';

import {Objectif} from "../model/objectif";
import {ObjectifHttpService} from "./objectif-http.service";

@Component({
  selector: 'app-objectif',
  templateUrl: './objectif.component.html',
  styleUrls: ['./objectif.component.scss']
})
export class ObjectifComponent implements OnInit {

  objectifForm: Objectif = null;

  constructor(private objectifService : ObjectifHttpService) {  }

  ngOnInit(): void {
  }
  list(): Array<Objectif> {
    return this.objectifService.findAll();
  }
  listObjectif(): Array<string> {
    return this.objectifService.typeObjectif;
  }

  add() {
    this.objectifForm = new Objectif();

  }

  edit(id: number) {
    this.objectifService.findById(id).subscribe(resp=> {
      this.objectifForm = resp;

    }, err => console.log(err));
  }

  save() {
    if (!this.objectifForm.id) {
      this.objectifService.create(this.objectifForm);
    } else {
      this.objectifService.modify(this.objectifForm);
    }
    this.objectifForm = null;
  }

  cancel() {
    this.objectifForm = null;
  }

  delete(id: number) {
    this.objectifService.deleteById(id);
  }

}
