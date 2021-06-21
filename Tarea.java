import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Iterator;
/**
 * Implementa el manejo de una tarea
 * 
 * @author Maria Paula Oviedo B85836, Kendaly Grijalba C03523, Fabio Sanabria C07194 
 * @version (Version 3)
 */

public class Tarea implements Serializable
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

        this.estadoTarea = "Por hacer" ;  
        
        this.responsables = new ArrayList<>();
        
        this.recursosTarea = new ArrayList<>();
        
        this.antecesorasTarea= new ArrayList<>();
    }
    
    public String toString(){
        String resultado = "";
        resultado += this.idTarea + " " + this.nombreTarea + "\n" + 
                    "    Fecha inicio estimada: " + this.fechaInicioEstimadaTarea.getTime() + "\n" + 
                    "    Fecha fin estimada: " + this.fechaFinEstimadaTarea.getTime() + "\n" +
                    "    Fecha inicio real: " + this.fechaInicioRealTarea.getTime()  + "\n" + 
                    "    Fecha fin real: " + this.fechaFinRealTarea.getTime() + "\n" + 
                    "    Estimacion dinero: " + this.estimacionDineroTarea + "\n" + 
                    "    Estimacion esfuerzo: " + this.estimacionEsfuerzoTarea + "\n" +
                    "    Estimacion tiempo: " + this.estimacionTiempoTarea + "\n" + 
                    "    Grado de avance: " + this.gradoAvanceTarea + "\n" + 
                    "    Estado: " + this.estadoTarea + "\n" +
                    "    Responsables:\n"; 
        for(ColaboradorTiempo colaboradorTiempo:this.responsables){
            resultado += "      " + colaboradorTiempo + "\n";
        } 
        resultado += "    Recursos:\n"; 
        for(UsoRecurso usoRecurso:this.recursosTarea){
            resultado += "      " + usoRecurso + "\n";
        } 
        resultado += "    Antecesoras:\n";
        for(int antecesora:this.antecesorasTarea){
            resultado += "      Tarea #" + antecesora + "\n";
        } 
        return resultado;
    }
    
    public int getIdTarea(){
        return this.idTarea;
    }
    
    public String getNombreTarea(){
        return this.nombreTarea;
    }
    
    public double getEstimacionTiempoTarea(){
        return this.estimacionTiempoTarea;
    }
    
    public double getEstimacionEsfuerzoTarea(){
        return this.estimacionEsfuerzoTarea;
    }
    
    public double getEstimacionDineroTarea(){
        return this.estimacionDineroTarea;
    }
    
    public double getGradoAvanceTarea(){
        return this.gradoAvanceTarea;
    }
    
    public GregorianCalendar getFechaInicioEstimadaTarea(){
        return this.fechaInicioEstimadaTarea;
    }
    
    public GregorianCalendar getFechaFinEstimadaTarea(){
        return this.fechaFinEstimadaTarea;
    }
    
    public ArrayList<Integer> getAntecesorasTarea(){
        return this.antecesorasTarea;
    }
    
    public ArrayList<ColaboradorTiempo> getResponsables(){
        return this.responsables;
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
    
    public boolean esAntecesora(int idTarea){
        int id = 0;
        boolean encontro = false;
        Iterator<Integer> it = this.antecesorasTarea.iterator();
        
        while(it.hasNext() && !encontro){
            id = it.next();
            if(id == idTarea){
                encontro = true;
            }
        }
        return encontro;
    }
    
    /**
     * Metodo agregarAntecesorTarea 
     * @param idTarea: El usuario da el id de la tarea antecesora y lo agrega al array de antecesoras
    */
    public void agregaAntecesora(int IdTareaAntecesora){
        antecesorasTarea.add(IdTareaAntecesora);
    }
    
    /**
     * Metodo agregaResponsable 
     * @param idColaborador: El usuario da el id del Colaborador Tiempo y lo agrega al array de responsables
    */
    public void agregaResponsable(Colaborador colaborador){
        ColaboradorTiempo colaboradorTiempo = new ColaboradorTiempo(colaborador);
        this.responsables.add(colaboradorTiempo);
        //Actualizar los tiempos semanales de cada colaborador
        double horasPorSemana = 40.0; // Se asume que cada colaborador tiene 40 horas semanales
        double semanasPorColaborador = this.estimacionTiempoTarea / (this.responsables.size() * horasPorSemana);
        for(ColaboradorTiempo colaboradorT:responsables){
            colaboradorT.setSemanasColaborador(semanasPorColaborador);
        }
    }
    
    /**
     * Metodo agregaRecurso 
     * @param IdRecurso: El usuario da el id Recurso y lo agrega al array de recursosTarea
    */
    public void agregaRecurso(Recurso recurso, double cantidadSolicitadaRecurso){
        UsoRecurso usoRecurso = new UsoRecurso(recurso,cantidadSolicitadaRecurso);
        this.recursosTarea.add(usoRecurso);
    }
    
    /**
     * Metodo borraAntecesora 
     * @param idTareaAntecesora: ID que el usuario desea eliminar del array antecesor
    */
    public void borraAntecesora(int idTareaAntecesora){
        int id = 0;
        boolean encontro = false;
        Iterator<Integer> it = this.antecesorasTarea.iterator();
        
        while(it.hasNext() && !encontro){
            id = it.next();
            
            if(id == idTareaAntecesora){
                encontro = true;
                int indice = antecesorasTarea.indexOf(id);
                antecesorasTarea.remove(indice);
            }
        }
    }
    
    /**
     * Metodo borraRecurso 
     * @param idUsoRecurso: ID que el usuario desea eliminar del array antecesor
    */
    public void borraRecurso(int idRecurso){
        UsoRecurso usoRecurso = null;
        boolean encontro = false;
        Iterator<UsoRecurso> it = this.recursosTarea.iterator();
        
        while(it.hasNext() && !encontro){
            usoRecurso = it.next();
            
            if(usoRecurso.getRecurso().getIdRecurso() == idRecurso){
                encontro = true;
                int indice = recursosTarea.indexOf(usoRecurso);
                recursosTarea.remove(indice);
            }
        }
    }
    
    /**
     * Metodo borraResponsable 
     * @param idColaborador: ID que el usuario desea eliminar del array de responsables
    */
    public void borraResponsable(int idColaborador){
        ColaboradorTiempo colaboradorTiempo = null;
        boolean encontro = false;
        Iterator<ColaboradorTiempo> it = this.responsables.iterator();
        
        while(it.hasNext() && !encontro){
            colaboradorTiempo = it.next();
            
            if(colaboradorTiempo.getColaborador().getIdColaborador() == idColaborador){
                encontro = true;
                int indice = responsables.indexOf(colaboradorTiempo);
                responsables.remove(indice);
            }
        }
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
    
    /**
     * Metodo setsetFechaInicioRealTarea 
     * @param fechaInicioRealTarea
     * Establece un nuevo inicio real de la tarea
    */
    public void setFechaInicioRealTarea(GregorianCalendar fechaInicioRealTarea){
        this.fechaInicioRealTarea = fechaInicioRealTarea;
    }
    
    public void setGradoAvanceTarea(double gradoAvanceTarea){
        this.gradoAvanceTarea = gradoAvanceTarea;
    }
    
    /**
     * Metodo setsetFechaFinRealTarea 
     * @param fechaFinRealTarea
     * Establece un nuevo final real de la tarea
    */
    public void setFechaFinRealTarea(GregorianCalendar fechaFinRealTarea){
        this.fechaFinRealTarea = fechaFinRealTarea;
    }    
    
    public void setResponsables(ArrayList<ColaboradorTiempo> responsables){
        this.responsables = responsables;
    }
    
    public UsoRecurso encuentraUsoRecurso(int idRecurso){
        UsoRecurso recursoBuscado = null;
        boolean encontro = false;
        Iterator<UsoRecurso> it = this.recursosTarea.iterator();
        
        while(it.hasNext() && !encontro){
            recursoBuscado = it.next();
            if(recursoBuscado.getRecurso().getIdRecurso() == idRecurso){
                encontro = true;
            }
        }
        
        if(!encontro){
            recursoBuscado = null;
        }
        
        return recursoBuscado;
    }   
}