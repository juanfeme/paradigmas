package Servicios;

import Medicamentos.Medicamento;
import java.util.List;
import java.util.ArrayList;

public class ImplementacionOperacionCRUD implements OperacionCRUD {
    

    private static Medicamento[] medicamentos = new Medicamento[100];
    private static int contador = 0;

    @Override
    public boolean crear(Medicamento medicamento) {

        if (medicamento == null) {
            System.out.println("ERROR: No se puede crear un medicamento null");
            return false;
        }

        if (medicamento.getCodigo_atc() == null || medicamento.getCodigo_atc().trim().isEmpty()) {
            System.out.println("ERROR: El medicamento debe tener un código ATC válido");
            return false;
        }

        for (int i = 0; i < medicamentos.length; i++) {
            if (medicamentos[i] != null && 
                medicamentos[i].getCodigo_atc().equals(medicamento.getCodigo_atc())) {
                System.out.println("ERROR: Ya existe un medicamento con código ATC: " + 
                                 medicamento.getCodigo_atc());
                return false;
            }
        }

        for (int i = 0; i < medicamentos.length; i++) {
            if (medicamentos[i] == null) {
                medicamentos[i] = medicamento;
                contador++;
                System.out.println("Medicamento creado exitosamente en posición: " + i);
                System.out.println("Total medicamentos en sistema: " + contador);
                return true;
            }
        }
        
        System.out.println("ERROR: Sistema lleno. No hay espacio para más medicamentos");
        return false;
    }
    

    @Override
    public Medicamento consultar(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("ERROR: El ID de consulta no puede ser null o vacío");
            return null;
        }
        
        for (Medicamento med : medicamentos) {
            if (med != null && id.equals(med.getCodigo_atc())) {
                System.out.println("Medicamento encontrado: " + med.getMarca());
                return med;
            }
        }
        
        System.out.println("Medicamento con código ATC '" + id + "' no encontrado");
        return null;
    }

    @Override
    public List<Medicamento> consultarTodos() {
        List<Medicamento> lista = new ArrayList<>();
        
        for (Medicamento med : medicamentos) {
            if (med != null) {
                lista.add(med);
            }
        }
        
        System.out.println("Consultados " + lista.size() + " medicamentos del sistema");
        return lista;
    }
    

    @Override
    public boolean modificar(String id, Medicamento medicamento) {
        if (id == null || medicamento == null) {
            System.out.println("ERROR: ID y medicamento no pueden ser null para modificar");
            return false;
        }
        
        if (medicamento.getCodigo_atc() == null || medicamento.getCodigo_atc().trim().isEmpty()) {
            System.out.println("ERROR: El medicamento modificado debe tener código ATC válido");
            return false;
        }
        
        for (int i = 0; i < medicamentos.length; i++) {
            if (medicamentos[i] != null && id.equals(medicamentos[i].getCodigo_atc())) {

                if (!id.equals(medicamento.getCodigo_atc())) {
                    for (int j = 0; j < medicamentos.length; j++) {
                        if (j != i && medicamentos[j] != null && 
                            medicamentos[j].getCodigo_atc().equals(medicamento.getCodigo_atc())) {
                            System.out.println("ERROR: El código ATC " + 
                                             medicamento.getCodigo_atc() + " ya existe");
                            return false;
                        }
                    }
                }
                
                medicamentos[i] = medicamento;
                System.out.println("Medicamento modificado exitosamente");
                System.out.println("Nuevo código ATC: " + medicamento.getCodigo_atc());
                return true;
            }
        }
        
        System.out.println("Medicamento con código ATC '" + id + "' no encontrado para modificar");
        return false;
    }
    
    @Override
    public boolean eliminar(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("ERROR: El ID para eliminar no puede ser null o vacío");
            return false;
        }
        
        for (int i = 0; i < medicamentos.length; i++) {
            if (medicamentos[i] != null && id.equals(medicamentos[i].getCodigo_atc())) {
                String marca = medicamentos[i].getMarca();
                medicamentos[i] = null;
                contador--;
                System.out.println("Medicamento eliminado exitosamente: " + marca);
                System.out.println("Total medicamentos restantes: " + contador);
                return true;
            }
        }
        
        System.out.println("Medicamento con código ATC '" + id + "' no encontrado para eliminar");
        return false;
    }
    
    public void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS DEL SISTEMA ===");
        System.out.println("Total medicamentos: " + contador);
        System.out.println("Espacios disponibles: " + (medicamentos.length - contador));
        System.out.println("Capacidad máxima: " + medicamentos.length);
        System.out.println("Uso del sistema: " + 
        String.format("%.2f%%", (contador * 100.0) / medicamentos.length));

    }
    
    public int getContadorMedicamentos() {
        return contador;
    }
}
