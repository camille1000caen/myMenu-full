import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from "../app-config.service";
import {PreferenceAlimentaire} from "../model/preferencealimentaire";
import {Repas} from "../model/repas";

@Injectable({
  providedIn: 'root'
})
export class RepasHttpService {

  repas: Array<Repas>;
  typeRepas:Array<string>=new Array<string>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<Repas> {
    return this.repas;
  }

  findById(id: number): Observable<Repas> {
    return this.http.get<Repas>(this.appConfig.backEndUrl + "repas/" + id);
  }

  create(repas: Repas) {
    this.http.post<Repas>(this.appConfig.backEndUrl + "repas", repas).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(repas: Repas): Observable<Repas> {
    return this.http.put<Repas>(this.appConfig.backEndUrl + "repas/" + repas.id, repas);
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl + "repas/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Repas>>(this.appConfig.backEndUrl + "repas/with-menu").subscribe(resp => {
      this.repas = resp;
    }, error => console.log(error))
    this.appConfig.findAllTypeRepas().subscribe(resp => {
      this.typeRepas = resp;
    }, error => console.log(error));
  }
}
