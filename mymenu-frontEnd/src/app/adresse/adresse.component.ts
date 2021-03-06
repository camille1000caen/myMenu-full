import { Component, OnInit } from '@angular/core';
import {Adresse} from "../model/adresse";
import {AdresseHttpService} from "./adresse-http.service";
import {UtilisateurHttpService} from "../utilisateur/utilisateur-http.service";
import {Utilisateur} from "../model/utilisateur";
import {Coordonnees} from "../model/coordonnees";

@Component({
  selector: 'app-adresse',
  templateUrl: './adresse.component.html',
  styleUrls: ['./adresse.component.scss']
})
export class AdresseComponent implements OnInit {

  adresseForm: Adresse = null;

  constructor(private adresseService: AdresseHttpService,private utilisateurService:UtilisateurHttpService) {
  }

  ngOnInit(): void {
  }

  list(): Array<Adresse> {
    return this.adresseService.findAll();
  }

  listUtilisateur(): Array<Utilisateur> {
    return this.utilisateurService.findAll();
  }

  add() {
    this.adresseForm = new Adresse();
    this.adresseForm.coordonnees=new Coordonnees();
    this.adresseForm.utilisateur=new Utilisateur();
  }

  edit(id: number) {
    this.adresseService.findById(id).subscribe(resp => {
      this.adresseForm = resp;
      if (!this.adresseForm.coordonnees) {
        this.adresseForm.coordonnees = new Coordonnees();
      }
      if (!this.adresseForm.utilisateur) {
        this.adresseForm.utilisateur = new Utilisateur();
      }
    }, error => console.log(error));

  }

  save() {
    if (!this.adresseForm.id) {
      this.adresseService.create(this.adresseForm);
    } else {
      this.adresseService.modify(this.adresseForm);
    }
    this.adresseForm = null;
  }

  cancel() {
    this.adresseForm = null;
  }

  delete(id: number) {
    this.adresseService.deleteById(id);
  }

}
