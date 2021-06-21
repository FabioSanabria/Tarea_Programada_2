import java.io.Serializable;
/**
 * Implementa el manejo del tiempo asignado a una tarea de un colaborador
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ColaboradorTiempo implements Serializable
{
    // Colaborador
    Colaborador colaborador;
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
    public ColaboradorTiempo(Colaborador colaborador){
        this.colaborador = colaborador;
        this.semanasColaborador = 0;
    }
    
    // Métodos get y set
    
    public Colaborador getColaborador(){
        return this.colaborador;
    }
    
    public double getSemanasColaborador(){
        return this.semanasColaborador;
    }
    
    public void setIdColaborador(Colaborador colaborador){
        this.colaborador = colaborador;
    }
    
    public void setSemanasColaborador(double semanasColaborador){
        this.semanasColaborador = semanasColaborador;
    }
    
    public String toString(){
        return this.colaborador + " dedica " + this.semanasColaborador + " semanas" ;  
    }
}
