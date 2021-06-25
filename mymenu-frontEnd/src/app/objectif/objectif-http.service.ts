import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Objectif} from "../model/objectif";

@Injectable({
  providedIn: 'root'
})
export class ObjectifHttpService {
  objectifs: Array<Objectif>;

  constructor(private http: HttpClient) {
    this.load()
  }

  findAll(): Array<Objectif> {
    return this.objectifs;
  }

  findById(id: number): Observable<Objectif> {
    return this.http.get<Objectif>("objectif/" + id);
  }

  create(objectif: Objectif) {

    this.http.post<Objectif>("objectif", objectif).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(objectif: Objectif): Observable<Objectif> {


    return this.http.put<Objectif>("objectif/" + objectif.id, objectif);
  }

  deleteById(id: number) {
    this.http.delete("objectif/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Objectif>>("objectif/").subscribe(resp => {
      this.objectifs = resp;
    }, error => console.log(error))
  }
}




