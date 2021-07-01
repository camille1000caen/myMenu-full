import {Component, Input, OnInit} from '@angular/core';
import {Utilisateur} from "../model/utilisateur";
import {UtilisateurHttpService} from "./utilisateur-http.service";
import {ConnexionDTO} from "../model/ConnexionDTO";

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.scss']
})
export class UtilisateurComponent implements OnInit {

  utilisateurForm: Utilisateur = null;

  constructor(private utilisateurService: UtilisateurHttpService) {
  }

  ngOnInit(): void {

  }

  list(): Array<Utilisateur> {
    return this.utilisateurService.findAll();
  }

  listGenre(): Array<string> {
    return this.utilisateurService.genres;
  }

  listPhysicalActivity(): Array<string> {
    return this.utilisateurService.physicalActivitys;
  }




  add() {
    this.utilisateurForm = new Utilisateur();
  }

  edit(id: number) {
    this.utilisateurService.findById(id).subscribe(resp => {
      this.utilisateurForm = resp;
    }, error => console.log(error));

  }

  save() {
    if (!this.utilisateurForm.id) {
      this.utilisateurService.create(this.utilisateurForm);
    } else {
      this.utilisateurService.modify(this.utilisateurForm);
    }
    this.utilisateurForm = null;
  }

  cancel() {
    this.utilisateurForm = null;
  }

  delete(id: number) {
    this.utilisateurService.deleteById(id);
  }

}
