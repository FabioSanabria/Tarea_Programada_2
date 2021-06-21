import java.util.ArrayList;
import java.io.Serializable;
import java.util.Iterator;

/**
 * Write a description of class Lista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lista implements Serializable
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
    ArrayList < Tarea > tareas;
    // Añade el elemento al ArrayList en la posición 'n'
    

/**
* Constructor de la clase Lista
* 
* El conjunto de tareas se crea vacío.
* @param idLista El identificador de la lista.
* @param nombreLista El nombre de la lista.
* @param descripcionLista La descripción de la lista.
* @param categoriaLista La categoría de la lista
*/
     public Lista ( int  idLista , String  nombreLista ,String descripcionLista, String  categoriaLista ) {
        this.idLista = idLista;
        this.nombreLista = nombreLista;
        this.categoriaLista=categoriaLista;
        this.descripcionLista = descripcionLista;
        this.tareas =  new  ArrayList <> ();
        
    }
    
    // Métodos get y set
    
    //Método get idLista
     /**
     * Método getidLista
     * @return this.idLista, devuelve el id de la lista. 
     */
    public  int  getIdLista ()
    {
         return this.idLista;
    }
    
    //Método get nombreLista
     /**
     * Método getnombreLista
     * @return this.nombreLista, devuelve el nombre de la lista. 
     */
    public  String  getnombreLista ()
    {
          return this.nombreLista;
     }
    
    //Método get categoriaLista
    /**
     * Método getcategoriaLista
     * @return this.categoriaLista, devuelve la categoria de la lista. 
     */
    public  String  getcategoriaLista ()
    {
          return this.categoriaLista;
     }
    
    //Método get descripcionLista
    /**
     * Método getdescripcionLista
     * @return this.descripcionLista, devuelve la descripción de la lista. 
     */
    public  String  getdescripcionLista ()
     {
          return this.descripcionLista;
     }
    
    //Método set idLista
    /**
     * Metodo setidLista 
     * @param idLista: Es el id que se le asigna a la lista mediante este metodo
     */
    public  void  setidLista ()
    {
         this.idLista=idLista;
    }
    
    //Método set nombreLista
    /**
     * Metodo setnombreLista
     * @param nombreLista: Es el nombre que se le asigna a la lista mediante este metodo
     */
    public  void  setnombreLista()
    {
         this.nombreLista=nombreLista;
    }
    
    //Método set categoriaLista
    /**
     * Metodo setcategoriaLista
     * @param categoriaLista: Es la categoria que se le asigna a la lista mediante este metodo.
     */
    public  void setcategoriaLista ()
    {
         this.categoriaLista =categoriaLista;
    }
    
    //Método set descripcionLista
    /**
     * Metodo setdescripcionLista
     * @param descripcionLista: Es la descripcion que se le asigna a la lista mediante este metodo.
     */
     public  void  setdescripcionLista ()
    {
         this.descripcionLista = descripcionLista;
    }
    
    // Métodos de la clase

    /**
    * Busca una tarea en listas usando el idTarea
    * Método encuentraTarea
    * @param idTarea El id de la tarea que se desea encontrar
    * @return tarea Retorna la tarea que usuaio está buscando 
    */
        public Tarea encuentraTarea(int IdTarea){
        Tarea tarea= null;
        boolean encontro = false;
        
        Iterator<Tarea> it = this.tareas.iterator();
        
        while(it.hasNext() && !encontro){
            tarea = it.next();
            if(tarea.getIdTarea() == IdTarea ){
                encontro = true;
            }
        }
        
        if(!encontro){
            tarea = null;
        }

        return tarea;
    }
    
    /**
     *Método esAntecesora
     *@param idTareaAntecesora, El id de la tarea antecesora que es requisito para continuar con otra tarea.
     *@return encontro, Retorna si encuentra una tarea antecesora.
     */
    public boolean esAntecesora(int idTareaAntecesora){
        Tarea tarea= null;
        boolean encontro = false;
        
        Iterator<Tarea> it = this.tareas.iterator();
        
        while(it.hasNext() && !encontro){
            tarea = it.next();
            if(tarea.esAntecesora(idTareaAntecesora)){
                encontro = true;
            }
        }
        
        return encontro;
    }
    
    /**
    * Metodo agregaTarea
    * @param tarea: La tarea que se agrega.
    */
    public void agregaTarea(Tarea tarea){
        this.tareas.add(tarea);
    }
   
    /**
    * Metodo borraRecurso.
    * @param tarea: La tarea que se borra.
    */
    public void borraTarea(Tarea tarea){
      int indice = tareas.indexOf(tarea);
      tareas.remove(tarea);
    }
        
    /**
    * Metodo buscaIdMaximoTarea.
    * @param idMaximoTarea: Se inicializa un id maximo en las tareas.
    * @return idMximoTarea:Retorna el id maximo de las tareas.
    */
    public int buscaIdMaximoTarea(){
        int idMaximoTarea = 0;
        Tarea tarea= null;
        Iterator<Tarea> it = this.tareas.iterator();
        
        while(it.hasNext()){
            tarea = it.next();
            if(tarea.getIdTarea() > idMaximoTarea){
                idMaximoTarea = tarea.getIdTarea();
            }
        }
        
        return idMaximoTarea;
    }
    
    
    /**
     * Método buscaTareaConProxy.
     * @param idTareaProxy: Escibe un idTarea de un proxy y encuentra cual tarea lo tiene de antecesora.
     * @return tarea:Retorna la tarea.
     */
    public Tarea buscaTareaConProxy(int idTareaProxy){
        Tarea tarea= null;
        boolean encontro = false;
        
        Iterator<Tarea> it = this.tareas.iterator();
        
        while(it.hasNext() && !encontro){
            tarea = it.next();
            if(tarea.esAntecesora(idTareaProxy)){
                encontro = true;
            }
        }
        
        return tarea;
    }
    
    /**
    * Método revisarProxy.
    * @param idTarea: Los ids de las tareas que se asocian a los proxys.
    */
    public void revisaProxy(int idTarea){
        //Los ids de proxys asociados a idTarea
        ArrayList<Integer> idProxyPorEliminar = new ArrayList<>();
        
        
        //Revisa todas las tareas
        for(Tarea tarea:tareas){
            //Busca si es un proxy
            if(tarea.getNombreTarea().substring(0,5).equals("Proxy")){
                ArrayList<Integer> antecesorasTarea = tarea.getAntecesorasTarea();
                //Obtiene el id de la tarea original
                int idTareaOriginal = antecesorasTarea.get(0);
                //Si este es un proxy de idTarea
                if(idTareaOriginal == idTarea){
                    //Obtiene el id de la tarea proxy
                    int idTareaProxy = tarea.getIdTarea();
                    //Obtiene el id que tiene como antecesora al proxy
                    Tarea tareaConProxy = buscaTareaConProxy(idTareaProxy);
                    //Restablece la antecesora original(la que se esta finalizando)
                    tareaConProxy.agregaAntecesora(idTarea);
                    //Elimina el proxy como antecesora
                    tareaConProxy.borraAntecesora(idTareaProxy);
                    //Marcar para eliminar luego
                    idProxyPorEliminar.add(idTareaProxy);
                }
            }
        }
        
        for(Integer idProxy:idProxyPorEliminar){
            Tarea tareaEliminar = encuentraTarea(idProxy);
            borraTarea(tareaEliminar);
        }
    }
    
    
    // El toString tiene que tener tres variantes
    /**
    * Imprime los datos del contacto
    * @return resultado: Retorna la lista con sus datos.
    */
    public String toString(){
        String resultado =  "Lista #" + this.idLista + " " + this.nombreLista + " " + this.descripcionLista + " " +
                            this.categoriaLista + "\n";
        for(Tarea tarea:tareas){
            resultado += "  Tarea #" + tarea + "\n";
        }
        return resultado;
    }
    
    /**
    * Método toString
    * @param estadoTarea: El estado de la tarea en que se encuentra.
    * @return resultado: Retorna la lista con el estado de la tarea.
    */
    public String toString(String estadoTarea){
        String resultado =  "Lista #" + this.idLista + " " + this.nombreLista + " " + this.descripcionLista + " " +
                            this.categoriaLista + "\n";
        for(Tarea tarea:tareas){
            if (tarea.getEstadoTarea().equals(estadoTarea))
                resultado += "  Tarea #" + tarea + "\n";
        }
        return resultado;
    }
    

    /**
    * Método toString
    * @param estimacionDineroTarea: Diinero estimado que va a utilzar el trabajador para realizar su tarea
    * @param estimacionEsfuerzoTarea: Tiempo estimado que va a utilzar el trabajador para realizar su tarea
    * @param estimacionTiempoTarea:Tiempo estimado en la que la tarea termina 
    * @param gradoAvanceTarea: El grado de avance en que se encuentra la tarea.
    * @return resultado: Retorna la lista con los datos de estimación,esfuerzo,dinero y grado de la tarea.
    */
    public String toString(double estimacionDineroTarea, double estimacionEsfuerzoTarea,
    double estimacionTiempoTarea, double gradoAvanceTarea){        
        String resultado =  "Lista #" + this.idLista + " " + this.nombreLista + " " + this.descripcionLista +" " +
                            this.categoriaLista + "\n"; 
        
        for(Tarea tarea:tareas){
            boolean dinero = false;
            boolean esfuerzo = false;
            boolean tiempo = false;
            boolean avance = false;
            
            if (estimacionDineroTarea == -1){
                dinero = true;
            }
            else{
                if (tarea.getEstimacionDineroTarea() == estimacionDineroTarea)
                    dinero = true;
                else
                    dinero = false;
                    
            }

            if (estimacionEsfuerzoTarea == -1){
                esfuerzo = true;
            }
            else{
                if (tarea.getEstimacionEsfuerzoTarea() == estimacionEsfuerzoTarea)
                    esfuerzo = true;
                else
                    esfuerzo = false;
                    
            }
            
            if (estimacionTiempoTarea == -1){
                tiempo = true;
            }
            else{
                if (tarea.getEstimacionTiempoTarea() == estimacionTiempoTarea)
                    tiempo = true;
                else
                    tiempo = false;
                    
            }
            
            if (gradoAvanceTarea == -1){
                avance = true;
            }
            else{
                if (tarea.getGradoAvanceTarea() == gradoAvanceTarea)
                    avance = true;
                else
                    avance = false;
                    
            }
            
            if (dinero && esfuerzo && tiempo && avance)
                resultado += "  Tarea #" + tarea + "\n";
        }
        return resultado;                    
    }
    
    
    /**
    * Metodo getTarea
    * @return:Retorna las tareas.
    */
    public ArrayList<Tarea> getTareas(){
        return this.tareas;
    }

}
