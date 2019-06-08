import { Component, OnInit } from '@angular/core';
import { entUsuarioRequest } from '../../models/entUsuarioRequest.model';
import { InicioSesionService } from '../../services/inicio-sesion.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.css']
})
export class IniciarSesionComponent implements OnInit {

  user = new entUsuarioRequest();
  status:boolean = false;
  errorMessage: string = "";

  constructor(private inicioSesion: InicioSesionService, private router: Router) { }

  ngOnInit() {
  }

  aunteticar(forma: NgForm){
    console.log(this.user);
    this.inicioSesion.aunteticar(this.user).subscribe((resp: any) =>{
      console.log(resp);
      //localStorage.setItem("token",JSON.stringify(resp.token));
      //localStorage.setItem("imagen",JSON.stringify(resp.rutaimagen));
      this.status = true;
      this.inicioSesion.setStatus(this.status)
      this.router.navigate(["/welcome"]);      
    },
    (error) => {
       this.errorMessage = error.error;
       console.log(error); 
      console.log(error.error);      
    },
    () => { 
      console.log("termino"); 
    });
/*
    this.inicioSesion.setStatus(this.status);
    console.log("Estado: -- " + this.status);
    */
  }

}
