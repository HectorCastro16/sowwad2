export class entTipoUsuario {
        
    // TIPUSU_ID
    public tipUsu_Id: number;
    // TIPUSU_CODIGO
    public tipUsu_Codigo: string;
    // TIPUSU_NOMBRE
    public tipUsu_Nombre: string;
    // TIPUSU_DESCRIPCION
    public tipUsu_Descripcion: string;
    // TIPUSU_ESTADO
    public tipUsu_Estado: boolean;		

    constructor(){
        this.tipUsu_Id = 0;
        this.tipUsu_Codigo = "";
        this.tipUsu_Nombre = "";
        this.tipUsu_Descripcion = "";
        this.tipUsu_Estado = false;
    }
}