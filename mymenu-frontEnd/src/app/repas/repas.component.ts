import { Component, OnInit } from '@angular/core';
import {Repas} from "../model/repas";
import {RepasHttpService} from "./repas-http.service";
import {Menu} from "../model/menu";
import {MenuHttpService} from "../menu/menu-http.service";

@Component({
  selector: 'app-repas',
  templateUrl: './repas.component.html',
  styleUrls: ['./repas.component.scss']
})
export class RepasComponent implements OnInit {
  repasForm: Repas = null;

  constructor(private repasService:RepasHttpService,private menuService: MenuHttpService) {
  }

  ngOnInit(): void {
  }

  list(): Array<Repas> {
    return this.repasService.findAll();
  }

  listMenu(): Array<Menu> {
    return this.menuService.findAll();
  }

  listTypeRepas(): Array<string> {
    return this.repasService.typeRepas;
  }

  add() {
    this.repasForm = new Repas();
    this.repasForm.menu=new Menu();
  }

  edit(id: number) {
    this.repasService.findById(id).subscribe(resp => {
      this.repasForm = resp;
    }, error => console.log(error));

  }

  save() {
    if (!this.repasForm.id) {
      this.repasService.create(this.repasForm);
    } else {
      this.repasService.modify(this.repasForm);
    }
    this.repasForm = null;
  }

  cancel() {
    this.repasForm = null;
  }

  delete(id: number) {
    this.repasService.deleteById(id);
  }

}
