import {Recette} from "../model/recette";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from "../app-config.service";

@Injectable({
  providedIn: 'root'
})
export class RecetteHttpService {
  recettes: Array<Recette>;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<Recette> {
    return this.recettes;
  }

  findAllByRisingNote(): Observable<Array<Recette>>{
    return this.http.get<Array<Recette>>(this.appConfig.backEndUrl + "recette/detail/by-rising-note");
  }

  findById(id: number): Observable<Recette> {
    return this.http.get<Recette>(this.appConfig.backEndUrl +"recette/" + id);
  }

  create(recette: Recette) {
    this.http.post<Recette>(this.appConfig.backEndUrl +"recette", recette).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(recette: Recette): Observable<Recette> {
    return this.http.put<Recette>(this.appConfig.backEndUrl +"recette/" + recette.id, recette);
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl +"recette/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Recette>>(this.appConfig.backEndUrl +"recette").subscribe(resp => {
      this.recettes = resp;
    }, error => console.log(error))
  }
}




