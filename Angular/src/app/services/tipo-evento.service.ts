import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment'
import { entTipoEvento } from '../models/entTipoEvento.model';

@Injectable({
  providedIn: 'root'
})
export class TipoEventoService {

  constructor(private http: HttpClient) { }

  listarTipoEvento(): Observable<any> {
    return this.http.get(environment.urlBackend + "tipeve/listTipEve");
  }

  getTipoEvento(id): Observable<any> {
    return this.http.get(environment.urlBackend + "tipeve/buscarTipEve/" + id);
  }

  insTipoEvento(tipEve: entTipoEvento): Observable<any> {
    const cadena = JSON.stringify(tipEve);
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type", "application/json");
    return this.http.post(environment.urlBackend + "tipeve/insertarTipEve", cadena, { headers: hd });
  }

  updTipoEvento(tipEve: entTipoEvento): Observable<any> {
    const cadena = JSON.stringify(tipEve);
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type", "application/json");
    return this.http.post(environment.urlBackend + "tipeve/actualizaTipEve", cadena, { headers: hd });
  }

  delTipoEvento(id: number): Observable<any> {
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type", "application/json");
    return this.http.post(environment.urlBackend + "tipeve/eliminarTipEve/" + id, null, { headers: hd });
    //return this.http.post(environment.urlBackend + "tipeve/eliminarTipEve?id=" + id, null, { headers: hd });
  }

  
}
