import { Component, OnInit } from '@angular/core';
import { entModalidadEvento } from 'src/app/models/entModalidadEvento.model';
import { Router } from '@angular/router';
import { ModalidadEventoService } from 'src/app/services/modalidad-evento.service';
@Component({
  selector: 'app-modalidad-evento',
  templateUrl: './modalidad-evento.component.html',
  styleUrls: ['./modalidad-evento.component.css']
})
export class ModalidadEventoComponent implements OnInit {

  title: string = 'Registro Modalidad Evento';
  lista: entModalidadEvento[];
  me: entModalidadEvento = new entModalidadEvento();

  constructor(private router: Router,
    private serviceModalidad: ModalidadEventoService) { }

  ngOnInit() {
    this.serviceModalidad.listarModalidadEvento().subscribe(
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
    this.router.navigate(['/modalidadEventoDetalle']);
  }
  
  //verDetalle
  editar(id:number){
    this.router.navigate(['/modalidadEventoDetalle',id]);    
  }

  //verDetalleData
  eliminar(id:number){
    this.serviceModalidad.delModalidad(id).subscribe(
      (resp)=>{
        console.log(resp);        
        this.router.navigate(['/vacio','te']);         
      },
      (error)=>{
        console.log(error);
      },
      ()=>{}
    );
  }

}
