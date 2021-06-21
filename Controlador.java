import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.util.GregorianCalendar;
import java.util.ArrayList;
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
        System.out.println();
        System.out.println();
        System.out.println("********** CONSULTA RECURSOS **********");
        System.out.println();
        System.out.print(this.gestorListas.consultaRecursos());
    }

    /**
     * Consultar los colaboradores del gestor
     */
    public void consultaColaboradores(){
        System.out.println();
        System.out.println();
        System.out.println("********** CONSULTA COLABORADORES **********");
        System.out.println();
        System.out.print(this.gestorListas.consultaColaboradores());
    }

    /**
     * Consultar las listas del gestor
     */
    public void consultaListas(){
        System.out.println();
        System.out.println();
        System.out.println("********** CONSULTA LISTAS Y TAREAS CON TODOS LOS DATOS **********");
        System.out.println();
        
        System.out.print(this.gestorListas.consultaListas());
        // JTextArea jTextArea = new JTextArea(this.gestorListas.consultaListas());
        // JScrollPane jScrollPane = new JScrollPane(jTextArea);
        // jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // JOptionPane.showMessageDialog(null, jScrollPane);
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
     * Validar los números digitados por un usuario
     */
    public int leeNumeroValido(String mensaje){
        int numeroValido = -1;
        boolean esNumeroValido = false;
        do{
            try {
                numeroValido = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                esNumeroValido = true;
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debe dar número válido");
            }
        }while(!esNumeroValido);
        return numeroValido;
    }

    /**
     * Validar los números (double) digitados por un usuario
     */
    public double leeNumeroDoubleValido(String mensaje){
        double numeroValido = -1.0;
        boolean esNumeroValido = false;
        do{
            try {
                numeroValido = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                esNumeroValido = true;
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debe dar número válido");
            }
        }while(!esNumeroValido);
        return numeroValido;
    }

    /**
     * Agregar un responsable a una tarea
     */
    public void agregaResponsable(){
        int idLista = leeNumeroValido("Digite el id de la lista de la tarea a la que desea agregar un responsable (colaborador): ");
        int idTarea = leeNumeroValido("Digite el id de la tarea a la que desea agregar un responsable (colaborador): ");
        int idColaborador = leeNumeroValido("Digite el id del colaborador que desea agregar a la tarea: ");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                // Busca el colaborador de acuerdo al idColaborador
                Colaborador colaborador = this.gestorListas.encuentraColaborador(idColaborador);
                if (colaborador != null){
                    // Agrega el responsable a la tarea
                    tarea.agregaResponsable(colaborador);  // RECALCULAR EL TIEMPO SEMANAL AQUI O DENTRO DEL METODO
                }
                else{
                    JOptionPane.showMessageDialog(null, "Colaborador inexistente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }

    }

    /**
     * Agregar un recurso a una tarea
     */
    public void agregaRecurso(){
        int idLista = leeNumeroValido("Digite el id de la lista de la tarea a la que desea agregar un recurso: ");
        int idTarea = leeNumeroValido("Digite el id de la tarea a la que desea agregar un recurso: ");
        int idRecurso = leeNumeroValido("Digite el id del recurso que desea agregar a la tarea: ");
        double cantidadSolicitadaRecurso = leeNumeroDoubleValido("Digita la cantidad solicitada del recurso: ");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                // Busca el recurso de acuerdo al idRecurso
                Recurso recurso = this.gestorListas.encuentraRecurso(idRecurso);
                if (recurso != null){
                    // Agrega el recurso y cantidad solicitada a la tarea
                    tarea.agregaRecurso(recurso, cantidadSolicitadaRecurso);  
                }
                else{
                    JOptionPane.showMessageDialog(null, "Recurso inexistente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }

    }

    /**
     * Agregar una antecesora a una tarea
     */
    public void agregaAntecesora(){
        int idLista = leeNumeroValido("Digite el id de la lista de la tarea a la que desea agregar una antecesora: ");
        int idTarea = leeNumeroValido("Digite el id de la tarea a la que desea agregar una antecesora: ");
        int idAntecesora = leeNumeroValido("Digite el id de la tarea antecesora: ");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                // Busca la tarea de acuerdo al idTarea antecesora
                Tarea tareaAntecesora = lista.encuentraTarea(idAntecesora);
                if (tareaAntecesora != null){
                    // Agrega la tarea antecesora
                    tarea.agregaAntecesora(idAntecesora);  
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tarea antecesora inexistente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }

    }
    
    
    
    /**
     * Crear una tarea proxy para iniciar otra tarea que tiene antecesoras que no han finalizado
     * @param tarea El objeto de la tarea que va a iniciarse
     * @param idTareaProxy El id para la tarea proxy
     * @return tareaProxy El objeto con la tarea proxy
     */
    public Tarea creaTareaProxy(Tarea tarea, int idTareaProxy){
        int idTarea = tarea.getIdTarea();
        String nombreTarea = "Proxy de tarea# " + idTarea;
        GregorianCalendar fechaInicioEstimadaTarea = tarea.getFechaInicioEstimadaTarea();
        GregorianCalendar fechaFinEstimadaTarea = tarea.getFechaFinEstimadaTarea();
        double estimacionDineroTarea = tarea.getEstimacionDineroTarea();
        double estimacionEsfuerzoTarea = tarea.getEstimacionEsfuerzoTarea();
        double estimacionTiempoTarea = tarea.getEstimacionTiempoTarea();
        Tarea tareaProxy = new Tarea(idTareaProxy, nombreTarea, fechaInicioEstimadaTarea, fechaFinEstimadaTarea, estimacionDineroTarea,
                                    estimacionEsfuerzoTarea, estimacionTiempoTarea);
        
        tareaProxy.setEstadoTarea("Terminado");
        tareaProxy.setResponsables(tarea.getResponsables());
        
        
        return tareaProxy;
    }
    
    /**
     * Inicia la tarea cambiando el estado a "Haciendo" y cambiando la fecha real de inicio (a la del sistema)
     */
    public void iniciaTarea(){
        int idLista = leeNumeroValido("Digite el id de la lista de la tarea que va a iniciar: ");
        int idTarea = leeNumeroValido("Digite el id de la tarea que va a iniciar: ");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                // REVISAR ANTECESORAS Y CREAR PROXY
                ArrayList<Integer> antecesorasTarea = tarea.getAntecesorasTarea();
                if(antecesorasTarea != null){
                    for(Integer idTareaAntecesora:antecesorasTarea){
                        Tarea tareaAntecesora = lista.encuentraTarea(idTareaAntecesora);
                        if(!tareaAntecesora.getEstadoTarea().equals("Terminado")){
                            //Buscar el id maximo de las tareas actuales
                            int idMaxTarea = lista.buscaIdMaximoTarea();
                            //Asigna el nuevo id para ponerselo al Proxy
                            idMaxTarea++;
                            //Crea la tarea proxy con los datos de la antecesora, pero con estado en "Terminado"
                            Tarea tareaProxy = creaTareaProxy(tareaAntecesora, idMaxTarea);
                            //poner el proxy como antecesora de la tarea
                            tarea.agregaAntecesora(idMaxTarea);
                            // Borra la antecesora que no ha finalizado
                            tarea.borraAntecesora(idTareaAntecesora);
                            //pone la antecesora como antecesora del proxy
                            tareaProxy.agregaAntecesora(idTareaAntecesora);
                            //Agregar la tarea proxy a la lista
                            lista.agregaTarea(tareaProxy);
                        }
                    }
                }
                tarea.setEstadoTarea("Haciendo");
                GregorianCalendar fechaHoy = new GregorianCalendar();
                tarea.setFechaInicioRealTarea(fechaHoy);
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }

    }
    
    
    /**
     * Finaliza la tarea cambiando el estado a "Terminado", cambiando la fecha real de fin (a la del sistema)
     * y cambiando el grado de avance a 100%
     */
    public void finalizaTarea(){
        int idLista = leeNumeroValido("Digite el id de la lista de la tarea que va a finalizar: ");
        int idTarea = leeNumeroValido("Digite el id de la tarea que va a finalizar: ");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                // Busca los proxys asociados a esta tarea y los elimina y actualiza las antecesoras
                lista.revisaProxy(idTarea);
                tarea.setEstadoTarea("Terminado");
                GregorianCalendar fechaHoy = new GregorianCalendar();
                tarea.setFechaFinRealTarea(fechaHoy);
                tarea.setGradoAvanceTarea(100.0);
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }

    }

    /**
     * Consulta las tareas por un estado dado
     */
    public void consultaEstado(){
        // 
        System.out.println();
        System.out.println();
        System.out.println("********** CONSULTA POR ESTADO **********");
        System.out.println();
        System.out.println("**********TAREAS POR HACER (Por lista) **********");
        System.out.println();
        System.out.print(this.gestorListas.consultaListas("Por hacer"));
        System.out.println("********** TAREAS EN CURSO (Por lista) **********");
        System.out.println();
        System.out.print(this.gestorListas.consultaListas("Haciendo"));
        System.out.println("********** TAREAS FINALIZADAS (Por lista) **********");
        System.out.println();
        System.out.print(this.gestorListas.consultaListas("Terminado"));

    }

    /**
     * Consulta las tareas por ciertas condiciones
     */
    public void consultaDinamica(){
        double estimacionDineroTarea = leeNumeroDoubleValido("Digite el valor para la estimación de dinero (-1 si no desea compararlo)"); 
        double estimacionEsfuerzoTarea = leeNumeroDoubleValido("Digite el valor para la estimación de esfuerzo (-1 si no desea compararlo)");
        double estimacionTiempoTarea = leeNumeroDoubleValido("Digite el valor para la estimación de tiempo (-1 si no desea compararlo)");
        double gradoAvanceTarea = leeNumeroDoubleValido("Digite el valor para el grado de avance (-1 si no desea compararlo)");
        
        System.out.println();
        System.out.println();
        System.out.println("********** CONSULTA LISTAS Y TAREAS CON TODOS LOS DATOS (FILTRADOS POR PARAMETROS DINAMICOS) **********");
        System.out.println();
        System.out.print(this.gestorListas.consultaListas(estimacionDineroTarea, estimacionEsfuerzoTarea,
                estimacionTiempoTarea, gradoAvanceTarea));
    }

    /**
     * Agregar una nueva lista al gestor de listas
     */
    public void agregaLista(){
        int idLista = leeNumeroValido("Digite el id de la lista (no repetir un id existente): ");
        String nombreLista = JOptionPane.showInputDialog("Digite el nombre de la lista");
        String descripcionLista = JOptionPane.showInputDialog("Digite la descripcion de la lista");
        String categoriaLista = JOptionPane.showInputDialog("Digite la categoría de la lista");

        Lista lista = new Lista(idLista, nombreLista, descripcionLista, categoriaLista);
        gestorListas.agregaLista(lista);
    }

    /**
     * Agregar una nueva tarea al gestor de listas 
     */
    public void agregaTarea(){
        int idLista = leeNumeroValido("Digite el id de la lista (válido) a la que desea agregar una tarea");
        int idTarea = leeNumeroValido("Digite el id de la tarea por agregar (no repetir un id existente)");
        String nombreTarea = JOptionPane.showInputDialog("Digite el nombre de tarea");
        String fechaInicioET = JOptionPane.showInputDialog("Digite la fecha estimada de inicio (dd/mm/aaaa)");
        String fechaInicioFT = JOptionPane.showInputDialog("Digite la fecha estimada de fin (dd/mm/aaaa)");
        double estimacionDineroTarea = leeNumeroDoubleValido("Digite la estimación de dinero (colones)");
        double estimacionEsfuerzoTarea = leeNumeroDoubleValido("Digite la estimación de esfuerzo (de 1 a 10)");
        double estimacionTiempoTarea = leeNumeroDoubleValido("Digite la estimación de tiempo (horas)");

        //Transformar las fechas
        String fecha[] = fechaInicioET.split("/");
        int dia = Integer.parseInt(fecha[0]);
        int mes = Integer.parseInt(fecha[1]);
        int anno = Integer.parseInt(fecha[2]);
        GregorianCalendar fechaInicioEstimadaTarea = new GregorianCalendar(anno, (mes-1), dia);

        fecha = fechaInicioFT.split("/");
        dia = Integer.parseInt(fecha[0]);
        mes = Integer.parseInt(fecha[1]);
        anno = Integer.parseInt(fecha[2]);
        GregorianCalendar fechaFinEstimadaTarea = new GregorianCalendar(anno, (mes-1), dia);

        // Crear  y agregar la tarea
        Tarea tarea = new Tarea(idTarea, nombreTarea, fechaInicioEstimadaTarea, fechaFinEstimadaTarea, 
                estimacionDineroTarea, estimacionEsfuerzoTarea, estimacionTiempoTarea);

        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            lista.agregaTarea(tarea);
        }
    }

    /**
     * Cambiar la cantidad asignada de un recurso y por lo tanto su % de asignación
     */
    public void cambiaCantidadAsignadaRecurso(){
        int idLista = leeNumeroValido("Digite el id de la lista de la tarea a la que desea cambiar la asignación del recurso");
        int idTarea = leeNumeroValido("Digite el id de la tarea a la que desea cambiar la asignación del recurso");
        int idRecurso = leeNumeroValido("Digite el id del recurso al que desea cambiar la asignación: ");
        double cantidadAsignadaRecurso = leeNumeroDoubleValido("Digite la nueva cantidad asignada: ");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                // Busca el usoRecurso de acuerdo al idRecurso
                UsoRecurso usoRecurso = tarea.encuentraUsoRecurso(idRecurso);
                if (usoRecurso != null){
                    // Cambiar la cantidad asignada a un recurso y su % de asignación
                    usoRecurso.setCantidadAsignadaRecurso(cantidadAsignadaRecurso);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Recurso inexistente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }

    }

    /**
     * Cambiar el grado de avance de una tarea
     */
    public void cambiaGradoAvance(){
        int idLista = leeNumeroValido("Digite el id de la lista de la tarea a la que cambiará el grado de avance");
        int idTarea = leeNumeroValido("Digite el id de la tarea a la que cambiará el grado de avance");
        double gradoAvanceTarea = leeNumeroDoubleValido("Digite el nuevo grado de avance");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                tarea.setGradoAvanceTarea(gradoAvanceTarea);
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }
    }

    /**
     * Borrar una lista del gestor de listas
     */
    public void borraLista(){
        int idLista = leeNumeroValido("Digite el id de la lista que desea borrar: ");
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null)
            this.gestorListas.borraLista(lista);
        else 
            JOptionPane.showMessageDialog(null, "Lista inexistente");
    }

    /**
     * Borrar una tarea de una lista del gestor de listas 
     */
    public void borraTarea(){
        int idLista = leeNumeroValido("Digite el id de la lista de la tarea que desea borrar: ");
        int idTarea = leeNumeroValido("Digite el id de la tarea que desea borrar: ");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                if (!lista.esAntecesora(idTarea)){
                    lista.borraTarea(tarea);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se puede borrar es antecesora");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }

    }

    /**
     * Borrar un recurso de una tarea  
     */
    public void borraRecurso(){

        int idLista = leeNumeroValido("Digite el id de la lista de la tarea de la que desea borrar un recurso: ");
        int idTarea = leeNumeroValido("Digite el id de la tarea de la que desea borrar un recurso: ");
        int idRecurso = leeNumeroValido("Digite el id del recurso que desea borrar: ");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                // Busca el recurso de acuerdo al idColaborador
                Recurso recurso = this.gestorListas.encuentraRecurso(idRecurso);
                if (recurso != null){
                    // Borra el recurso
                    tarea.borraRecurso(idRecurso);  
                }
                else{
                    JOptionPane.showMessageDialog(null, "Recurso inexistente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }

    }

    /**
     * Borrar un responsable de una tarea  
     */
    public void borraResponsable(){
        int idLista = leeNumeroValido("Digite el id de la lista de la tarea de la que desea borrar un responsable (colaborador): ");
        int idTarea = leeNumeroValido("Digite el id de la tarea de la que desea borrar un responsable (colaborador): ");
        int idColaborador = leeNumeroValido("Digite el id del colaborador que desea borrar de la tarea: ");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                // Busca el colaborador de acuerdo al idColaborador
                Colaborador colaborador = this.gestorListas.encuentraColaborador(idColaborador);
                if (colaborador != null){
                    // Borra el responsable a la tarea
                    tarea.borraResponsable(idColaborador);  // RECALCULAR EL TIEMPO SEMANAL AQUI O DENTRO DEL METODO
                }
                else{
                    JOptionPane.showMessageDialog(null, "Colaborador inexistente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }

    }

    /**
     * Borrar una tarea antecesora de una tarea 
     */
    public void borraAntecesora(){
        int idLista = leeNumeroValido("Digite el id de la lista de la tarea de la que desea borrar una antecesora: ");
        int idTarea = leeNumeroValido("Digite el id de la tarea de la que desea borrar una antecesora: ");
        int idAntecesora = leeNumeroValido("Digite el id de la tarea antecesora: ");

        // Busca la lista de acuerdo al idLista
        Lista lista = this.gestorListas.encuentraLista(idLista);
        if (lista != null){
            // Busca la tarea de acuerdo al idTarea
            Tarea tarea = lista.encuentraTarea(idTarea);
            if (tarea != null){
                // Busca la tarea de acuerdo al idTarea antecesora
                Tarea tareaAntecesora = lista.encuentraTarea(idAntecesora);
                if (tareaAntecesora != null){
                    // Borra la tarea antecesora
                    tarea.borraAntecesora(idAntecesora);  
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tarea antecesora inexistente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Tarea inexistente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Lista inexistente");
        }

    }

    /**
     * Controla el menú del programa
     */
    public void menuControlador(){
        String menu = "1.Poblar recursos\n2.Poblar colaboradores\n3.Poblar listas\n4.Poblar tareas\n" +
            "5.Ver los recursos\n6.Ver los colaboradores\n7.Ver listas\n8.Guardar el gestor de listas\n" +
            "9.Cargar el gestor de listas\n10.Agregar una lista\n11.Agregar una tarea\n12.Agregar un responsable a una tarea.\n" + 
            "13.Agregar un recurso a una tarea\n14.Agregar una antecesora a una tarea\n15.Cambiar la cantidad asignada a un recurso\n" +
            "16.Iniciar una tarea\n17.Finalizar una tarea\n18.Cambiar el avance de una tarea\n" + 
            "19.Consultar tareas por estado\n20.Consultas dinámicas\n21.Borrar lista\n22.Borrar tarea\n23.Borrar recurso\n" + 
            "24.Borrar responsable\n25.Borrar antecesora\n26.Salir";
        int opcionDigitada;
        do{
            opcionDigitada = controlaMenu(1,26,menu);
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
                case 10: agregaLista();
                break;
                case 11: agregaTarea();
                break;
                case 12: agregaResponsable();
                break;
                case 13: agregaRecurso();
                break;
                case 14: agregaAntecesora();
                break;
                case 15: cambiaCantidadAsignadaRecurso();
                break;
                case 16: iniciaTarea();
                break;
                case 17: finalizaTarea();
                break;
                case 18: cambiaGradoAvance();
                break;
                case 19: consultaEstado();
                break;
                case 20: consultaDinamica();
                break;
                case 21: borraLista();
                break;
                case 22: borraTarea();
                break;
                case 23: borraRecurso();
                break;
                case 24: borraResponsable();
                break;
                case 25: borraAntecesora();
                break;
                default:
            }
        }while(opcionDigitada != 26);
    }

    public static void main(String args[]){
        Controlador controlador = new Controlador();
        controlador.menuControlador();
    }

}
