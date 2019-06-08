import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment'
import { entModalidadEvento } from '../models/entModalidadEvento.model';

@Injectable({
  providedIn: 'root'
})
export class ModalidadEventoService {

  constructor(private http:  HttpClient) { }

  listarModalidadEvento(): Observable<any>{
    return this.http.get(environment.urlBackend + "modeve/listModalidad");
  }

  getModalidad(id): Observable<any> {
    return this.http.get(environment.urlBackend + "modeve/buscarModalidad/" + id);
  }

  insModalidad(mod: entModalidadEvento): Observable<any> {
    const cadena = JSON.stringify(mod);
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type", "application/json");
    return this.http.post(environment.urlBackend + "modeve/insertarModalidad", cadena, { headers: hd });
  }

  updModalidad(mod: entModalidadEvento): Observable<any> {
    const cadena = JSON.stringify(mod);
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type", "application/json");
    return this.http.post(environment.urlBackend + "modeve/actualizaModalidad", cadena, { headers: hd });
  }

  delModalidad(id: number): Observable<any> {
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type", "application/json");
    return this.http.post(environment.urlBackend + "modeve/eliminarModalidad/" + id, null, { headers: hd });
  }

}
