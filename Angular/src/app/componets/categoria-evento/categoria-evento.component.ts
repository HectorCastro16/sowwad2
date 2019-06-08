import { Component, OnInit } from '@angular/core';
import { CategoriaEventoService } from 'src/app/services/categoria-evento.service';
import { Router } from '@angular/router';
import { entCategoriaEvento } from 'src/app/models/entCategoriaEvento.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-categoria-evento',
  templateUrl: './categoria-evento.component.html',
  styleUrls: ['./categoria-evento.component.css']
})
export class CategoriaEventoComponent implements OnInit {

  title: string = 'Registro Categoria Evento';
  lista: entCategoriaEvento[];
  ce: entCategoriaEvento = new entCategoriaEvento();

  constructor(private router: Router,
    private serviceCategoria: CategoriaEventoService) { }

  ngOnInit() {
    this.serviceCategoria.listarCategoriaEvento().subscribe(

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
    this.router.navigate(['/categoriaEventoDetalle']);
  }
  
  //verDetalle
  editar(id:number){
    this.router.navigate(['/categoriaEventoDetalle',id]);    
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
        this.serviceCategoria.delCategoria(id).subscribe(
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
