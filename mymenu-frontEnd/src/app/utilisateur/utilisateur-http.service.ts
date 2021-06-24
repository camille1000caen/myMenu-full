import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from "../app-config.service";

class Utilisateur {
}

@Injectable({
  providedIn: 'root'
})
export class UtilisateurHttpService {

  utilisateurs: Array<Utilisateur>;

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
    this.http.delete(this.appConfig.backEndUrl + "evaluation/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Evaluation>>(this.appConfig.backEndUrl + "evaluation").subscribe(resp => {
      this.evaluations = resp;
    }, error => console.log(error))
  }
}
