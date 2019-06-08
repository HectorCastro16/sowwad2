import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-vacio',
  templateUrl: './vacio.component.html',
  styleUrls: ['./vacio.component.css']
})
export class VacioComponent implements OnInit {

  constructor(private activated:ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.activated.params.subscribe(
      dato=>{
        if(dato.from == 'te'){
          this.router.navigate(['/tipoEvento'])
        }else if(dato.from == 'me'){
          this.router.navigate(['/modalidadEvento'])
        }else if(dato.from == 'ce'){
          this.router.navigate(['/categoriaEvento'])
        }
      }
    );
  }

}
