import { Component, OnInit } from '@angular/core';
import {ConnexionDTO} from "../model/ConnexionDTO";
import {IngredientHttpService} from "../ingredient/ingredient-http.service";
import {ConnexionDtoHttpService} from "./connexion-dto-http.service";

@Component({
  selector: 'app-connexion-dto',
  templateUrl: './connexion-dto.component.html',
  styleUrls: ['./connexion-dto.component.scss']
})
export class ConnexionDTOComponent implements OnInit {
  conn:ConnexionDTO;

  constructor(private connexionService: ConnexionDtoHttpService) {

  }

  connexion(){
    console.log(this.conn)
    this.connexionService.connexionAuth(this.conn).subscribe(resp=>{
      sessionStorage.setItem("utilisateur",JSON.stringify(resp));
    })

  }

  ngOnInit(): void {
  }

}
