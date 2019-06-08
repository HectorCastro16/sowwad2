import { Component, OnInit } from '@angular/core';
import { CategoriaEventoService } from 'src/app/services/categoria-evento.service';
import { ActivatedRoute, Router } from '@angular/router';
import { entCategoriaEvento } from 'src/app/models/entCategoriaEvento.model';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-categoria-evento-detalle',
  templateUrl: './categoria-evento-detalle.component.html',
  styleUrls: ['./categoria-evento-detalle.component.css']
})
export class CategoriaEventoDetalleComponent implements OnInit {

  tipoEdicion: number;
  ce: entCategoriaEvento = new entCategoriaEvento();
  mostrar: boolean = false;

  constructor(private activated: ActivatedRoute,
    private router: Router,
    private serviceCategoria: CategoriaEventoService) { }

  ngOnInit() {
    console.log("lleg0a");
    this.activated.params.subscribe(
      dato => {
        console.log(""+dato.id);
        if (dato.id) {
          this.serviceCategoria.getCategoria(dato.id).subscribe(
            (resp) => {
              this.ce = resp;
              this.tipoEdicion = 2;
              this.mostrar = true;
            },
            (error) => {
              console.log(error);
            },
            () => { }
          );
        } else {
          this.tipoEdicion = 1;
        }
      }
    );
  }

  grabarNG(forma: NgForm) {
    if (forma.valid) {
      if (this.tipoEdicion === 1) {
        this.serviceCategoria.insCategoria(this.ce).subscribe(
          (resp) => {
            this.router.navigate(['/categoriaEvento']);
            Swal.fire({
              //position: 'top-end',
              type: 'success',
              title: 'Tu trabajo ha sido guardado.',
              showConfirmButton: false,
              timer: 3000
            })
          },
          (error) => {
            console.log(error);
          },
          () => {

          }
        );
      } else if (this.tipoEdicion === 2) {
        this.serviceCategoria.updCategoria(this.ce).subscribe(
          (resp) => {
            this.router.navigate(['/categoriaEvento']);
            Swal.fire({
              //position: 'top-end',
              type: 'success',
              title: 'Tu trabajo ha sido guardado.',
              showConfirmButton: false,
              timer: 3000
            })
          },
          (error) => {
            console.log(error);
          },
          () => {

          }
        );
      }
    }
  }

}
