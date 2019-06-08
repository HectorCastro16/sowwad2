export class entPersona {
        
    // PER_ID
    public per_Id: number;
    // PER_CODIGO
    public per_Codigo: string;
    // PER_NOMBRES
    public per_Nombres: string;
    // PER_APELLIDOS
    public per_Apellidos: string;
    // PER_DNI
    public per_DNI: string;
    // PER_CELULAR
    public per_Celular: string;
    // PER_TELEFONO
    public per_Telefono: string;
    // PER_CORREO
    public per_Correo: string;
    // PER_DIRECCION
    public per_Direccion: string;
    // PER_FOTO
    public per_Foto: string;
    // PER_FECHANACIMIENTO
    public per_FechaNacimiento: Date;
    // PER_LUGARNACIMIENTO
    public per_LugarNacimiento: string;		

    constructor(){
        this.per_Id = 0;
        this.per_Codigo = "";
        this.per_Nombres = "";
        this.per_Apellidos = "";
        this.per_DNI = "";        
        this.per_Celular = "";
        this.per_Telefono = "";
        this.per_Correo = "";
        this.per_Direccion = "";
        this.per_Foto = "";
        this.per_FechaNacimiento = new Date(); //revisar tipo date en servicios
        this.per_LugarNacimiento = "";
    }
}