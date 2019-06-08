import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipoEventoService } from 'src/app/services/tipo-evento.service';
import { entTipoEvento } from 'src/app/models/entTipoEvento.model';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-tipo-evento',
  templateUrl: './tipo-evento.component.html',
  styleUrls: ['./tipo-evento.component.css']
})
export class TipoEventoComponent implements OnInit {

  title: string = 'Registro Tipo Evento';
  lista: entTipoEvento[];
  te: entTipoEvento = new entTipoEvento();

  constructor(private router: Router,
    private serviceTipoEvento: TipoEventoService) { }

  ngOnInit() {
    this.serviceTipoEvento.listarTipoEvento().subscribe(
      (resp)=>{
          this.lista=resp;
      },
      (error)=>{
        console.log(error);
      },
      ()=>{}
    );
  }

  agregar(){
    //console.log("hizo click");
    this.router.navigate(['/tipoEventoDetalle']);
  }
  
  //verDetalle
  editar(id:number){
    this.router.navigate(['/tipoEventoDetalle',id]);    
  }

  //verDetalleData
  eliminar(id:number){

    Swal.fire({
      title: '¿Estás seguro?',
      text: "¡No podrás revertir esto!",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sí, elimínelo!'
    }).then((result) => {
      if (result.value) {
        this.serviceTipoEvento.delTipoEvento(id).subscribe(
          (resp)=>{
            console.log(resp);        
            this.router.navigate(['/vacio','te']);         
          },
          (error)=>{
            console.log(error);
          },
          ()=>{}
        );
        Swal.fire(
          'Eliminado!',
          'Registro Eliminado.',
          'success'
        )
      }
    })    
  }

}
