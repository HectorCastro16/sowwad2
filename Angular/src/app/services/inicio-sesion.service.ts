import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment'
import { entUsuarioRequest } from '../models/entUsuarioRequest.model';

@Injectable({
  providedIn: 'root'
})
export class InicioSesionService {

  auth: boolean = false; 

  constructor(private http: HttpClient) { }

  aunteticar(usu: entUsuarioRequest){
    const cadena = JSON.stringify(usu);
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type","application/json");
    return this.http.post(environment.urlBackend + "usu/verificaAcceso",cadena,{ headers: hd });
  }

  setStatus(status: boolean){
    this.auth = status;
  }
  
  getStatus(status: boolean){
    return this.auth;
  }
}
