import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from "../app-config.service";
import {ListeCourses} from "../model/listeCourses";


@Injectable({
  providedIn: 'root'
})
export class ListeCoursesHttpService {

  listeCourses: Array<ListeCourses>;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.load()
  }

  findAll(): Array<ListeCourses> {
    return this.listeCourses;
  }

  findById(id: number): Observable<ListeCourses> {
    return this.http.get<ListeCourses>(this.appConfig.backEndUrl + "listeCourse/" + id);
  }

  create(listeCourse: ListeCourses) {
    this.http.post<ListeCourses>(this.appConfig.backEndUrl + "listeCourse", listeCourse).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(listeCourse: ListeCourses): Observable<ListeCourses> {
    return this.http.put<ListeCourses>(this.appConfig.backEndUrl + "listeCourse/" + listeCourse.id, listeCourse);
  }

  deleteById(id: number) {
    this.http.delete(this.appConfig.backEndUrl + "listeCourse/" + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<ListeCourses>>(this.appConfig.backEndUrl + "listeCourse").subscribe(resp => {
      this.listeCourses = resp;
    }, error => console.log(error))
  }
}
