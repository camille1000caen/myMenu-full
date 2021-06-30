import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from "../app-config.service";
import {ListeCourses} from "../model/listeCourses";
import {Ingredient} from "../model/ingredient";
import {newArray} from "@angular/compiler/src/util";


@Injectable({
  providedIn: 'root'
})
export class ListeCoursesHttpService {

  listeCourses: Array<Ingredient>=new Array<Ingredient>();
  ingredients : Array<Ingredient>=new Array<Ingredient>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<Ingredient> {
      return this.ingredients;
  }

  findById(id: number): Ingredient {
    // return this.http.get<Ingredient>(this.appConfig.backEndUrl +"ingredient/" + id);
    for (let ingredient of this.ingredients) {
      if (ingredient.id == id) {
        return ingredient;
      }
    }
    return null;
  }

  modify(ingredient: Ingredient){
    let find: boolean = false;
    for (var indice = 0; indice < this.ingredients.length; indice++) {
      if (this.listeCourses[indice].id == ingredient.id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.listeCourses[indice] = ingredient;
    }
  }

  deleteById(id: number) {
    let find: boolean = false;
    for (var indice = 0; indice < this.ingredients.length; indice++) {
      if (this.ingredients[indice].id == id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.ingredients.splice(indice, 1);
    }
  }

  load() {
      this.http.get<Array<Ingredient>>(this.appConfig.backEndUrl +"ingredient").subscribe(resp => {
      this.ingredients = resp;
    }, error => console.log(error))
  }
}
