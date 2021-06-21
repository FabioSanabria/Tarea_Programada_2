import java.io.Serializable;
/**
 * Implementa el manejo del uso (cantidad) de un recurso para una tarea
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UsoRecurso implements Serializable
{
    // Recurso utilizado
    Recurso recurso;
    // Cantidad solicitada del recurso en una tarea
    double cantidadSolicitadaRecurso;
    // Cantidad asignada del recurso en una tarea
    double cantidadAsignadaRecurso;
    // Porcentaje de asignación del recurso en la tarea
    double porcentajeRecurso;
    
    /**
     * Constructor de la clase UsoRecurso
     * 
     * La cantidadAsignadaRecurso y el porcentajeRecurso se inicializan en cero
     * 
     * @param idRecurso El identificador del recurso.
     * @param cantidadSolicitadaRecurso La cantidad solicitada del recurso
     * 
     */
    public UsoRecurso(Recurso recurso, double cantidadSolicitadaRecurso){
        this.recurso = recurso;
        this.cantidadSolicitadaRecurso = cantidadSolicitadaRecurso;
        this.cantidadAsignadaRecurso = 0;
        this.porcentajeRecurso = 0;
    }
    
    // Métodos get y set
    public Recurso getRecurso(){
        return this.recurso;
    }
    
    public double getCantidadSolicitadaRecurso(){
        return this.cantidadSolicitadaRecurso;
    }
    
    public double getCantidadAsignadaRecurso(){
        return this.cantidadAsignadaRecurso;
    }
    
    public double getPorcentajeRecurso(){
        return this.porcentajeRecurso;
    }
    
    public void setIdRecurso(Recurso recurso){
        this.recurso = recurso;
    }
    
    public void setCantidadSolicitadaRecurso(double cantidadSolicitadaRecurso){
        this.cantidadSolicitadaRecurso = cantidadSolicitadaRecurso;
        this.porcentajeRecurso = (this.cantidadAsignadaRecurso / this.cantidadSolicitadaRecurso) * 100;
    }
    
    public void setCantidadAsignadaRecurso(double cantidadAsignadaRecurso){
        this.cantidadAsignadaRecurso = cantidadAsignadaRecurso;
        this.porcentajeRecurso = (this.cantidadAsignadaRecurso / this.cantidadSolicitadaRecurso) * 100;
    }
    
    public String toString(){
        return this.recurso + " solicitó " + this.cantidadSolicitadaRecurso + ". Se le asignó " + this.cantidadAsignadaRecurso 
               +  " (" + this.porcentajeRecurso + "%)";  
    }
    
}
