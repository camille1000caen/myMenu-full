import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Planning} from "../model/planning";
import {AppConfigService} from "../app-config.service";
import {PreferenceAlimentaire} from "../model/preferencealimentaire";

@Injectable({
  providedIn: 'root'
})
export class PlanningHttpService {
  plannings: Array<Planning>;

  constructor(private http: HttpClient,private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<Planning> {
    return this.plannings;
  }

  findById(id: number): Observable<Planning> {
    return this.http.get<Planning>(this.appConfig.backEndUrl +"planning/" + id);
  }

  create(planning: Planning) {

    this.http.post<Planning>(this.appConfig.backEndUrl +"planning", planning).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(planning: Planning) {
    this.http.put<Planning>(this.appConfig.backEndUrl +"planning/" + planning.id, planning).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl +"planning/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Planning>>(this.appConfig.backEndUrl +"planning/detail").subscribe(resp => {
      this.plannings = resp;
    }, error => console.log(error))
  }

  findAllByUtilisateur(id: number) {
    return this.http.get<Array<Planning>>(this.appConfig.backEndUrl + "planning/by-utilisateur/" + id);
  }
}




