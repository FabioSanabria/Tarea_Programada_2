import java.util.ArrayList;

/**
 * Implementa el manejo de una lista
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lista
{
    // Identificador de la lista
    int idLista;
    // Nombre de la lista
    String nombreLista;
    // Descripcion de la lista
    String descripcionLista;
    // Categoria de la lista 
    String categoriaLista;
    // Conjunto de tareas contenidas en la lista (Compras, Revisiones, Remodelacion, etc.)
    ArrayList<Tarea> tareas;
    
    
    /**
     * Constructor de la clase Lista
     * 
     * El conjunto de tareas se crea vacío.
     * @param idLista El identificador de la lista.
     * @param nombreLista El nombre de la lista.
     * @param descripcionLista La descripcion de la lista.
     */
    public Lista(int idLista, String nombreLista, String categoriaLista){
        this.idLista = idLista;
        this.nombreLista = nombreLista;
        this.descripcionLista = descripcionLista;
        this.tareas = new ArrayList<>();
    }
    
    // Métodos get y set
    /**
     * @return El identificador de la lista.
     */
    public int getIdLista()
    {
        return this.idLista;
    }
    
    // Métodos de la clase
    
}
