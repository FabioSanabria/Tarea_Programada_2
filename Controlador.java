
/**
 * Implementa un contraldor o programa principal
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controlador
{
    GestorListas gestorListas;
    
    public Controlador(){
        this.gestorListas = new GestorListas();
    }
    
    public void poblaRecursos(){
        String rutaArchivoRecursos = "recursos.txt";
        gestorListas.poblaRecursos(rutaArchivoRecursos);
    }
    
    public void poblaColaboradores(){
        String rutaArchivoColaboradores = "colaboradores.txt";
        gestorListas.poblaColaboradores(rutaArchivoColaboradores);
    }
    
    public void poblaListas(){
        String rutaArchivoListas = "listas.txt";
        gestorListas.poblaListas(rutaArchivoListas);
    }
    
    public void poblaTareas(){
        String rutaArchivoTareas = "tareas.txt";
        gestorListas.poblaTareas(rutaArchivoTareas);
    }
    
    public void consultaRecursos(){
        System.out.print(gestorListas.consultaRecursos());
    }
    
    public void consultaColaboradores(){
        System.out.print(gestorListas.consultaColaboradores());
    }
    
    public void consultaListas(){
        System.out.print(gestorListas.consultaListas());
    }
    
    public void consultaListasCompletas(){
        System.out.print(gestorListas.consultaListasCompletas());
    }
    
    public static void main(String args[]){
        Controlador controlador = new Controlador();
        controlador.poblaRecursos();
        controlador.consultaRecursos();
        controlador.poblaColaboradores();
        controlador.consultaColaboradores();
        controlador.poblaListas();
        controlador.consultaListas();
        controlador.poblaTareas();
        controlador.consultaListas();
        //controlador.consultaListasCompletas();
        
    }
    
    
    
}
