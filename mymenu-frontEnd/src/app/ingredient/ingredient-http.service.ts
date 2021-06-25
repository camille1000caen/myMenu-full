import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ingredient} from "../model/ingredient";

@Injectable({
  providedIn: 'root'
})
export class IngredientHttpService {
  ingredients: Array<Ingredient>;

  constructor(private http: HttpClient) {
    this.load()
  }

  findAll(): Array<Ingredient> {
    return this.ingredients;
  }

  findById(id: number): Observable<Ingredient> {
    return this.http.get<Ingredient>("ingredient/" + id);
  }

  create(ingredient: Ingredient) {

    this.http.post<Ingredient>("ingredient", ingredient).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(ingredient: Ingredient): Observable<Ingredient> {


    return this.http.put<Ingredient>("ingredient/" + ingredient.id, ingredient);
  }

  deleteById(id: number) {
    this.http.delete("ingredient/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Ingredient>>("ingredient/").subscribe(resp => {
      this.ingredients = resp;
    }, error => console.log(error))
  }
}




