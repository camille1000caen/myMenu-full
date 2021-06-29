import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Plat} from "../model/plat";
import {AppConfigService} from "../app-config.service";

@Injectable({
  providedIn: 'root'
})
export class PlatHttpService {
  plats: Array<Plat>;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<Plat> {
    return this.plats;
  }

  findById(id: number): Observable<Plat> {
    return this.http.get<Plat>("plat/" + id);
  }

  create(plat: Plat) {

    this.http.post<Plat>(this.appConfig.backEndUrl +"plat", plat).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(plat: Plat): Observable<Plat> {


    return this.http.put<Plat>(this.appConfig.backEndUrl +"plat/" + plat.id, plat);
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl +"plat/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Plat>>(this.appConfig.backEndUrl +"plat/detail").subscribe(resp => {
      this.plats = resp;
    }, error => console.log(error))
  }
}




