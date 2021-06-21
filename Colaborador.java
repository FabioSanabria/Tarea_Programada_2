import java.io.Serializable;

/**
 * Implementa el manejo de un colaborador
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Colaborador implements Serializable
{
    
     // Identificador del colaborador
    int idColaborador;
    // Nombre del colaborador
    String nombreColaborador;
    
    
    //Método Construcotr
    /**
     * Colaborador
     * @param idColaborador se inicializa la variable para guardar el id del colaborador
     * @param nombreColaborador se inicializa la variable para guardar el nombre del colaborador
     */
    public Colaborador(int IdLista,int idColaborador, String nombreColaborador){
        
        this.idColaborador = idColaborador;
        this.nombreColaborador= nombreColaborador; 
        
    }
    
    //Métodos get y set
    
     
    
    //Método get idColaborador
    /**
     * Método getidColaborador
     * @return this.idColaborado, devuelve el id delcolaborador.
     * 
     */
    public  int  getidColaborador ()
    {
         return this.idColaborador;
    }
    
    //Método getnombreColaborador
    /**
     * Método getnombreColaborador
     * @return this.nombreColaborador, devuelve el nombre del colaborador que se encuentra en la variable
     * 
     */
    public String getnombreColaborador(){
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
    
    /**
     * Imprime los datos del colaborador
     * @return:Retorna los datos del colaborador
     */
    public String toString(){
        return this.idColaborador + " " + this.nombreColaborador; 
    }
}
