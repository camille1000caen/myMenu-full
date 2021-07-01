import { Injectable } from '@angular/core';
import {Utilisateur} from "./model/utilisateur";

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  utilisateur: Utilisateur;

  constructor() { }

  setSession(utilisateur: Utilisateur) {
    this.utilisateur = utilisateur;
    sessionStorage.setItem("utilisateur",JSON.stringify(utilisateur));

  }

  clearSession() {
    this.utilisateur =null;
    sessionStorage.removeItem("utilisateur");
  }
}
