import { Component, OnInit } from '@angular/core';
import { InicioSesionService } from 'src/app/services/inicio-sesion.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private inisiarsesion: InicioSesionService) { }

  ngOnInit() {
    //console.log(this.inisiarsesion.auth)
  }
}
