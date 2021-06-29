import { Component, OnInit } from '@angular/core';

import {PlatHttpService} from "./plat-http.service";
import {Plat} from "../model/plat";
import {Repas} from "../model/repas";



@Component({
  selector: 'app-plat',
  templateUrl: './plat.component.html',
  styleUrls: ['./plat.component.scss']
})
export class PlatComponent implements OnInit {

  platForm: Plat = null;


  constructor(private platService: PlatHttpService) {

  }

  ngOnInit(): void {
  }
  list(): Array<Plat> {
    return this.platService.findAll();
  }
  listPlat(repas :Repas) {
    return this.platService.findAllByRepas(repas);
  }


  add() {
    this.platForm = new Plat();

  }

  edit(id: number) {

    this.platService.findById(id).subscribe(resp=> {
      this.platForm = resp;

    }, err => console.log(err));
  }

  save() {

    if (!this.platForm.id) {
      this.platService.create(this.platForm);
    } else {
      this.platService.modify(this.platForm).subscribe(resp => {
        this.platService.load();
      }, error => console.log(error));
    }
    this.platForm = null;
  }

  cancel() {
    this.platForm = null;
  }

  delete(id: number) {
    this.platService.deleteById(id);
  }

}



