import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from "../app-config.service";
import {PreferenceAlimentaire} from "../model/preferencealimentaire";

@Injectable({
  providedIn: 'root'
})
export class PreferenceAlimentaireHttpService {

  preferenceAlimentaires: Array<PreferenceAlimentaire>;
  typeAlimentations:Array<string>=new Array<string>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<PreferenceAlimentaire> {
    return this.preferenceAlimentaires;
  }

  findAllByUtilisateur(id:number): Observable<Array<PreferenceAlimentaire>> {
    return this.http.get<Array<PreferenceAlimentaire>>(this.appConfig.backEndUrl + "preferencealimentaire/by-utilisateur/" + id);
  }

  findById(id: number): Observable<PreferenceAlimentaire> {
    return this.http.get<PreferenceAlimentaire>(this.appConfig.backEndUrl + "preferencealimentaire/" + id);
  }

  create(preferenceAlimentaire: PreferenceAlimentaire) {
    this.http.post<PreferenceAlimentaire>(this.appConfig.backEndUrl + "preferencealimentaire", preferenceAlimentaire).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(preferenceAlimentaire: PreferenceAlimentaire): Observable<PreferenceAlimentaire> {
    return this.http.put<PreferenceAlimentaire>(this.appConfig.backEndUrl + "preferencealimentaire/" + preferenceAlimentaire.id, preferenceAlimentaire);
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl + "preferencealimentaire/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<PreferenceAlimentaire>>(this.appConfig.backEndUrl + "preferencealimentaire/detailUtilisateur").subscribe(resp => {
      this.preferenceAlimentaires = resp;
    }, error => console.log(error))
    this.appConfig.findAllTypeAlimentations().subscribe(resp => {
      this.typeAlimentations = resp;
    }, error => console.log(error));
  }
}
