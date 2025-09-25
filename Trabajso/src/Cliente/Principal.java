package Cliente;

import Medicamentos.*;
import Servicios.*;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Principal {
    
    private static ImplementacionOperacionCRUD operacionCRUD = new ImplementacionOperacionCRUD();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        
        ejecutarPruebasCRUD();
        mostrarMenuInteractivo();
        
        scanner.close();
    }
    
    private static void ejecutarPruebasCRUD() {


        Analgesico paracetamol = new Analgesico(
            "N02BE01", "Dolex", "Alivio del dolor y fiebre",
            "Buena", "Blanco", 0.5, 1500.0, 
            "No Opioide", "Leve a Moderado", 4
        );
        paracetamol.setFecha_caducidad("2026-10-20");
        paracetamol.setContraindicaciones(Arrays.asList("Hepatopatia", "Alergia"));
        operacionCRUD.crear(paracetamol);

        Antibiotico amoxicilina = new Antibiotico(
            "J01CA04", "Amoxil", "Bactericida para infecciones",
            "Alta", "Rosa", 0.8, 4500.0, 
            "Amplio", "Streptococcus", true, 7
        );
        amoxicilina.setFecha_caducidad("2025-05-15");
        operacionCRUD.crear(amoxicilina);

        Antiinflamatorio ibuprofeno = new Antiinflamatorio(
            "M01AE01", "Advil", "Antiinflamatorio, analgésico y antipiretico",
            "Buena", "Rojo", 0.7, 2800.0, 
            "AINE", false, "General (Dolor Muscular, Articular)", 1200.0
        );
        ibuprofeno.setFecha_caducidad("2027-01-30");
        operacionCRUD.crear(ibuprofeno);
        
        MedicamentoControlado morfina = new MedicamentoControlado(
            "N02AA01", "Oramorph", "Alivio de dolor severo crónico",
            "Maxima", "Azul", 1.2, 55000.0, 
            "II", "DEA12345", true, 30, "Alto potencial de adicción"
        );
        morfina.setFecha_caducidad("2025-12-01");
        operacionCRUD.crear(morfina);

        operacionCRUD.crear(paracetamol);
        
        System.out.println("\n--- 2. PRUEBA DE LECTURA DE TODOS (R) ---");
        List<Medicamento> listaMedicamentos = operacionCRUD.consultarTodos();
        for (Medicamento med : listaMedicamentos) {
            System.out.println(" [Listado] - " + med.getMarca() + " (ATC: " + med.getCodigo_atc() + ")");
        }
        
        System.out.println("\n--- 3. PRUEBA DE CONSULTA POR ID (R) y Métodos Específicos ---");
        String idConsulta = "N02BE01";
        Medicamento medConsultado = operacionCRUD.consultar(idConsulta);
        
        if (medConsultado != null) {
            medConsultado.mostrarInformacion();
            
            if (medConsultado instanceof Analgesico) {
                Analgesico analg = (Analgesico) medConsultado;
                System.out.println("Especifico: ¿Es efectivo para 'moderado'? " + analg.esEfectivoParaDolor("moderado"));
                System.out.println("Especifico: ¿Sigue vigente? " + analg.esVigente());
            }
            if (medConsultado instanceof MedicamentoControlado) {
                MedicamentoControlado ctrl = (MedicamentoControlado) medConsultado;
                System.out.println("Especifico: Nivel de Riesgo: " + ctrl.obtenerNivelRiesgo());
            }
        }
        
        System.out.println("\n--- 4. PRUEBA DE MODIFICACION (U) ---");
        String idModificar = "M01AE01";
        
        Antiinflamatorio ibuprofenoModificado = new Antiinflamatorio(
            "M01AE01B", 
            "Advil ExtraFuerte", 
            "Máxima potencia antiinflamatoria",
            "Premium", "Rojo", 0.7, 3500.0, 
            "AINE", true, 
            "Articulaciones", 2400.0
        );
        ibuprofenoModificado.setFecha_caducidad("2027-01-30");

        boolean modificado = operacionCRUD.modificar(idModificar, ibuprofenoModificado);
        System.out.println("Resultado de Modificación: " + (modificado ? "EXITO" : "FALLO"));

        Medicamento medModificado = operacionCRUD.consultar("M01AE01B");
        if (medModificado != null) {
            System.out.println("Verificacion de datos modificados:");
            medModificado.mostrarInformacion();
        }
        
        System.out.println("\n--- 5. PRUEBA DE ELIMINACION (D) ---");
        String idEliminar = "J01CA04";
        operacionCRUD.eliminar(idEliminar);
        
        operacionCRUD.eliminar(idEliminar); 
        
        System.out.println("\n--- 6. PRUEBA FINAL DE LISTADO Y ESTADISTICAS ---");
        operacionCRUD.consultarTodos(); 
        operacionCRUD.mostrarEstadisticas();
        
    }
    
    private static void mostrarMenuInteractivo() {
        System.out.println("MENU INTERACTIVO");
        System.out.println("1. Agregar nuevo medicamento");
        System.out.println("2. Consultar por Código ATC");
        System.out.println("3. Listar todos los medicamentos");
        System.out.println("4. Modificar medicamento");
        System.out.println("5. Eliminar medicamento");
        System.out.println("6. Mostrar Estadisticas");
        System.out.println("0. Salir del programa");
   
        System.out.println("El programa ha finalizado la prueba automatica.");
    }
}