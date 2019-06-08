import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment'
import { Observable } from 'rxjs';
import { entEvento } from '../models/entEvento.model';

@Injectable({
  providedIn: 'root'
})
export class EventoService {

  constructor(private http: HttpClient) { }

insEvento(eve:entEvento,tipEdi: number){
  const cadena = JSON.stringify(eve);
  let hd = new HttpHeaders();
  hd = hd.set("Content-Type","application/json");
  console.log(cadena);
  return this.http.post(environment.urlBackend + "eve/crudEve/"+tipEdi,cadena,{ headers: hd });
}

}
