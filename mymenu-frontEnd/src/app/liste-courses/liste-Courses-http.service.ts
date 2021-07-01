import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppConfigService} from "../app-config.service";
import {Ingredient} from "../model/ingredient";
import {SelectionMenuComponent} from "../selection-menu/selection-menu.component";


@Injectable({
  providedIn: 'root'
})
export class ListeCoursesHttpService {

  listeCourses: Array<Ingredient> = new Array<Ingredient>();
  ingredients: Array<Ingredient> = new Array<Ingredient>();
  listeIdTest: Array<number> = new Array<number>();


  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.reload();
  }

  reload() {
    this.ingredients = new Array<Ingredient>();
    this.listeIdTest = JSON.parse(sessionStorage.getItem("idRecette"));

    for (var i = 0; i < this.listeIdTest.length; i++) {
      this.findByRecette(this.listeIdTest[i]);
    }
  }

  findAll(): Array<Ingredient> {
    return this.ingredients;
  }

  findByRecette(id: number) {
    this.http.get<Array<Ingredient>>(this.appConfig.backEndUrl + "ingredient/byrecette/" + id).subscribe(resp => {
      for (var i = 0; i < resp.length; i++) {
        this.ingredients.push(resp[i]);
      }
    }, error => console.log(error))
  }

  findById(id: number): Ingredient {
    for (let ingredient of this.ingredients) {
      if (ingredient.id == id) {
        return ingredient;
      }
    }
    return null;
  }

  modify(ingredient: Ingredient) {
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
}
