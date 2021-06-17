import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
                // Busca el recurso de acuerdo al idColaborador
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
     * Inicia la tarea
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
                tarea.setEstadoTarea("Haciendo");
                // pone la fecha
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
     * Finaliza la tarea
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
                tarea.setEstadoTarea("Terminado");
                // fecha y porcentaje
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
        System.out.println("TAREAS POR HACER (Por lista)");
        System.out.print(this.gestorListas.consultaListas("Por hacer"));
        System.out.println("TAREAS EN CURSO (Por lista)");
        System.out.print(this.gestorListas.consultaListas("Haciendo"));
        System.out.println("TAREAS FINALIZADAS (Por lista)");
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
        System.out.print(this.gestorListas.consultaListas(estimacionDineroTarea, estimacionEsfuerzoTarea,
                                                          estimacionTiempoTarea, gradoAvanceTarea));
    }

    /**
     * Consulta 
     */
    public void agregaLista(){
        // Re

    }

    /**
     * Consulta 
     */
    public void agregaTarea(){
        // Re

    }

    /**
     * Consulta 
     */
    public void cambiaCantidadSolicitadaRecurso(){
        // Re

    }

    /**
     * Consulta 
     */
    public void cambiaGradoAvance(){
        // Re

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
                case 15: cambiaCantidadSolicitadaRecurso();
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
