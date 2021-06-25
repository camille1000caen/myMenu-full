import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Menu} from "../model/menu";

@Injectable({
  providedIn: 'root'
})
export class MenuHttpService {
  menus: Array<Menu>;

  constructor(private http: HttpClient) {
    this.load()
  }

  findAll(): Array<Menu> {
    return this.menus;
  }

  findById(id: number): Observable<Menu> {
    return this.http.get<Menu>("menu/" + id);
  }

  create(menu: Menu) {

    this.http.post<Menu>("menu", menu).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(menu: Menu): Observable<Menu> {


    return this.http.put<Menu>("menu/" + menu.id, menu);
  }

  deleteById(id: number) {
    this.http.delete("menu/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Menu>>("menu/").subscribe(resp => {
      this.menus = resp;
    }, error => console.log(error))
  }
}




