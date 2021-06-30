import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ingredient} from "../model/ingredient";
import {AppConfigService} from "../app-config.service";
import {RecetteHttpService} from "../recette/recette-http.service";
import {Recette} from "../model/recette";
import {ConnexionDTO} from "../model/ConnexionDTO";
import {Utilisateur} from "../model/utilisateur";

@Injectable({
  providedIn: 'root'
})
export class ConnexionDtoHttpService {
    conn:ConnexionDTO;

  constructor(private http: HttpClient,private appConfig: AppConfigService) {
  }

  connexionAuth(conn: ConnexionDTO):Observable<Utilisateur> {
      return this.http.post<Utilisateur>(this.appConfig.backEndUrl + "utilisateur/auth", conn);
  }
}




