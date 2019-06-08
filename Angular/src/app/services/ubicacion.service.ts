import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment'
import { entUbicacionEvento } from '../models/entUbicacionEvento.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UbicacionService {

  constructor(private http: HttpClient) { }

  insUbicacion(ubi: entUbicacionEvento) : Observable<any>{
    const cadena = JSON.stringify(ubi);
    let hd = new HttpHeaders();
    hd = hd.set("Content-Type","application/json");
    return this.http.post(environment.urlBackend + "ubi/insertarUbi",cadena,{ headers: hd }); 
  }
}
