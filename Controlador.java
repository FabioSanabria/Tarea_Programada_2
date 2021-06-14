import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Implementa un contraldor o programa principal
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Controlador
{
    GestorListas gestorListas;

    /**
     * Constructor de la clase Controlador
     * 
     * Inicializa el objeto gestorListas
     * 
     */
    public Controlador(){
        this.gestorListas = new GestorListas();
    }

    /**
     * Poblar recursos desde un archivo 
     */
    public void poblaRecursos(){
        String rutaArchivoRecursos = "recursos.txt";
        this.gestorListas.poblaRecursos(rutaArchivoRecursos);
    }

    /**
     * Poblar colaboradores desde un archivo 
     */
    public void poblaColaboradores(){
        String rutaArchivoColaboradores = "colaboradores.txt";
        this.gestorListas.poblaColaboradores(rutaArchivoColaboradores);
    }

    /**
     * Poblar listas desde un archivo 
     */
    public void poblaListas(){
        String rutaArchivoListas = "listas.txt";
        this.gestorListas.poblaListas(rutaArchivoListas);
    }

    /**
     * Poblar tareas desde un archivo 
     */
    public void poblaTareas(){
        String rutaArchivoTareas = "tareas.txt";
        this.gestorListas.poblaTareas(rutaArchivoTareas);
    }

    /**
     * Consultar los recursos del gestor
     */
    public void consultaRecursos(){
        System.out.print(this.gestorListas.consultaRecursos());
    }

    /**
     * Consultar los colaboradores del gestor
     */
    public void consultaColaboradores(){
        System.out.print(this.gestorListas.consultaColaboradores());
    }

    /**
     * Consultar las listas del gestor
     */
    public void consultaListas(){
        System.out.print(this.gestorListas.consultaListas());
    }

    // public void consultaListasCompletas(){
        // System.out.print(this.gestorListas.consultaListasCompletas());
    // }

    /**
     * Guarda el gestor de listas en un archivo
     */
    public void guardaGestorListas(){
        String rutaArchivoGestorL = "gestorListas.dat";
        FileOutputStream fileOutputStream = null;  
        ObjectOutputStream objectOutputStream = null;   

        // Abre un stream de escritura de archivos
        try{
            fileOutputStream = new FileOutputStream(rutaArchivoGestorL);    
        }catch (IOException e){
            System.out.println("Fallo al abrir FileOutputStream");
        }

        // Abre un stream de escritura de objetos
        try{
            objectOutputStream = new ObjectOutputStream(fileOutputStream); 
            // Escribe el objeto de gestor de listas
            objectOutputStream.writeObject(this.gestorListas);                          
            objectOutputStream.close();                                     
        }catch (IOException e){
            System.out.println("Fallo al escribir ObjectOutputStream");
        }

    }

    /**
     * Carga el gestor de listas en un archivo
     */
    public void cargaGestorListas(){
        String rutaArchivoGestorL = "gestorListas.dat";
        FileInputStream fileInputStream =null;
        
        // Abre un stream de lectura de archivos y otro stream de lectura de objetos
        try{
            fileInputStream = new FileInputStream (rutaArchivoGestorL);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // Lee el objeto de gestor de listas
            this.gestorListas = (GestorListas) objectInputStream.readObject(); 
        }catch (IOException e){
            System.out.println("Fallo al leer FileInputStream");
        }   
        catch (ClassNotFoundException e){
            System.out.println("Clase errónea");
        }
    }

    /**
     * Controla que las opciones de un menú sean válidas
     * 
     * @param valorMenor El valor menor de las opciones
     * @param valorMayor El valor mayor de las opciones
     * @param menu El menu
     * @return opcionDigitada La opción válida digitada por el usuario
     * 
     */
    public int controlaMenu(int valorMenor, int valorMayor, String menu){
        int opcionDigitada=-1;
        boolean opcionValida;   
        do{
            opcionValida=false; 
            try{
                opcionDigitada = Integer.parseInt(JOptionPane.showInputDialog(menu + "\nValor debe estar entre [" + 
                        valorMenor + "," + valorMayor + "] ?"));
                if ((opcionDigitada >= valorMenor) && (opcionDigitada <= valorMayor)){
                    opcionValida = true;   
                }else{
                    JOptionPane.showMessageDialog(null, "Valor fuera de rango. Intente de nuevo");
                }
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debe dar número válido");
            }
        } while (!opcionValida);
        return opcionDigitada;
    }

    /**
     * Controla el menú del programa
     */
    public void menuControlador(){
        String menu = "1.Poblar recursos\n2.Poblar colaboradores\n3.Poblar listas\n4.Poblar tareas\n" +
            "5.Ver los recursos\n6.Ver los colaboradores\n7.Ver listas\n8.Guardar el gestor de listas\n" +
            "9.Cargar el gestor de listas\n10.Salir";
        int opcionDigitada;
        do{
            opcionDigitada = controlaMenu(1,10,menu);
            switch (opcionDigitada) {
                case 1: poblaRecursos();
                break;
                case 2: poblaColaboradores();
                break;
                case 3: poblaListas();
                break;
                case 4: poblaTareas();
                break;
                case 5: consultaRecursos();
                break;
                case 6: consultaColaboradores();
                break;
                case 7: consultaListas();
                break;
                case 8: guardaGestorListas();
                break;
                case 9: cargaGestorListas();
                break;
                default:
            }
        }while(opcionDigitada != 10);
    }

    public static void main(String args[]){
        Controlador controlador = new Controlador();
        controlador.menuControlador();
    }

}
