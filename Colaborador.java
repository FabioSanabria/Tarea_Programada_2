
/**
 * Implementa el manejo de un colaborador
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Colaborador{
    // Identificador del colaborador
    int idColaborador;
    // Nombre del colaborador
    String nombreColaborador;
    
    
 //Método Constructor
    
    /**
    * Colaborador
    * @param idColaborador se inicializa la variable para guardar el id del colaborador
    * @param nombreColaborador se inicializa la variable para guardar el nombre del colaborador
    */
    public Colaborador(int idColaborador, String nombreColaborador){
    this.idColaborador = idColaborador;
    this.nombreColabroador = nombreColaborador;
        
    }
    //Métodos get y set
    
    //Método getidColaborador
    /**
     * Método getidColaborador
     * @return this.idColaborador, devuelve el id del colaborador que se encuentra en la variable
     * 
     */
    public int get_idColaborador(){
        return this.idColaborador;
    }
    
    //Método getnombreColaborador
    /**
     * Método getnombreColaborador
     * @return this.nombreColaborador, devuelve el nombre del colaborador que se encuentra en la variable
     * 
     */
    public String get_nombreColaborador(){
        return this.nombreColaborador;
    }
    
    //Metodo setidColaborador
    /**
     * Metodo setidColaborador
     * @param idColaborador: Es el id que se le asigna al colaborador mediante este
     * metodo
     */
    public void setidColaborador(int idColaborador){
        this.idColaborador=idColaborador;
    }
    
    //Metodo setnombreColaborador
    /** 
     * Metodo setnombreColaborador
     * @param String: Es el nombre se le asigna  al colaborador mediante este
     * metodo
     */
    public void setnombreColaborador(String nombre){
        this.nombreColaborador= nombre;
    }
    

