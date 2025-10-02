package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.modelo.Medicamento;
import java.io.*;

public class ImplementacionOperacionCRUD implements OperacionCRUD {

	private Medicamento[] inventario;

    public ImplementacionOperacionCRUD(int size) {
        inventario = new Medicamento[size];
    }

    @Override
    public void create(Medicamento m) {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == null) {
                inventario[i] = m;
                System.out.println("Medicamento agregado en posición " + i);
                return;
            }
        }
        System.out.println("Inventario lleno.");
    }

    @Override
    public Medicamento read(int id) {
        for (Medicamento m : inventario) {
            if (m != null && m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Medicamento nuevo) {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null && inventario[i].getId() == id) {
                inventario[i] = nuevo;
                System.out.println("Medicamento actualizado.");
                return;
            }
        }
        System.out.println("Medicamento no encontrado.");
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null && inventario[i].getId() == id) {
                inventario[i] = null;
                System.out.println("Medicamento eliminado.");
                return;
            }
        }
        System.out.println("Medicamento no encontrado.");
    }

    @Override
    public void listAll() {
        boolean vacio = true;
        for (Medicamento m : inventario) {
            if (m != null) {
                System.out.println(m);
                vacio = false;
            }
        }
        if (vacio) System.out.println("Inventario vacío.");
    }

    @Override
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(inventario);
            System.out.println("Inventario guardado en archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            inventario = (Medicamento[]) ois.readObject();
            System.out.println("Inventario cargado desde archivo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
