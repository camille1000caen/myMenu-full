import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Menu} from "../model/menu";
import {AppConfigService} from "../app-config.service";

@Injectable({
  providedIn: 'root'
})
export class MenuHttpService {
  menus: Array<Menu>;

  constructor(private http: HttpClient,private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<Menu> {
    return this.menus;
  }

  findById(id: number): Observable<Menu> {
    return this.http.get<Menu>(this.appConfig.backEndUrl + "menu/" + id);
  }

  create(menu: Menu) {

    this.http.post<Menu>(this.appConfig.backEndUrl + "menu", menu).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(menu: Menu) {
    this.http.put<Menu>(this.appConfig.backEndUrl +"menu/" + menu.id, menu).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl +"menu/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Menu>>(this.appConfig.backEndUrl +"menu/with-planning").subscribe(resp => {
      this.menus = resp;
    }, error => console.log(error))
  }
}




