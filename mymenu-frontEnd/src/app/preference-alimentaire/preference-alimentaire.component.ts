import { Component, OnInit } from '@angular/core';
import {UtilisateurHttpService} from "../utilisateur/utilisateur-http.service";
import {PreferenceAlimentaire} from "../model/preferencealimentaire";
import {PreferenceAlimentaireHttpService} from "./preference-alimentaire-http.service";
import {Utilisateur} from "../model/utilisateur";

@Component({
  selector: 'app-preference-alimentaire',
  templateUrl: './preference-alimentaire.component.html',
  styleUrls: ['./preference-alimentaire.component.scss']
})
export class PreferenceAlimentaireComponent implements OnInit {

  preferenceAlimentaireForm: PreferenceAlimentaire = null;

  constructor(private preferenceAlimentaireService:PreferenceAlimentaireHttpService,private utilisateurService: UtilisateurHttpService) {
  }

  ngOnInit(): void {
  }

  list(): Array<PreferenceAlimentaire> {
    return this.preferenceAlimentaireService.findAll();
  }

  listTypeAlimentation(): Array<string> {
    return this.preferenceAlimentaireService.typeAlimentations;
  }

  listUtilisateur(): Array<Utilisateur> {
    return this.utilisateurService.findAll();
  }


  add() {
    this.preferenceAlimentaireForm = new PreferenceAlimentaire();
  }

  edit(id: number) {
    this.preferenceAlimentaireService.findById(id).subscribe(resp => {
      this.preferenceAlimentaireForm = resp;
    }, error => console.log(error));

  }

  save() {
    if (!this.preferenceAlimentaireForm.id) {
      this.preferenceAlimentaireService.create(this.preferenceAlimentaireForm);
    } else {
      this.preferenceAlimentaireService.modify(this.preferenceAlimentaireForm);
    }
    this.preferenceAlimentaireForm = null;
  }

  cancel() {
    this.preferenceAlimentaireForm = null;
  }

  delete(id: number) {
    this.preferenceAlimentaireService.deleteById(id);
  }

}
