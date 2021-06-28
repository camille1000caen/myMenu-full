import { Component, OnInit } from '@angular/core';
import {PreferenceAlimentaire} from "../model/preferencealimentaire";
import {Utilisateur} from "../model/utilisateur";
import {Menu} from "../model/menu";
import {MenuHttpService} from "./menu-http.service";
import {PlanningHttpService} from "../planning/planning-http.service";
import {Planning} from "../model/planning";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  menuForm: Menu = null;

  constructor(private menuService:MenuHttpService,private planningService: PlanningHttpService) {
  }

  ngOnInit(): void {
  }

  list(): Array<Menu> {
    return this.menuService.findAll();
  }

  listPlanning(): Array<Planning> {
    return this.planningService.findAll();
  }


  add() {
    this.menuForm = new Menu();
    this.menuForm.planning=new Planning();
  }

  edit(id: number) {
    this.menuService.findById(id).subscribe(resp => {
      this.menuForm = resp;
      if (!this.menuForm.planning) {
        this.menuForm.planning = new Planning();
      }
    }, error => console.log(error));

  }

  save() {
    if (!this.menuForm.id) {
      this.menuService.create(this.menuForm);
    } else {
      this.menuService.modify(this.menuForm);
    }
    this.menuForm = null;
  }

  cancel() {
    this.menuForm = null;
  }

  delete(id: number) {
    this.menuService.deleteById(id);
  }

}
