import { Component, OnInit } from '@angular/core';
import { entUbicacionEvento } from '../../models/entUbicacionEvento.model';
import { Router } from '@angular/router';
import { TipoEventoService } from '../../services/tipo-evento.service'
import { CategoriaEventoService } from '../../services/categoria-evento.service';
import { ModalidadEventoService } from 'src/app/services/modalidad-evento.service';
import { entEvento } from 'src/app/models/entEvento.model';
import { entTipoEvento } from 'src/app/models/entTipoEvento.model';
import { entModalidadEvento } from 'src/app/models/entModalidadEvento.model';
import { entCategoriaEvento } from 'src/app/models/entCategoriaEvento.model';
import { NgForm } from '@angular/forms';
import { UbicacionService } from 'src/app/services/ubicacion.service';
import { EventoService } from 'src/app/services/evento.service';
import { last } from '@angular/router/src/utils/collection';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-evento',
  templateUrl: './evento.component.html',
  styleUrls: ['./evento.component.css']
})
export class EventoComponent implements OnInit {

  constructor(private tipoEvento: TipoEventoService,
    private categoriaEvento: CategoriaEventoService,
    private modalidadEvento: ModalidadEventoService,
    private ubicacionService: UbicacionService,
    private eventoService: EventoService,
    private router: Router) 
    { }

  evento: entEvento = new entEvento();

  te: entTipoEvento[];
  me: entModalidadEvento[];
  ce: entCategoriaEvento[];
  
  ubicacion = new entUbicacionEvento();
  resUbi = new entUbicacionEvento();
  // google maps zoom level
  zoom: number = 15;
  
  // initial center position for the map
  lat: number = -8.11042241305952;
  lng: number = -79.02746381361459;  

  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`)
  }
  
  mapClicked(event) {
    this.markers = [];
    this.markers.push({
      lat: event.coords.lat,
      lng: event.coords.lng,
      draggable: true
    });
    console.log(this.markers[0]);
    this.ubicacion.ubiEve_Latitud = this.markers[0].lat.toString();
    this.ubicacion.ubiEve_Longitud = this.markers[0].lng.toString();
    console.log(this.ubicacion);
  }
  
  markerDragEnd(m: marker, $event: MouseEvent) {
    console.log('dragEnd', m, $event);
  }
  
  markers: marker[] = [
	  {
		  lat: -8.11042241305952,
		  lng: -79.02746381361459,
		  label: '',
		  draggable: true
	  }
  ]

  ngOnInit() {
    this.ubicacion.ubiEve_Latitud = this.lat.toString();
    this.ubicacion.ubiEve_Longitud = this.lng.toString();
    this.tipoEvento.listarTipoEvento().subscribe(
      (resp) => {
        //this.tipousuario = resp;
        console.log(resp);
        this.te = resp;
      }
    );

    this.categoriaEvento.listarCategoriaEvento().subscribe(
      (resp) => {
        //this.tipousuario = resp;
        console.log(resp);
        this.ce = resp;
      }
    );

    this.modalidadEvento.listarModalidadEvento().subscribe(
      (resp) => {
        //this.tipousuario = resp;
        console.log(resp);
        this.me = resp;
      }
    );
  }
  
  grabarNG(forma: NgForm){
    //inserta ubicación
    this.ubicacionService.insUbicacion(this.ubicacion).subscribe(
      (resp)=>{
        console.log(resp);
        this.resUbi = resp;
        //inserta evento
        this.evento.ubicacionEvento.ubiEve_Id = this.resUbi.ubiEve_Id;
        this.eventoService.insEvento(this.evento,1).subscribe(
          (resp)=>{
            this.router.navigate(['/welcome/evento']);
            Swal.fire({
              //position: 'top-end',
              type: 'success',
              title: 'Tu trabajo ha sido guardado.',
              showConfirmButton: false,
              timer: 3000
            })
            console.log(resp);
          },
          (error)=>{
            console.log("ERROR" , error);
          },
          ()=>{
            console.log("Termino insEvento desde EventoComponent");
          }
        );

      },
      (error)=>{
        console.log("ERROR" , error);
      },
      ()=>{
        console.log("Termino insUbicacion desde EventoComponent");
      }
    );
    

  }

}
// just an interface for type safety.
interface marker {
	lat: number;
	lng: number;
	label?: string;
	draggable: boolean;
}
