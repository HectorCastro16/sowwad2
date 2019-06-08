import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment'
import { entCategoriaEvento } from '../models/entCategoriaEvento.model';

@Injectable({
  providedIn: 'root'
})
export class CategoriaEventoService {

  constructor(private http:  HttpClient) { }

  listarCategoriaEvento(): Observable<any>{
    return this.http.get(environment.urlBackend + "cateve/listCatEve");
  }

  getCategoria(id): Observable<any> {
    return this.http.get(environment.urlBackend + "cateve/buscarCatEve/" + id);
  }

  insCategoria(cate: entCategoriaEvento): Observable<any> {
    const cadena = JSON.stringify(cate);
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type", "application/json");
    return this.http.post(environment.urlBackend + "cateve/insertarCatEve", cadena, { headers: hd });
  }

  updCategoria(cate: entCategoriaEvento): Observable<any> {
    const cadena = JSON.stringify(cate);
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type", "application/json");
    return this.http.post(environment.urlBackend + "cateve/actualizaCatEve", cadena, { headers: hd });
  }

  delCategoria(id: number): Observable<any> {
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type", "application/json");
    return this.http.post(environment.urlBackend + "cateve/eliminarCatEve/" + id, null, { headers: hd });
  }
}
