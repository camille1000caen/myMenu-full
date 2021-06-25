import {Recette} from "../model/recette";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RecetteHttpService {
  recettes: Array<Recette>;

  constructor(private http: HttpClient) {
    this.load()
  }

  findAll(): Array<Recette> {
    return this.recettes;
  }

  findById(id: number): Observable<Recette> {
    return this.http.get<Recette>("recette/" + id);
  }

  create(recette: Recette) {

    this.http.post<Recette>("recette", recette).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(recette: Recette): Observable<Recette> {


    return this.http.put<Recette>("recette/" + recette.id, recette);
  }

  deleteById(id: number) {
    this.http.delete("recette/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Recette>>("recette/").subscribe(resp => {
      this.recettes = resp;
    }, error => console.log(error))
  }
}




