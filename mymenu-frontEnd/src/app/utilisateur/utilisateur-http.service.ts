import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from "../app-config.service";
import {Utilisateur} from "../model/utilisateur";
import {ConnexionDTO} from "../model/ConnexionDTO";

@Injectable({
  providedIn: 'root'
})
export class UtilisateurHttpService {

  utilisateurs: Array<Utilisateur>;
  genres:Array<string>=new Array<string>();
  physicalActivitys:Array<string>=new Array<string>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<Utilisateur> {
    return this.utilisateurs;
  }

  findById(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(this.appConfig.backEndUrl + "utilisateur/" + id);
  }

  create(utilisateur: Utilisateur) {
    this.http.post<Utilisateur>(this.appConfig.backEndUrl + "utilisateur", utilisateur).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.put<Utilisateur>(this.appConfig.backEndUrl + "utilisateur/" + utilisateur.id, utilisateur);
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl + "utilisateur/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Utilisateur>>(this.appConfig.backEndUrl + "utilisateur").subscribe(resp => {
      this.utilisateurs = resp;
    }, error => console.log(error))
    this.appConfig.findAllGenre().subscribe(resp => {
      this.genres = resp;
    }, error => console.log(error));
    this.appConfig.findAllPhysicalActivity().subscribe(resp => {
      this.physicalActivitys = resp;
    }, error => console.log(error));
  }

  findByConnexion(conn: ConnexionDTO): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(this.appConfig.backEndUrl + "utilisateur/auth",conn);
  }
}
