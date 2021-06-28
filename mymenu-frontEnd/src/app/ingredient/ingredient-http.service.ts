import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ingredient} from "../model/ingredient";
import {AppConfigService} from "../app-config.service";
import {RecetteHttpService} from "../recette/recette-http.service";
import {Recette} from "../model/recette";

@Injectable({
  providedIn: 'root'
})
export class IngredientHttpService {
  ingredients: Array<Ingredient>;


  constructor(private http: HttpClient, private appConfig : AppConfigService, private recetteService: RecetteHttpService) {

     this.load()
  }

  findAll(): Array<Ingredient> {
    return this.ingredients;
  }
  findAllByRecette(id: number): Array<Ingredient>{
    this.findByRecette(id);
    return this.findAll();

    }
  findByRecette(id: number){
    this.http.get<Array<Ingredient>>(this.appConfig.backEndUrl +"ingredient/byrecette/" + id).subscribe(resp => {
      this.ingredients= resp;

    }, error =>{console.log(error);})
  }

  findById(id: number): Observable<Ingredient> {
    return this.http.get<Ingredient>(this.appConfig.backEndUrl +"ingredient/" + id);
  }

  create(ingredient: Ingredient) {

    this.http.post<Ingredient>(this.appConfig.backEndUrl +"ingredient", ingredient).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(ingredient: Ingredient): Observable<Ingredient> {

    return this.http.put<Ingredient>(this.appConfig.backEndUrl +"ingredient/" + ingredient.id, ingredient);
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl +"ingredient/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Ingredient>>(this.appConfig.backEndUrl +"ingredient").subscribe(resp => {
      this.ingredients = resp;
    }, error => console.log(error))
  }
}




