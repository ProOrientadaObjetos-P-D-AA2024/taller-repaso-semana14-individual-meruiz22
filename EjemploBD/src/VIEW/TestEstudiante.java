package VIEW;

import MODEL.Estudiante;
import CONTROLER.ProcesarEstudiantes;
import MODEL.ConeccionDB;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestEstudiante {

    /* public static void main(String[] args) {
        ArrayList<Estudiante> lstEst = new ArrayList<Estudiante>(List.of(
                new Estudiante("Paul", (int) (Math.random()*10+0), (int) 
                        (Math.random()*10+0),"1150017950"), 
                new Estudiante("Estafania", (int) (Math.random()*10+0),
                        (int) (Math.random()*10+0),"1234567893") ));
        ProcesarEstudiantes procesarEstudiantes = new ProcesarEstudiantes(lstEst);
        procesarEstudiantes.calculoPromedios();
        procesarEstudiantes.calculoEstados();
        for (Estudiante est : lstEst) 
            procesarEstudiantes.insertarEstudiante(est);
        ArrayList<Estudiante> lstEst2 = procesarEstudiantes.getLstEstudiantes();
        for (Estudiante est : lstEst2) 
            System.out.println(est);
    }*/
    public static void main(String[] args) {

        // Menu donde se muestran las funciones se pide los datos y se escoge que las acciones a realizra 
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> lstEst = new ArrayList<>();
        ProcesarEstudiantes procesarEstudiantes = new ProcesarEstudiantes(lstEst);
        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Insertar Estudiante");
            System.out.println("2. Eliminar Estudiante");
            System.out.println("3. Actualizar Estudiante");
            System.out.println("4. Listar Estudiantes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese nota 1: ");
                    double nota1 = scanner.nextDouble();
                    System.out.print("Ingrese nota 2: ");
                    double nota2 = scanner.nextDouble();
                    scanner.nextLine();  
                    System.out.print("Ingrese ID del estudiante: ");
                    String id = scanner.nextLine();

                    Estudiante nuevoEstudiante = new Estudiante(nombre,
                            nota1, nota2, id);
                    lstEst.add(nuevoEstudiante);
                    procesarEstudiantes.calculoPromedios();
                    procesarEstudiantes.calculoEstados();
                    procesarEstudiantes.insertarEstudiante(nuevoEstudiante);
                    System.out.println("Estudiante insertado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese ID del estudiante a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    procesarEstudiantes.deleteEstudiante(idEliminar);
                    System.out.println("Estudiante eliminado con éxito.");
                    break;

                case 3:
                    System.out.print("Ingrese ID del estudiante a actualizar: ");
                    String idActualizar = scanner.nextLine();
                    System.out.print("Ingrese nuevo nombre del estudiante: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese nueva nota 1: ");
                    double nuevaNota1 = scanner.nextDouble();
                    System.out.print("Ingrese nueva nota 2: ");
                    double nuevaNota2 = scanner.nextDouble();
                    scanner.nextLine();

                    Estudiante estudianteActualizado = new Estudiante(
                            nuevoNombre, nuevaNota1, nuevaNota2,
                            idActualizar);
                    lstEst.add(estudianteActualizado);
                    procesarEstudiantes.calculoPromedios();
                    procesarEstudiantes.calculoEstados();
                    procesarEstudiantes.updateEstudiante(estudianteActualizado);
                    System.out.println("Estudiante actualizado con éxito.");
                    break;

                case 4:
                    ArrayList<Estudiante> estudiantes = procesarEstudiantes.getLstEstudiantes();
                    for (Estudiante est : estudiantes) {
                        System.out.println(est);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

}
