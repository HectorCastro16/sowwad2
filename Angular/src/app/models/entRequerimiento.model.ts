import { entEvento } from './entEvento.model'
import { entUsuario } from './entUsuario.model'

export class entRequerimiento {
        
    // REQ_ID
    public req_Id: number;
    // EVENTO
    public evento: entEvento;
    // REQ_CODIGO
    public req_Codigo: string;
    // REQ_FECHA_INICIO
    public req_Fecha_Inicio: Date;
    // REQ_FECHA_FIN
    public req_Fecha_Fin: Date;
    // REQ_ESTADO
    public req_Estado: boolean;
    // REQ_OBSERVACIONES
    public req_Observaciones: string;
    // USU_SOLICITANTE
    public usu_Solicitante: entUsuario;
    // USU_ASIGNADO
    public usu_Asignado: entUsuario;	
    
    constructor() {
        this.req_Id = 0;
        this.evento = new entEvento();
        this.req_Codigo = "";
        this.req_Fecha_Inicio = new Date();
        this.req_Fecha_Fin = new Date();
        this.req_Estado = false;
        this.req_Observaciones = "";
        this.usu_Solicitante = new entUsuario();
        this.usu_Asignado = new entUsuario();
    }
}