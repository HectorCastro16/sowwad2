export class entTipoEvento {
        
    // TIPEVE_ID
    public tipEve_Id: number;
    // TIPEVE_CODIGO
    public tipEve_Codigo: string;
    // TIPEVE_NOMBRE
    public tipEve_Nombre: string;
    // TIPEVE_DESCRIPCION
    public tipEve_Descripcion: string;
    // TIPEVE_ESTADO
    public tipEve_Estado: boolean;		

    constructor(){
        this.tipEve_Id = 0;
        this.tipEve_Codigo = "";
        this.tipEve_Nombre = "";
        this.tipEve_Descripcion = "";
        this.tipEve_Estado = false;
    }

}