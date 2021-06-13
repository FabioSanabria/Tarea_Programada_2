
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * Implementa el manejo de una tarea
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public double cantidadSemanasTrabajador(double estimacionTiempoTarea,double estimacionEsfuerzoTarea){
        double semanas = 0;
        semanas = (double)(estimacionTiempoTarea / estimacionEsfuerzoTarea);
        return semanas; 
    }
    
    /**
     * Metodo antecersorTarea 
     * @param idTarea: El usurio da el id de la tarea antecesora
     */
    public void antecesorTarea(int idTarea){
        antecesorasTarea.add(idTarea);
        System.out.println("Esta tarea depende de la terea " + idTarea);
    }
    
    //Bosquejo(No completo)
    public void proxy(String estadoTarea, int idTarea){
        String proxy;
        if(estadoTarea.equals("Finalizado")){
            System.out.println("Perfecto, la tarea puede iniciar de una vez ");
            proxy = "";
        }
        else if(estadoTarea.equals("Por hacer") || estadoTarea.equals("Haciendo")){
            System.out.println("La tarea requiere de una antecesora, creando proxy...");
            proxy = "*Material necesario para hacer la tarea*";
        }
    }
}
