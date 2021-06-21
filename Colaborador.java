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
    int IdColaborador;
    // Nombre del colaborador
    String nombreColaborador;
    
    
    //Método Construcotr
    /**
     * Colaborador
     * @param idColaborador se inicializa la variable para guardar el id del colaborador
     * @param nombreColaborador se inicializa la variable para guardar el nombre del colaborador
     */
    public Colaborador(int IdColaborador, String nombreColaborador){
        
        this.IdColaborador = IdColaborador;
        this.nombreColaborador= nombreColaborador; 
        
    }
    
    //Métodos get y set
    
     
    
    //Método get IdColaborador
    /**
     * Método getIdColaborador
     * @return this.IdColaborado, devuelve el id delcolaborador.
     * 
     */
    public  int  getIdColaborador ()
    {
         return this.IdColaborador;
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
    
    
    
    //Metodo setIdColaborador
    /**
     * Metodo setIdColaborador
     * @param IdColaborador: Es el id que se le asigna al colaborador mediante este
     * metodo
     */
    public void setIdColaborador(int IdColaborador){
        this.IdColaborador=IdColaborador;
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
        return this.IdColaborador + " " + this.nombreColaborador; 
    }
}
