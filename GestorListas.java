import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Iterator;
/**
 * Implementa un gestor de listas
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class GestorListas
{
    // Conjunto de recursos del gestor
    ArrayList<Recurso> recursos;
    // Conjunto de colaboradores del gestor
    ArrayList<Colaborador> colaboradores;
    // Conjunto de listas del gestor
    ArrayList<Lista> listas;

    /**
     * Constructor de la clase GestorListas
     * 
     * El conjunto de recursos, colaboradores y listas se crea vacío.
     * 
     */
    public GestorListas(){
        this.recursos = new ArrayList<>();
        this.colaboradores = new ArrayList<>();
        this.listas = new ArrayList<>();
    }

    // Métodos get y set
    public ArrayList<Recurso> getRecursos(){
        return this.recursos;
    } 

    public ArrayList<Colaborador> getColaboradores(){
        return this.colaboradores;
    } 

    public ArrayList<Lista> getListas(){
        return this.listas;
    } 

    // Métodos de la clase
    /**
     * Agrega un recurso al conjunto de recursos
     * 
     * @param recurso El recurso que se agrega
     */
    public void agregaRecurso(Recurso recurso){
        this.recursos.add(recurso);
    }

    /**
     * Agrega un colaborador al conjunto de colaboradores
     * 
     * @param colaborador El colaborador que se agrega
     * 
     */
    public void agregaColaborador(Colaborador colaborador){
        this.colaboradores.add(colaborador);
    }

    /**
     * Agrega una lista al conjunto de listas
     * 
     * @param lista La lista que se agrega
     * 
     */
    public void agregaLista(Lista lista){
        this.listas.add(lista);
    }

    /**
     * Crea recursos leyendo los datos de un archivo
     * 
     * @param rutaArchivoRecursos La ruta del archivo con los datos de los recursos
     * 
     */
    public void poblaRecursos(String rutaArchivoRecursos){
        try{
            // Abre el archivo de recursos (Cada línea tiene : <id, descripcion>)
            Scanner scanner = new Scanner(new FileReader(rutaArchivoRecursos));
            while ((scanner.hasNextLine())){
                // Lee cada linea y la descompone en idRecurso y descripcionRecurso
                String hilera = scanner.nextLine();
                String vector[] = hilera.split(",");
                int idRecurso = Integer.parseInt(vector[0]);
                String descripcionRecurso = vector[1];
                // Crea el recurso
                Recurso recurso = new Recurso(idRecurso, descripcionRecurso);
                // Agrega el recurso a la lista
                this.recursos.add(recurso);
            }
        }
        catch(Exception e){System.out.println("Fallo lectura de recursos");}
    }

    /**
     * Crea colaboradores leyendo los datos de un archivo
     * 
     * @param rutaArchivoColaboradores La ruta del archivo con los datos de los colaboradores
     * 
     */
    public void poblaColaboradores(String rutaArchivoColaboradores){
        try{
            // Abre el archivo de colaboradores (Cada línea tiene : <id, nombre>)
            Scanner scanner = new Scanner(new FileReader(rutaArchivoColaboradores));
            while ((scanner.hasNextLine())){
                // Lee cada linea y la descompone en idColaborador y nombreColaborador
                String hilera = scanner.nextLine();
                String vector[] = hilera.split(",");
                int idColaborador = Integer.parseInt(vector[0]);
                String nombreColaborador = vector[1];
                // Crea el recurso
                Colaborador colaborador = new Colaborador(idColaborador, nombreColaborador);
                // Agrega el recurso a la lista
                this.colaboradores.add(colaborador);
            }
        }
        catch(Exception e){System.out.println("Fallo lectura de colaboradores");}
    }

    /**
     * Crea listas leyendo los datos de un archivo
     * 
     * @param rutaArchivoListas La ruta del archivo con los datos de las listas
     * 
     */
    public void poblaListas(String rutaArchivoListas){
        try{
            // Abre el archivo de listas (Cada línea tiene : <id, nombre, descripcion, categoria>)
            Scanner scanner = new Scanner(new FileReader(rutaArchivoListas));
            while ((scanner.hasNextLine())){
                // Lee cada linea y la descompone en idLista, nombreLista, descriocionLista y categoriaLista
                String hilera = scanner.nextLine();
                String vector[] = hilera.split(",");
                int idLista = Integer.parseInt(vector[0]);
                String nombreLista = vector[1];
                String descripcionLista = vector[2];
                String categoriaLista = vector[3];
                // Crea la lista
                Lista lista = new Lista(idLista, nombreLista, descripcionLista, categoriaLista);
                // Agrega el lista
                this.listas.add(lista);
            }
        }
        catch(Exception e){System.out.println("Fallo lectura de listas");}

    }

    /**
     * Busca una lista en listas usando el idLista
     * 
     * @param idLista El id de la lista que se desea encontrar
     * @return lista El objeto lista correspondiente al idLista
     * 
     */
        public Lista encuentraLista(int idLista){
        Lista lista = null;
        boolean encontro = false;
        Iterator<Lista> it = this.listas.iterator();
        
        while(it.hasNext() && !encontro){
            lista = it.next();
            if(lista.getIdLista() == idLista ){
                encontro = true;
            }
        }
        
        if(!encontro){
            lista = null;
        }

        return lista;
    }
    
    
    /**
     * Crea las tareas leyendo los datos de un archivo
     * 
     * @param rutaArchivoTareas La ruta del archivo con los datos de las tareas
     * 
     */
    public void poblaTareas(String rutaArchivoTareas){
        
        try{
            // Abre el archivo de listas 
            //Cada línea tiene: 
            // <idLista, idTarea, nombreTarea, fechaInicioEstimadaTarea, fechaFinEstimadaTarea, estimacionDineroTarea, estimacionEsfuerzoTarea, estimacionTiempoTarea>)
            Scanner scanner = new Scanner(new FileReader(rutaArchivoTareas));
            while ((scanner.hasNextLine())){
                // Lee cada linea y la descompone en idLista, idTarea, nombreTarea, fechaInicioEstimadaTarea, 
                //fechaFinEstimadaTarea, estimacionDineroTarea, estimacionEsfuerzoTarea, estimacionTiempoTarea
                String hilera = scanner.nextLine();
                String vector[] = hilera.split(",");
                int idLista = Integer.parseInt(vector[0]);
                int idTarea = Integer.parseInt(vector[1]);
                String nombreTarea = vector[2];
                
                String fecha[] = vector[3].split("/");
                int dia = Integer.parseInt(fecha[0]);
                int mes = Integer.parseInt(fecha[1]);
                int anno = Integer.parseInt(fecha[2]);
                GregorianCalendar fechaInicioEstimadaTarea = new GregorianCalendar(anno, (mes-1), dia);
                
                fecha = vector[4].split("/");
                dia = Integer.parseInt(fecha[0]);
                mes = Integer.parseInt(fecha[1]);
                anno = Integer.parseInt(fecha[2]);
                GregorianCalendar fechaFinEstimadaTarea = new GregorianCalendar(anno, (mes-1), dia);
                
                Double estimacionDineroTarea = Double.parseDouble(vector[5]);
                Double estimacionEsfuerzoTarea = Double.parseDouble(vector[6]);
                Double estimacionTiempoTarea = Double.parseDouble(vector[7]);
                // Crea la tarea
                Tarea tarea = new Tarea(idTarea, nombreTarea, fechaInicioEstimadaTarea, fechaFinEstimadaTarea, 
                                        estimacionDineroTarea, estimacionEsfuerzoTarea, estimacionTiempoTarea);
                // Busca la lista  para agregar la tarea
                Lista lista = encuentraLista(idLista);
                // Agrega la tarea a la lista 
                if (lista != null)
                    lista.agregaTarea(tarea);
            }
        }
        catch(Exception e){System.out.println("Fallo lectura de listas");}
    }

    /**
     * Consultar los recursos del gestor de listas
     * 
     * @return resultado Los datos de los recursos del gestor de listas
     * 
     */
    public String consultaRecursos(){
        String resultado = "";
        for(Recurso recurso:this.recursos){
            resultado += recurso + "\n";
        }
        return resultado;
    }

    /**
     * Consultar los colaboradores del gestor de listas
     * 
     * @return resultado Los datos de los colaboradores del gestor de listas
     * 
     */
    public String consultaColaboradores(){
        String resultado = "";
        for(Colaborador colaborador:this.colaboradores){
            resultado += colaborador + "\n";
        }
        return resultado;
    }
    
    /**
     * Consultar las listas del gestor de listas
     * 
     * @return resultado Los datos de las listas del gestor de listas
     * 
     */
    public String consultaListas(){
        String resultado = "";
        for(Lista lista:this.listas){
            resultado += lista + "\n";
        }
        return resultado;
    }
    
    /**
     * Consultar las listas con todos sus datos del gestor de listas
     * 
     * @return resultado Los datos de las listas completas del gestor de listas
     * 
     */
    public String consultaListasCompletas(){
        String resultado = "";
        for(Lista lista:this.listas){
            resultado += lista + "\n";
            ArrayList<Tarea> tareas = lista.getTareas();
            for(Tarea tarea:tareas){
                resultado += tarea + "\n";
            }
        }
        return resultado;
    }
}
