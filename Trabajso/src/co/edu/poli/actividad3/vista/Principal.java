package co.edu.poli.actividad3.vista;

import co.edu.poli.actividad3.modelo.*;
import co.edu.poli.actividad4.servicios.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OperacionCRUD crud = new ImplementacionOperacionCRUD(10);
        String archivo = "medicamentos.dat";
        int opcion = 0;

        do {
            System.out.println("=== MENU CRUD MEDICAMENTOS ===");
            System.out.println("1. Crear medicamento");
            System.out.println("2. Listar todos");
            System.out.println("3. Listar un medicamento por ID");
            System.out.println("4. Guardar archivo");
            System.out.println("5. Cargar archivo");
            System.out.println("6. Modificar medicamento");
            System.out.println("7. Eliminar medicamento");
            System.out.println("8. Salir");

            try {
                System.out.print("Seleccione opcion: ");
                opcion = sc.nextInt();
                sc.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Dato invalido. Ingrese un numero valido.");
                sc.nextLine(); 
                continue;
            }

            try {
                switch (opcion) {
                    case 1 -> {
                        int id = leerEntero(sc, "ID: ");
                        sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        int anio = leerEntero(sc, "Anio de creacion: ");
                        sc.nextLine();
                        System.out.print("Laboratorio: ");
                        String lab = sc.nextLine();
                        Medicamento m = new MedicamentoGenerico(id, nombre, anio, lab);
                        crud.create(m);
                    }

                    case 2 -> crud.listAll();

                    case 3 -> {
                        int id = leerEntero(sc, "Ingrese ID: ");
                        Medicamento m = crud.read(id);
                        if (m != null)
                            System.out.println(m);
                        else
                            System.out.println("Medicamento no encontrado.");
                    }

                    case 4 -> crud.saveToFile(archivo);

                    case 5 -> crud.loadFromFile(archivo);

                    case 6 -> {
                        int id = leerEntero(sc, "ID a modificar: ");
                        sc.nextLine();
                        System.out.print("Nuevo nombre: ");
                        String nombre = sc.nextLine();
                        int anio = leerEntero(sc, "Nuevo anio: ");
                        sc.nextLine();
                        System.out.print("Nuevo laboratorio: ");
                        String lab = sc.nextLine();
                        Medicamento actualizado = new MedicamentoGenerico(id, nombre, anio, lab);
                        crud.update(id, actualizado);
                    }

                    case 7 -> {
                        int id = leerEntero(sc, "ID a eliminar: ");
                        crud.delete(id);
                    }

                    case 8 -> System.out.println("Saliendo...");

                    default -> System.out.println("Opcion invalida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Dato ingresado no valido. Intente nuevamente.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }

        } while (opcion != 8);

        sc.close();
    }
    private static int leerEntero(Scanner sc, String mensaje) {
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = sc.nextInt();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Dato invalido. Ingrese un numero entero valido.");
                sc.nextLine(); 
            }
        }
    }
}

