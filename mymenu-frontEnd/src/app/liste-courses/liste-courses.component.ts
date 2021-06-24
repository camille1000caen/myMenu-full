import { Component, OnInit } from '@angular/core';
import {ListeCourses} from "../model/listeCourses";
import {ListeCoursesHttpService} from "./liste-Courses-http.service";

@Component({
  selector: 'app-liste-courses',
  templateUrl: './liste-courses.component.html',
  styleUrls: ['./liste-courses.component.scss']
})
export class ListeCoursesComponent implements OnInit {

  listeCoursesForm: ListeCourses=null;

  constructor(private listeCoursesService : ListeCoursesHttpService) { }

  ngOnInit(): void {
  }

  list(): Array<ListeCourses> {
    return this.listeCoursesService.findAll();
  }

  add() {
    this.listeCoursesForm = new ListeCourses();
  }

  edit(id: number) {
    this.listeCoursesService.findById(id).subscribe(resp=> {
      this.listeCoursesForm = resp;
    }, err => console.log(err));


  }

  save() {
    if (!this.listeCoursesForm.id) {
      this.listeCoursesService.create(this.listeCoursesForm);
    } else {
      this.listeCoursesService.modify(this.listeCoursesForm).subscribe(resp => {
        this.listeCoursesService.load();
      }, error => console.log(error));
    }
    this.listeCoursesForm = null;
  }

  cancel() {
    this.listeCoursesForm = null;
  }

  delete(id: number) {
    this.listeCoursesService.deleteById(id);
  }

}
