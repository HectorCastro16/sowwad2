import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IniciarSesionComponent } from './componets/iniciar-sesion/iniciar-sesion.component';
import { Routes, RouterModule} from '@angular/router'
import { WelcomeComponent } from './componets/welcome/welcome.component';
import { EventoComponent } from './componets/evento/evento.component';
import { IndexComponent } from './componets/index/index.component';
import { TipoEventoComponent } from './componets/tipo-evento/tipo-evento.component';
import { CategoriaEventoComponent } from './componets/categoria-evento/categoria-evento.component';
import { ModalidadEventoComponent } from './componets/modalidad-evento/modalidad-evento.component';
import { TipoEventoDetalleComponent } from './componets/tipo-evento-detalle/tipo-evento-detalle.component';
import { VacioComponent } from './componets/comunes/vacio/vacio.component';
import { CategoriaEventoDetalleComponent } from './componets/categoria-evento-detalle/categoria-evento-detalle.component';
import { ModalidadEventoDetalleComponent } from './componets/modalidad-evento-detalle/modalidad-evento-detalle.component';

const rutas: Routes =  [
  { path: '', component:IndexComponent},
  { path: 'login', component:IniciarSesionComponent},  
  { path: 'welcome', component:WelcomeComponent},
  { path: 'welcome/evento', component:EventoComponent},

  { path: 'welcome/tipoEvento', component:TipoEventoComponent},
  { path: 'welcome/tipoEvento/welcome', component:WelcomeComponent},
  { path: 'tipoEvento', component:TipoEventoComponent},
  { path: 'welcome/categoriaEvento', component:CategoriaEventoComponent},
  { path: 'welcome/categoriaEvento/welcome', component:WelcomeComponent},
  { path: 'categoriaEvento', component:CategoriaEventoComponent},
  { path: 'welcome/modalidadEvento', component:ModalidadEventoComponent},
  { path: 'welcome/modalidadEvento/welcome', component:WelcomeComponent},
  { path: 'modalidadEvento', component:ModalidadEventoComponent},

  { path: 'vacio/:from', component:VacioComponent},

  { path: 'tipoEventoDetalle', component:TipoEventoDetalleComponent},
  { path: 'tipoEventoDetalle/:id', component:TipoEventoDetalleComponent},
  { path: 'categoriaEventoDetalle', component:CategoriaEventoDetalleComponent},
  { path: 'categoriaEventoDetalle/:id', component:CategoriaEventoDetalleComponent},
  { path: 'modalidadEventoDetalle', component:ModalidadEventoDetalleComponent},
  { path: 'modalidadEventoDetalle/:id', component:ModalidadEventoDetalleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(rutas)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
