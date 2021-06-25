import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Plat} from "../model/plat";

@Injectable({
  providedIn: 'root'
})
export class PlatHttpService {
  plats: Array<Plat>;

  constructor(private http: HttpClient) {
    this.load()
  }

  findAll(): Array<Plat> {
    return this.plats;
  }

  findById(id: number): Observable<Plat> {
    return this.http.get<Plat>("plat/" + id);
  }

  create(plat: Plat) {

    this.http.post<Plat>("plat", plat).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(plat: Plat): Observable<Plat> {


    return this.http.put<Plat>("plat/" + plat.id, plat);
  }

  deleteById(id: number) {
    this.http.delete("plat/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Plat>>("plat/").subscribe(resp => {
      this.plats = resp;
    }, error => console.log(error))
  }
}




