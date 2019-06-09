import { BrowserModule } from '@angular/platform-browser';
import { NgModule,ApplicationRef } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { IniciarSesionComponent } from './componets/iniciar-sesion/iniciar-sesion.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { WelcomeComponent } from './componets/welcome/welcome.component';
import { HeaderComponent } from './componets/header/header.component';
import { FooterComponent } from './componets/footer/footer.component';
import { EventoComponent } from './componets/evento/evento.component';

import { AgmCoreModule } from '@agm/core';
import { IndexComponent } from './componets/index/index.component';
import { CategoriaEventoComponent } from './componets/categoria-evento/categoria-evento.component';
import { ModalidadEventoComponent } from './componets/modalidad-evento/modalidad-evento.component';
import { TipoEventoComponent } from './componets/tipo-evento/tipo-evento.component';
import { ViewEventsComponent } from './componets/view-events/view-events.component';
import { TipoEventoDetalleComponent } from './componets/tipo-evento-detalle/tipo-evento-detalle.component';
import { ModalidadEventoDetalleComponent } from './componets/modalidad-evento-detalle/modalidad-evento-detalle.component';
import { CategoriaEventoDetalleComponent } from './componets/categoria-evento-detalle/categoria-evento-detalle.component';
import { VacioComponent } from './componets/comunes/vacio/vacio.component';

@NgModule({
  declarations: [
    AppComponent,
    IniciarSesionComponent,
    WelcomeComponent,
    HeaderComponent,
    FooterComponent,
    EventoComponent,
    IndexComponent,
    CategoriaEventoComponent,
    ModalidadEventoComponent,
    TipoEventoComponent,
    ViewEventsComponent,
    TipoEventoDetalleComponent,
    ModalidadEventoDetalleComponent,
    CategoriaEventoDetalleComponent,
    VacioComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule, 
    AgmCoreModule.forRoot({
      apiKey: ''
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
