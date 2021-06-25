import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from "../app-config.service";
import {AjustementQuantite} from "../model/ajustementQuantite";

@Injectable({
  providedIn: 'root'
})
export class AjustementQuantiteHttpService {

  ajustements: Array<AjustementQuantite>;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<AjustementQuantite> {
    return this.ajustements;
  }

  findById(id: number): Observable<AjustementQuantite> {
    return this.http.get<AjustementQuantite>(this.appConfig.backEndUrl + "ajustementQuantite/" + id);
  }

  create(ajustement: AjustementQuantite) {
    this.http.post<AjustementQuantite>(this.appConfig.backEndUrl + "ajustementQuantite", ajustement).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(ajustement: AjustementQuantite): Observable<AjustementQuantite> {
    return this.http.put<AjustementQuantite>(this.appConfig.backEndUrl + "ajustementQuantite/" + ajustement.id, ajustement);
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl + "ajustementQuantite/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<AjustementQuantite>>(this.appConfig.backEndUrl + "ajustementQuantite").subscribe(resp => {
      this.ajustements = resp;
    }, error => console.log(error))
  }
}
