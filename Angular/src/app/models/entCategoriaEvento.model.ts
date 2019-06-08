export class entCategoriaEvento {
        
    // CATEVE_ID
    public catEve_Id: number;
    // CATEVE_CODIGO
    public catEve_codigo: string;
    // CATEVE_NOMBRE
    public catEve_Nombre: string;
    // CATEVE_DESCRIPCION
    public catEve_Descripcion: string;
    // CATEVE_ESTADO
    public catEve_estado: boolean;

    constructor(){
        this.catEve_Id = 0;
        this.catEve_codigo = "";
        this.catEve_Nombre = "";
        this.catEve_Descripcion = "";
        this.catEve_estado = false;
    }
}