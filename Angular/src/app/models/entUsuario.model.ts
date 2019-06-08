import { entTipoUsuario } from './entTipoUsuario.model'
import { entPersona } from './entPersona.model'

export class entUsuario {
    
    // USU_ID
    public usu_Id: number;
    // USU_CODIGO
    public usu_Codigo: string;
    // PERSONA
    public persona: entPersona;
    // TIPO_USUARIO
    public tipo_Usuario: entTipoUsuario;
    // USU_LOGIN
    public usu_Login: string;
    // USU_PASSWORD
    public usu_Password: string;
    // USU_ESTADO
    public usu_Estado: string;
    // USU_FECHAHASTA
    public usu_FechaHasta: Date;
    // USU_FECHAREGISTRO
    public usu_FechaRegistro: Date;
    // USU_USUARIOREGISTRO
    public usu_usuarioRegistro: string;
    // USU_FECHAMODIFICACION
    public usu_FechaModificacion: Date;
    // USU_USUARIOMODIFICACION
    public usu_usuarioModificacion: string;
   		
    constructor(){
        this.usu_Id = 0;
        this.usu_Codigo = "";
        this.persona = new entPersona();
        this.tipo_Usuario = new entTipoUsuario();
        this.usu_Login = "";
        this.usu_Password = "";
        this.usu_Estado = "";
        this.usu_FechaHasta = new Date();
        this.usu_FechaRegistro = new Date();
        this.usu_usuarioRegistro = "";
        this.usu_FechaModificacion = new Date();
        this.usu_usuarioModificacion = "";
    } 
    
}