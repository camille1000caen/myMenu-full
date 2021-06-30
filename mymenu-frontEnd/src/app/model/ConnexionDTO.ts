export class ConnexionDTO{
  email : string;
  username : string;
  password : string;

  constructor(username? :string, password? : string, email?:string){
    this.username=username!;
    this.password=password!;
    this.email=email!;
  }
}
