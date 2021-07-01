import { Component, OnInit } from '@angular/core';
import {ConnexionDTO} from "../model/ConnexionDTO";
import {IngredientHttpService} from "../ingredient/ingredient-http.service";
import {ConnexionDtoHttpService} from "./connexion-dto-http.service";
import {Router} from "@angular/router";
import {AppConfigService} from "../app-config.service";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-connexion-dto',
  templateUrl: './connexion-dto.component.html',
  styleUrls: ['./connexion-dto.component.scss']
})
export class ConnexionDTOComponent implements OnInit {
  conn:ConnexionDTO=new ConnexionDTO('newUser','','');

  constructor(private router: Router, private connexionService: ConnexionDtoHttpService,private appService:AppConfigService, private sessionService: SessionService) {

  }

  connexion(){
    console.log(this.conn)
    this.connexionService.connexionAuth(this.conn).subscribe(resp=>{
      this.sessionService.setSession(resp);
      this.router.navigateByUrl(this.appService.frontEndUrl+["/profil-utilisateur"],{ skipLocationChange: true });
      this.router.navigate(["/profil-utilisateur"]);
    }, error => {
      console.log(error);
      this.router.navigate(["/connexion"]);
    })

  }

  ngOnInit(): void {
  }

}
