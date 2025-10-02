package co.edu.poli.actividad3.vista;

import co.edu.poli.actividad3.modelo.*;
import co.edu.poli.actividad4.servicios.*;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OperacionCRUD crud = new ImplementacionOperacionCRUD(10);
        String archivo = "medicamentos.dat";
        int opcion;

        do {
            System.out.println("MENU CRUD MEDICAMENTOS");
            System.out.println("1. Crear medicamento");
            System.out.println("2. Listar todos");
            System.out.println("3. Listar un medicamento por ID");
            System.out.println("4. Guardar archivo");
            System.out.println("5. Cargar archivo");
            System.out.println("6. Modificar medicamento");
            System.out.println("7. Eliminar medicamento");
            System.out.println("8. Salir");
            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Anio creacion: ");
                    int anio = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Laboratorio: ");
                    String lab = sc.nextLine();
                    Medicamento m = new MedicamentoGenerico(id, nombre, anio, lab);
                    crud.create(m);
                }
                case 2 -> crud.listAll();
                case 3 -> {
                    System.out.print("Ingrese ID: ");
                    int id = sc.nextInt();
                    Medicamento m = crud.read(id);
                    if (m != null) System.out.println(m);
                    else System.out.println("Medicamento no encontrado.");
                }
                case 4 -> crud.saveToFile(archivo);
                case 5 -> crud.loadFromFile(archivo);
                case 6 -> {
                    System.out.print("ID a modificar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nuevo anio: ");
                    int anio = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo laboratorio: ");
                    String lab = sc.nextLine();
                    Medicamento actualizado = new MedicamentoGenerico(id, nombre, anio, lab);
                    crud.update(id, actualizado);
                }
                case 7 -> {
                    System.out.print("ID a eliminar: ");
                    int id = sc.nextInt();
                    crud.delete(id);
                }
                case 8 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción invalida.");
            }
        } while (opcion != 8);

        sc.close();
    }
}
