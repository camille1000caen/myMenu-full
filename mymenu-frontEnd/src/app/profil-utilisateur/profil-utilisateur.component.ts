import {Component, Input, OnInit} from '@angular/core';
import {ConnexionDTO} from "../model/ConnexionDTO";
import {Utilisateur} from "../model/utilisateur";
import {UtilisateurHttpService} from "../utilisateur/utilisateur-http.service";
import {PreferenceAlimentaire} from "../model/preferencealimentaire";
import {PreferenceAlimentaireHttpService} from "../preference-alimentaire/preference-alimentaire-http.service";
import {Planning} from "../model/planning";
import {PlanningHttpService} from "../planning/planning-http.service";

@Component({
  selector: 'app-profil-utilisateur',
  templateUrl: './profil-utilisateur.component.html',
  styleUrls: ['./profil-utilisateur.component.scss']
})
export class ProfilUtilisateurComponent implements OnInit {
  @Input()
  connexion:ConnexionDTO;
  utilisateur : Utilisateur;
  prefalims:Array<PreferenceAlimentaire>;
  plannings:Array<Planning>;
  constructor(private utilisateurService: UtilisateurHttpService,private prefalimService : PreferenceAlimentaireHttpService,private planningService:PlanningHttpService) { }

  ngOnInit(): void {
    this.utilisateur=JSON.parse(sessionStorage.getItem("utilisateur"));
    this.setPrefAlims();
    this.setPlannings();
  }

  findByConn(conn:ConnexionDTO) {
    this.utilisateurService.findByConnexion(conn).subscribe(resp => {
      this.utilisateur = resp;
    })
  }

  setPrefAlims(){
    this.prefalimService.findAllByUtilisateur(this.utilisateur.id).subscribe(resp=>{
      this.prefalims=resp;
      console.log(this.prefalims);
    })
  }

  setPlannings(){
    this.planningService.findAllByUtilisateur(this.utilisateur.id).subscribe(resp=>{
      this.plannings=resp;
      console.log(this.plannings);
    })
  }
}
