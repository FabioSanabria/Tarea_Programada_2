import java.io.Serializable;
/**
 * Implementa el manejo del uso (cantidad) de un recurso para una tarea
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UsoRecurso implements Serializable
{
    // Identificador del recurso utilizado
    int idRecurso;
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
    public void UsoRecurso(int idRecurso, double cantidadSolicitadaRecurso){
        this.idRecurso = idRecurso;
        this.cantidadSolicitadaRecurso = cantidadSolicitadaRecurso;
        this.cantidadAsignadaRecurso = 0;
        this.porcentajeRecurso = 0;
    }
    
    // Métodos get y set
    public int getIdRecurso(){
        return this.idRecurso;
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
    
    public void setIdRecurso(int idRecurso){
        this.idRecurso = idRecurso;
    }
    
    public void setCantidadSolicitadaRecurso(double cantidadSolicitadaRecurso){
        this.cantidadSolicitadaRecurso = cantidadSolicitadaRecurso;
        this.porcentajeRecurso = (this.cantidadAsignadaRecurso / this.cantidadSolicitadaRecurso) * 100;
    }
    
    public void setCantidadAsignadaRecurso(double cantidadAsignadaRecurso){
        this.cantidadAsignadaRecurso = cantidadAsignadaRecurso;
        this.porcentajeRecurso = (this.cantidadAsignadaRecurso / this.cantidadSolicitadaRecurso) * 100;
    }
    
}
