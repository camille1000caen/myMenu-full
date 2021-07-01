import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from "../app-config.service";
import {ListeCourses} from "../model/listeCourses";
import {Ingredient} from "../model/ingredient";
import {newArray} from "@angular/compiler/src/util";
import {Recette} from "../model/recette";


@Injectable({
  providedIn: 'root'
})
export class ListeCoursesHttpService {

  listeCourses: Array<Ingredient>=new Array<Ingredient>();
  ingredients : Array<Ingredient>=new Array<Ingredient>();
  listeIdTest : Array<number>=new Array<number>();


  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.listeIdTest = [1,19,32,46,57,64,77,90,99];

    for (var i = 0; i < this.listeIdTest.length; i++) {
      this.findByRecette(this.listeIdTest[i]);
    }
  }

  findAll(): Array<Ingredient> {
      return this.ingredients;
  }

  findAllByRecette(id: number): Array<Ingredient>{
     this.findByRecette(id);
    return this.findAll();
  }


  findByRecette(id:number){//}  : Array<Ingredient>{
    this.http.get<Array<Ingredient>>(this.appConfig.backEndUrl +"ingredient/byrecette/"+id ).subscribe(resp => {
      for(var i=0;i<resp.length;i++){
        this.ingredients.push(resp[i]);
      }
    }, error => console.log(error))
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
