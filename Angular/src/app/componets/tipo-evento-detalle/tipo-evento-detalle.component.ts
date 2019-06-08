import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { entTipoEvento } from 'src/app/models/entTipoEvento.model';
import { TipoEventoService } from 'src/app/services/tipo-evento.service';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-tipo-evento-detalle',
  templateUrl: './tipo-evento-detalle.component.html',
  styleUrls: ['./tipo-evento-detalle.component.css']
})
export class TipoEventoDetalleComponent implements OnInit {
  
  tipoEdicion: number;
  te:entTipoEvento = new entTipoEvento();
  mostrar:boolean = false;

  constructor(private activated: ActivatedRoute,
    private router:Router,
    private serviceTipoUsuario:TipoEventoService) { }

  ngOnInit() {
    this.activated.params.subscribe(
      dato =>{
        if(dato.id){
          this.serviceTipoUsuario.getTipoEvento(dato.id).subscribe(
            (resp)=>{
              this.te = resp;
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
          this.serviceTipoUsuario.insTipoEvento(this.te).subscribe(
            (resp)=>{
              this.router.navigate(['/tipoEvento']);
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
          this.serviceTipoUsuario.updTipoEvento(this.te).subscribe(
            (resp)=>{
              this.router.navigate(['/tipoEvento']);
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
