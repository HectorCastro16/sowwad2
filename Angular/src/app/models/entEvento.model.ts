import { entCategoriaEvento } from './entCategoriaEvento.model'
import { entTipoEvento } from './entTipoEvento.model'
import { entModalidadEvento } from './entModalidadEvento.model'
import { entUbicacionEvento } from './entUbicacionEvento.model'
export class entEvento {
        
    // EVE_ID
    public eve_Id: number;
    // EVE_CODIGO
    public eve_Codigo: string;
    // EVE_LINK_SITE_OFICIAL
    public eve_Link_Site_oficial: string;
    // EVE_LUGAR
    public eve_Lugar: string;
    // EVE_ORGANIZADOR
    public eve_Organizador: string;
    // EVE_FECHA
    public eve_Fecha: Date;
    // EVE_HORA
    public eve_Hora: string;
    // EVE_VISUALIZAR
    public eve_Visualizar: boolean;
    // EVE_DESCRIPCION
    public eve_Descripcion: string;
    // CATEGORIAEVENTO
    public categoriaEvento: entCategoriaEvento;
    // TIPOEVENTO
    public tipoEvento: entTipoEvento;
    // MODALIDADEVENTO
    public modalidadEvento: entModalidadEvento;
    // UBICACIONEVENTO
    public ubicacionEvento: entUbicacionEvento;		

    constructor(){
        this.eve_Id = 0;
        this.eve_Codigo = "";
        this.eve_Link_Site_oficial = "";
        this.eve_Lugar = "";
        this.eve_Organizador = "";
        this.eve_Fecha = new Date();
        this.eve_Hora = "";
        this.eve_Visualizar = false;
        this.eve_Descripcion = "";
        this.categoriaEvento = new entCategoriaEvento();
        this.tipoEvento = new entTipoEvento();
        this.modalidadEvento = new entModalidadEvento();
        this.ubicacionEvento = new entUbicacionEvento();
    }
}