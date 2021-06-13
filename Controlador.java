import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

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
        this.gestorListas.poblaRecursos(rutaArchivoRecursos);
    }

    public void poblaColaboradores(){
        String rutaArchivoColaboradores = "colaboradores.txt";
        this.gestorListas.poblaColaboradores(rutaArchivoColaboradores);
    }

    public void poblaListas(){
        String rutaArchivoListas = "listas.txt";
        this.gestorListas.poblaListas(rutaArchivoListas);
    }

    public void poblaTareas(){
        String rutaArchivoTareas = "tareas.txt";
        this.gestorListas.poblaTareas(rutaArchivoTareas);
    }

    public void consultaRecursos(){
        System.out.print(this.gestorListas.consultaRecursos());
    }

    public void consultaColaboradores(){
        System.out.print(this.gestorListas.consultaColaboradores());
    }

    public void consultaListas(){
        System.out.print(this.gestorListas.consultaListas());
    }

    public void consultaListasCompletas(){
        System.out.print(this.gestorListas.consultaListasCompletas());
    }

    public void guardaGestorListas(){
        String rutaArchivoGestorL = "gestorListas.dat";
        FileOutputStream fileOutputStream = null;  
        ObjectOutputStream objectOutputStream = null;   

        try{
            fileOutputStream = new FileOutputStream(rutaArchivoGestorL);    
        }catch (IOException e){
            System.out.println("Fallo al abrir FileOutputStream");
        }

        try{
            objectOutputStream = new ObjectOutputStream(fileOutputStream); 
            objectOutputStream.writeObject(this.gestorListas);                          
            objectOutputStream.close();                                     
        }catch (IOException e){
            System.out.println("Fallo al escribir ObjectOutputStream");
        }

    }

    public void cargaGestorListas(){
        String rutaArchivoGestorL = "gestorListas.dat";
        FileInputStream fileInputStream =null;
        try{
            fileInputStream = new FileInputStream (rutaArchivoGestorL);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.gestorListas = (GestorListas) objectInputStream.readObject(); 
        }catch (IOException e){
            System.out.println("Fallo al leer FileInputStream");
        }   
        catch (ClassNotFoundException e){
            System.out.println("Clase errónea");
        }
    }
    

    public static void main(String args[]){
        Controlador controlador = new Controlador();
        // controlador.poblaRecursos();
        // controlador.consultaRecursos();
        // controlador.poblaColaboradores();
        // controlador.consultaColaboradores();
        // controlador.poblaListas();
        // controlador.consultaListas();
        // controlador.poblaTareas();
        // controlador.consultaListas();
        // controlador.guardaGestorListas();
        controlador.cargaGestorListas();
        controlador.consultaListas();

    }

}
