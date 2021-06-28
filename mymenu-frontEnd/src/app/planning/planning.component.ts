import { Component, OnInit } from '@angular/core';
import {PreferenceAlimentaire} from "../model/preferencealimentaire";
import {PreferenceAlimentaireHttpService} from "../preference-alimentaire/preference-alimentaire-http.service";
import {UtilisateurHttpService} from "../utilisateur/utilisateur-http.service";
import {Utilisateur} from "../model/utilisateur";
import {Planning} from "../model/planning";
import {PlanningHttpService} from "./planning-http.service";
import {Objectif} from "../model/objectif";
import {ObjectifHttpService} from "../objectif/objectif-http.service";

@Component({
  selector: 'app-planning',
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.scss']
})
export class PlanningComponent implements OnInit {

  planningForm: Planning = null;

  constructor(private planningService:PlanningHttpService,private utilisateurService: UtilisateurHttpService,private objectifService: ObjectifHttpService) {
  }

  ngOnInit(): void {
  }

  list(): Array<Planning> {
    return this.planningService.findAll();
  }

  listObjectif(): Array<Objectif> {
    return this.objectifService.findAll();
  }

  listUtilisateur(): Array<Utilisateur> {
    return this.utilisateurService.findAll();
  }


  add() {
    this.planningForm = new Planning();
    this.planningForm.utilisateur=new Utilisateur();
    this.planningForm.objectif=new Objectif();
  }

  edit(id: number) {
    this.planningService.findById(id).subscribe(resp => {
      this.planningForm = resp;
      if (!this.planningForm.utilisateur) {
        this.planningForm.utilisateur = new Utilisateur();
      }
      if (!this.planningForm.objectif) {
        this.planningForm.objectif = new Objectif();
      }
    }, error => console.log(error));

  }

  save() {
    if(this.planningForm.utilisateur && !this.planningForm.utilisateur.id) {
      this.planningForm.utilisateur = null;
    }
    if(this.planningForm.objectif && !this.planningForm.objectif.id) {
      this.planningForm.objectif = null;
    }
    if (!this.planningForm.id) {
      this.planningService.create(this.planningForm);
    } else {
      this.planningService.modify(this.planningForm);
    }
    this.planningForm = null;
  }

  cancel() {
    this.planningForm = null;
  }

  delete(id: number) {
    this.planningService.deleteById(id);
  }

}
