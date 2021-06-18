import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * Implementa el manejo de una tarea
 * 
 * @author Maria Paula Oviedo B85836, Kendaly Grijalba C03523, Fabio Sanabria C07194 
 * @version (Version 3)
 */

public class Tarea
{
    // Identificador de la tarea
    int idTarea;
    // Nombre de la tarea
    String nombreTarea;
    // Fecha de inicio estimada de la tarea
    GregorianCalendar fechaInicioEstimadaTarea;
    // Fecha de fin estimada de la tarea
    GregorianCalendar fechaFinEstimadaTarea;
    // Fecha de inicio real de la tarea
    GregorianCalendar fechaInicioRealTarea;
    // Fecha de fin real de la tarea
    GregorianCalendar fechaFinRealTarea;
    // Estimación del dinero en colones requerido para la tarea
    double estimacionDineroTarea;
    // Estimación del esfuerzo (de 0 a 10) requerido para la tarea
    double estimacionEsfuerzoTarea;
    // Estimación del tiempo en horas para la tarea (De este tiempo se calculan las semanas de cada colaborador, 40 horas a la semana por colaborador) 
    double estimacionTiempoTarea;
    // Grado de avance de la tarea
    double gradoAvanceTarea;
    // Estado de la tarea (Por hacer, Haciendo, Terminado)
    String estadoTarea;
    // Lista de los responsable (y su asignacion de tiempo en semanas) de la tarea
    ArrayList<ColaboradorTiempo> responsables;
    // Lista de los identificadores, cantidades solicitadas y asignadas de los recursos utilizados de la tarea
    ArrayList<UsoRecurso> recursosTarea;
    // Lista de los identificadores de las tareas antecesoras de la tarea
    ArrayList<Integer> antecesorasTarea;
    
    /**
     * Constructor de la clase Tarea
     *
     * @param idTarea El identificador de la tarea 
     * @param nombreTarea Nombre de la tarea.
     * @param fechaInicioEstimadaTarea Fecha en la cual se piensa que va a iniciar la tarea
     * @param fechaFinEstimadaTarea Fecha en la cual se piensa que va a terminar la tarea
     * @param fechaInicioRealTarea Fecha real y fija en la que inicia la tarea
     * @param fechaFinRealTarea Fecha real y fija en la que termina la tarea
     * @param estimacionDineroTarea Recurso que se va a utilizar para terminar la tarea
     * @param estimacionEsfuerzoTarea Tiempo estimado que va a utilzar el trabajador para realizar su tarea
     * @param estimacionTiempoTarea La estimacion de tiempo en la que se va a durar haciendo la tarea
     * @param gradoAvanceTarea El avance que se haya hecho con respecto a la tarea 
     * @param estadoTarea El estado que tiene la tarea, ya sea Terminada, en Proceso o Por hacer
     */
        public Tarea(int idTarea, String nombreTarea, GregorianCalendar fechaInicioEstimadaTarea,
        GregorianCalendar fechaFinEstimadaTarea, double estimacionDineroTarea,
        double estimacionEsfuerzoTarea, double estimacionTiempoTarea){
        this.idTarea = idTarea;
        
        this.nombreTarea = nombreTarea;
    
        this.fechaInicioEstimadaTarea = fechaInicioEstimadaTarea;
    
        this.fechaFinEstimadaTarea = fechaFinEstimadaTarea;
   
        this.fechaInicioRealTarea = this.fechaInicioEstimadaTarea;
   
        this.fechaFinRealTarea = this.fechaFinEstimadaTarea;
    
        this.estimacionDineroTarea = estimacionDineroTarea;
    
        this.estimacionEsfuerzoTarea = estimacionEsfuerzoTarea;
   
        this.estimacionTiempoTarea = estimacionTiempoTarea;

        this.gradoAvanceTarea = 0;

        this.estadoTarea = "Por Hacer" ;        
    }
    
    /**
     * Metodo ToString()
     * @return Todos los valores descritos anteriormente en el constructor junto con algunas palabras mas para que el usuario
     * logre entender que es cada variable devuelta
     */
    public String ToString(){
    
        return "El nombre de la tarea es " + nombreTarea + "\nEl id de la tarea es " + idTarea + 
        "\nSu fecha de inicio estimada es de " + fechaInicioEstimadaTarea + "\nLa fecha estimada de fin de la tarea es " + fechaFinEstimadaTarea +
        "\nSu fecha de inicio real es " + fechaInicioRealTarea + "\nSu fecha de fin real es " + fechaFinRealTarea + 
        "El dinero estimado para esta tarea es " + estimacionDineroTarea + "\nEl esfuerzo estimado para esta tarea es " + estimacionEsfuerzoTarea + 
        "\nLa estimacion del tiempo de la tarea es " + estimacionTiempoTarea + "\nEl grado de avance de esta es " + gradoAvanceTarea +
        "\nEl estado de esta tarea es " + estadoTarea;
    }
    
