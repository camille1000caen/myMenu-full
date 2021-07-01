import { Injectable } from '@angular/core';
import {AppConfigService} from "./app-config.service";
import {Router} from "@angular/router";
import {Utilisateur} from "./model/utilisateur";
import {Observable} from "rxjs";
import {FormulaireDTO} from "./model/FormulaireDTO";
import {HttpClient} from "@angular/common/http";
import {SessionService} from "./session.service";

@Injectable({
  providedIn: 'root'
})
export class ServiceDTO {

  formulairesDTO : Array<FormulaireDTO>;

  constructor(private router:Router,private http: HttpClient, private appConfig:AppConfigService, private sessionService: SessionService) {

  }

  findById(id: number): Observable<FormulaireDTO> {
    return this.http.get<FormulaireDTO>(this.appConfig.backEndUrl + "formulaireDTO/" + id);
  }

  create(formDTO: FormulaireDTO) {
    this.http.post<Utilisateur>(this.appConfig.backEndUrl + "formulaireDTO", formDTO).subscribe(resp=>{
      this.sessionService.setSession(resp);
      this.router.navigate(["/profil-utilisateur"]);}
      ,error => console.log(error));
  }

  modify(formDTO: FormulaireDTO) {
    return this.http.put<Utilisateur>(this.appConfig.backEndUrl + "formulaireDTO/" + this.sessionService.utilisateur.id, formDTO).subscribe(resp => {
      this.sessionService.setSession(resp);
      this.router.navigate(["/profil-utilisateur"]);
    }, error => console.log(error));

  }

}
