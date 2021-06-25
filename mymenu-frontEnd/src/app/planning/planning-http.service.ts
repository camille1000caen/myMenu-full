import {Injectable} from "@angular/core";

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Planning} from "../model/planning";

@Injectable({
  providedIn: 'root'
})
export class PlanningHttpService {
  plannings: Array<Planning>;

  constructor(private http: HttpClient) {
    this.load()
  }

  findAll(): Array<Planning> {
    return this.plannings;
  }

  findById(id: number): Observable<Planning> {
    return this.http.get<Planning>("planning/" + id);
  }

  create(planning: Planning) {

    this.http.post<Planning>("planning", planning).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(planning: Planning): Observable<Planning> {


    return this.http.put<Planning>("planning/" + planning.id, planning);
  }

  deleteById(id: number) {
    this.http.delete("planning/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Planning>>("planning/").subscribe(resp => {
      this.plannings = resp;
    }, error => console.log(error))
  }
}