    /**
     * Metodo cantidadSemanasTrabajador(double estimacionTiempoTarea,double estimacionEsfuerzoTarea)
     * @param double estimacionTiempoTarea: Tiempo estimado en la que la tarea termina 
     * @param double estimacionEsfuerzoTarea: Tiempo estimado que va a utilzar el trabajador para realizar su tarea
     * @return double semanas: La cantidad de semanas totales en la que el trabajador termina la tarea
     */
    public double cantidadSemanasTrabajador(double estimacionTiempoTarea,double estimacionEsfuerzoTarea){
        double semanas = 0;
        semanas = (double)(estimacionTiempoTarea / estimacionEsfuerzoTarea);
        return semanas; 
    }
    
    /**
     * Metodo agregarAntecesorTarea 
     * @param idTarea: El usuario da el id de la tarea antecesora y lo agrega al array de antecesoras
    */
    public void agregaAntecesora(int IdTareaAntecesora){
        antecesorasTarea.add(IdTareaAntecesora);
        System.out.println("La tarea "+ this.idTarea + "depende de la tarea " + IdTareaAntecesora);
    }
    
    /**
     * Metodo agregaResponsable 
     * @param idColaborador: El usuario da el id del Colaborador Tiempo y lo agrega al array de responsables
    */
    public void agregaResponsable(ColaboradorTiempo idColaborador){
        responsables.add(idColaborador);
        System.out.println("Se ha agregado exitosamente el colaborador");
    }
    
    /**
     * Metodo agregaRecurso 
     * @param IdRecurso: El usuario da el id Recurso y lo agrega al array de recursosTarea
    */
    public void agregaRecurso(UsoRecurso IdRecurso){
        recursosTarea.add(IdRecurso);
        System.out.println("Se ha agregado exitosamente el recurso");
    }
    
    /**
     * Metodo borraAntecesora 
     * @param idTareaAntecesora: ID que el usuario desea eliminar del array antecesor
    */
    public void borraAntecesora(int idTareaAntecesora){
        System.out.println("Eliminando tarea " + idTareaAntecesora + " del array");
        antecesorasTarea.remove(idTareaAntecesora);
    }
    
    /**
     * Metodo borraRecurso 
     * @param idUsoRecurso: ID que el usuario desea eliminar del array antecesor
    */
    public void borraRecurso(int idUsoRecurso){
        System.out.println("Eliminando recurso " + idUsoRecurso + " del array");
        recursosTarea.remove(idUsoRecurso);
    }
    
    /**
     * Metodo borraResponsable 
     * @param idColaborador: ID que el usuario desea eliminar del array de responsables
    */
    public void borraResponsable(int idColaborador){
        System.out.println("Eliminando colaborador tiempo " + idColaborador + " del array");
        responsables.remove(idColaborador);
    } 
    
    /**
     * Metodo setEstadoTarea 
     * @param estadoTarea: Es el estado de la tarea en la que se encuentra ya sea finalizada, Por hacer o En progreso
    */
    public void setEstadoTarea(String estadoTarea){
        this.estadoTarea = estadoTarea;    
    }
    
    /**
     * Metodo getEstadoTarea 
     * @return this.estadoTarea: Retorna el estado de la tarea en la que se encuentra, ya sea finalizada, Por hacer o En progreso
    */
    public String getEstadoTarea(){
        return this.estadoTarea;
    }
    //Idea de proxy 2.0
    /**
     * Metodo crearProxy 
     * @param estadoTarea: El estado que tiene la tarea, ya sea Terminada, en Proceso o Por hace, el proxy depende de esto
     */
    public Tarea crearProxy(int posicionTarea){
        Tarea proxy;
        if(antecesorasTarea.get(posicionTarea).getEstadoTarea().equals("Finalizado")){
            System.out.println("Perfecto, la tarea puede iniciar de una vez ");
            proxy = new Tarea(0,"",0,0,0,0,0,0,0,0,""); //Revisar el Calendario
        }
        else if(antecesorasTarea.get(posicionTarea).getEstadoTarea().equals("Por hacer") || 
        antecesorasTarea.get(posicionTarea).getEstadoTarea().equals("Haciendo")){
            System.out.println("La tarea requiere de una antecesora, creando proxy...");
            proxy = new Tarea(antecesorasTarea.get(posicionTarea).getInformacionCompleta()); //Pasa los datos de la tarea que no esta terminada
            return proxy;
        }
        return proxy;
    }
}