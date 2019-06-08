export class entModalidadEvento {
        
    // MODEVE_ID
    public modEve_Id: number;
    // MODEVE_CODIGO
    public modEve_Codigo: string;
    // MODEVE_NOMBRE
    public modEve_Nombre: string;
    // MODEVE_DESCRIPCION
    public modEve_Descripcion: string;
    // MODEVE_ESTADO
    public modEve_Estado: boolean;		

    constructor(){
        this.modEve_Id = 0;
        this.modEve_Codigo = "";
        this.modEve_Nombre = "";
        this.modEve_Descripcion = "";
        this.modEve_Estado =false;
    }
}