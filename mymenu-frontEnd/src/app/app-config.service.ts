import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  backEndUrl: string = "http://localhost:8080/";
  frontEndUrl: string = "http://localhost:4200/";
  constructor(private http: HttpClient) {

  }

  findAllGenre(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "genre");
  }
  findAllPhysicalActivity(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "physicalactivity");
  }
  findAllProduitSaison(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "produitsaison");
  }
  findAllTypeObjectif(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "typeobjectif");
  }
  findAllTypeAlimentations(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "typealimentation");
  }
  findAllTypeProduit(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "typeproduit");
  }
  findAllTypeRepas(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "typerepas");
  }

}
