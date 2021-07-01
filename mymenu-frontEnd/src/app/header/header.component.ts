import { Component, OnInit } from '@angular/core';
import {Utilisateur} from "../model/utilisateur";
import {Route, Router} from "@angular/router";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  constructor(private router: Router, private sessionService: SessionService) {

  }

  ngOnInit(): void {
  }

  utilisateur(): Utilisateur {
    return this.sessionService.utilisateur;
  }


  deconnexion(){
    this.sessionService.clearSession();
    this.router.navigate(["/"]);
      }

}
