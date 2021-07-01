import {Component, Input, OnInit} from '@angular/core';
import {Utilisateur} from "../model/utilisateur";
import {UtilisateurHttpService} from "./utilisateur-http.service";
import {ConnexionDTO} from "../model/ConnexionDTO";
import {Objectif} from "../model/objectif";
import {PreferenceAlimentaire} from "../model/preferencealimentaire";
import {parse} from "@angular/compiler/src/render3/view/style_parser";
import {PreferenceAlimentaireHttpService} from "../preference-alimentaire/preference-alimentaire-http.service";
import {ObjectifHttpService} from "../objectif/objectif-http.service";
import {Planning} from "../model/planning";
import {PlanningHttpService} from "../planning/planning-http.service";
import {FormulaireDTO} from "../model/FormulaireDTO";
import {ServiceDTO} from "../service-dto.service";
import {ActivatedRoute, Router} from "@angular/router";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.scss']
})
export class UtilisateurComponent implements OnInit {

  formDTO: FormulaireDTO = new FormulaireDTO();

  constructor(private route: ActivatedRoute, private router: Router, private utilisateurService: UtilisateurHttpService, private prefAlimService: PreferenceAlimentaireHttpService, private objectifService: ObjectifHttpService, private planningService: PlanningHttpService, private formulaireService: ServiceDTO,private sessionService : SessionService) {
    this.route.params.subscribe(params => {
      this.formulaireService.findById(params.id).subscribe(resp => {
        this.formDTO = resp;
        this.formDTO.creation = false;
      }, error => console.log(error));
    });
  }

  ngOnInit(): void {
    this.check();

  }

  check() {
    let user: Utilisateur;
    user = JSON.parse(sessionStorage.getItem("utilisateur"));
    if (user == null) {
      this.formDTO = new FormulaireDTO();
    }
    console.log(this.formDTO);
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


  /*add() {
    this.utilisateurForm = new Utilisateur();
  }

  edit(id: number) {
    this.utilisateurService.findById(id).subscribe(resp => {
      this.utilisateurForm = resp;
    }, error => console.log(error));

  }*/

  get() {
    //this.formulaireService.
  }

  save() {
    console.log(this.formDTO);
    if (this.formDTO.creation) {
      this.formulaireService.create(this.formDTO);
    } else {
      this.formulaireService.modify(this.formDTO);
    }
    this.formDTO = null;

  }

  cancel() {
    this.formDTO = null;
  }

  delete(id: number) {
    this.utilisateurService.deleteById(id);
  }

}
