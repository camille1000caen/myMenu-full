import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from "../app-config.service";
import {Adresse} from "../model/adresse";

@Injectable({
  providedIn: 'root'
})
export class AdresseHttpService {

  adresses: Array<Adresse>;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<Adresse> {
    return this.adresses;
  }

  findById(id: number): Observable<Adresse> {
    return this.http.get<Adresse>(this.appConfig.backEndUrl + "adresse/" + id);
  }

  create(adresse: Adresse) {
    this.http.post<Adresse>(this.appConfig.backEndUrl + "adresse", adresse).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(adresse: Adresse): Observable<Adresse> {
    return this.http.put<Adresse>(this.appConfig.backEndUrl + "adresse/" + adresse.id, adresse);
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl + "adresse/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Adresse>>(this.appConfig.backEndUrl + "adresse/with-utilisateur").subscribe(resp => {
      this.adresses = resp;
    }, error => console.log(error))
  }
}
