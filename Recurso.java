/**
 * Implementa el manejo de un recurso
 * 
 * @author () 
 * @version (10/ 06/ 2021)
 */
public class Recurso
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
     * Metodo getRecursos
     * @return this.idRecurso: Devuelve el id del recurso que se encuetra en la
     * variable
     */
    public int getIdRecurso(){
        return this.idRecurso;
    }
    
    /**
     * Metodo getDescripcionRecurso
     * @return this.descripcionRecurso: Devuelve la descripcion del recurso que se encuetra en la
     * variable se encuentra en la variable
     */
    public String getDescripcionRecurso(){
        return this.descripcionRecurso;
    }
    
        /**
     * Metodo setRecurso
     * @param id: Es el id que se le desea asignar al recurso mediante este
     * metodo
     */
        public void setIdRecurso(int id){
        this.idRecurso = id;
    }
    
    /**
     * Metodo set_DescripcionRecurso
     * @param String descripcion: Es la descripcion que se le desea asignar al
     * recurso mediante este metodo
     */    
    public void setDescripcionRecurso(String descripcion){
        this.descripcionRecurso = descripcion; 
    }
}