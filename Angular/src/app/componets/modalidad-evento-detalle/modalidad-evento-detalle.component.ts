import { Component, OnInit } from '@angular/core';
import { entModalidadEvento } from 'src/app/models/entModalidadEvento.model';
import { ModalidadEventoService } from 'src/app/services/modalidad-evento.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-modalidad-evento-detalle',
  templateUrl: './modalidad-evento-detalle.component.html',
  styleUrls: ['./modalidad-evento-detalle.component.css']
})
export class ModalidadEventoDetalleComponent implements OnInit {

  tipoEdicion: number;
  me:entModalidadEvento = new entModalidadEvento();
  mostrar:boolean = false;

  constructor(private activated: ActivatedRoute,
    private router:Router,
    private serviceModalidad: ModalidadEventoService) { }

  ngOnInit() {
    this.activated.params.subscribe(
      dato =>{
        if(dato.id){
          this.serviceModalidad.getModalidad(dato.id).subscribe(
            (resp)=>{
              this.me = resp;
              this.tipoEdicion = 2;
              this.mostrar = true;
            },
            (error)=>{
              console.log(error);
            },
            ()=>{}
          );
        }else{
          this.tipoEdicion = 1;
        }
      }
    );
  }

  grabarNG(forma: NgForm){
    if(forma.valid){
      if(this.tipoEdicion === 1){
        this.serviceModalidad.insModalidad(this.me).subscribe(
          (resp)=>{
            this.router.navigate(['/modalidadEvento']);
            Swal.fire({
              //position: 'top-end',
              type: 'success',
              title: 'Tu trabajo ha sido guardado.',
              showConfirmButton: false,
              timer: 3000
            })
          },
          (error)=>{
            console.log(error);
          },
          ()=>{

          }
        );
      }else if(this.tipoEdicion === 2){
        this.serviceModalidad.updModalidad(this.me).subscribe(
          (resp)=>{
            this.router.navigate(['/modalidadEvento']);
            Swal.fire({
              //position: 'top-end',
              type: 'success',
              title: 'Tu trabajo ha sido guardado.',
              showConfirmButton: false,
              timer: 3000
            })
          },
          (error)=>{
            console.log(error);
          },
          ()=>{
            
          }
        );
      }
    }
}

}
