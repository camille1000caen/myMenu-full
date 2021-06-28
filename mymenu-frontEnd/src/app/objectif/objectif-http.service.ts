import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Objectif} from "../model/objectif";
import {AppConfigService} from "../app-config.service";

@Injectable({
  providedIn: 'root'
})
export class ObjectifHttpService {
  objectifs: Array<Objectif>;
  typeObjectif:Array<string>;

  constructor(private http: HttpClient,private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<Objectif> {
    return this.objectifs;
  }

  findById(id: number): Observable<Objectif> {
    return this.http.get<Objectif>(this.appConfig.backEndUrl +"objectif/" + id);
  }

  create(objectif: Objectif) {

    this.http.post<Objectif>(this.appConfig.backEndUrl +"objectif", objectif).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(objectif: Objectif) {
    this.http.put<Objectif>(this.appConfig.backEndUrl +"objectif/" + objectif.id, objectif).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl +"objectif/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Objectif>>(this.appConfig.backEndUrl +"objectif/").subscribe(resp => {
      this.objectifs = resp;
    }, error => console.log(error))
    this.appConfig.findAllTypeObjectif().subscribe(resp => {
      this.typeObjectif = resp;
    }, error => console.log(error));
  }
}




