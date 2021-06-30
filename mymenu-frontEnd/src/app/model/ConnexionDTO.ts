export class ConnexionDTO{
  email : string;
  username : string;
  password : string;

  constructor(username? :string, password? : string){
    this.username=username!;
    this.password=password!;
  }
}
