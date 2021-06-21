import java.io.Serializable;
/**
 * Implementa el manejo de un recurso
 * 
 * @author () 
 * @version (10/ 06/ 2021)
 */
public class Recurso implements Serializable
{
    // Identificador del recurso
    int idRecurso;
    // Descripcion del recurso (Lapicero, Hoja de papel, etc.)
    String descripcionRecurso;
    
    /**
     * Constructor de la clase Recurso
     *
     * @param idRecurso El identificador del recurso.
     * @param descripcionRecurso La descripcion del recurso.
     * 
     */
    public Recurso(int idRecurso, String descripcionRecurso){
        this.idRecurso = idRecurso; //Recibimos el numero 
        this.descripcionRecurso = descripcionRecurso; //Material que deseamos
    }
    
    /**
     * Método getRecursos
     * @return this.idRecurso: Devuelve el id del recurso que se encuetra en la
     * variable
     */
    public int getIdRecurso(){
        return this.idRecurso;
    }
    
    /**
     * Método ToString
     * @return this.idRecurso... : Devuelve el id del recurso junto con su descripcion
     */
    public String toString(){
        return this.idRecurso + " " + this.descripcionRecurso; 
    }
    
    /**
     * Método getDescripcionRecurso
     * @return this.descripcionRecurso: Devuelve la descripcion del recurso que se encuetra en la
     * variable se encuentra en la variable
     */
    public String getDescripcionRecurso(){
        return this.descripcionRecurso;
    }
    
        /**
     * Método setRecurso
     * @param id: Es el id que se le desea asignar al recurso mediante este
     * metodo
     */
        public void setIdRecurso(int id){
        this.idRecurso = id;
    }
    
    /**
     * Método setDescripcionRecurso
     * @param String descripcion: Es la descripcion que se le desea asignar al
     * recurso mediante este metodo
     */    
    public void setDescripcionRecurso(String descripcion){
        this.descripcionRecurso = descripcion; 
    }
}