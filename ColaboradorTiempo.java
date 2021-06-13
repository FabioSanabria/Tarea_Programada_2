import java.io.Serializable;
/**
 * Implementa el manejo del tiempo asignado a una tarea de un colaborador
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ColaboradorTiempo implements Serializable
{
    // Identificador del colaborador
    int idColaborador;
    // Tiempo en semanas que el colaborador dedicará a la tarea (se calcula con base el tiempo estimado de la tarea)
    double semanasColaborador;
    
    /**
     * Constructor de la clase ColaboradorTiempo
     * 
     * La semanasColaborador se asigna inicialmente en 0
     * 
     * @param idColaborador El identificador del colaborador.
     * 
     */
    public ColaboradorTiempo(int idColaborador){
        this.idColaborador = idColaborador;
        this.semanasColaborador = 0;
    }
    
    // Métodos get y set
    
    public int getIdColaborador(){
        return this.idColaborador;
    }
    
    public double getSemanasColaborador(){
        return this.semanasColaborador;
    }
    
    public void setIdColaborador(int idColaborador){
        this.idColaborador = idColaborador;
    }
    
    public void setSemanasColaborador(int semanasColaborador){
        this.semanasColaborador = semanasColaborador;
    }
}
