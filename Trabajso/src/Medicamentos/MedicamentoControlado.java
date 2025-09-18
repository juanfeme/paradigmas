package Medicamentos;

public class MedicamentoControlado {

    private final String codigoRegistro;
    private String nombre;
    private String dosis;

    public MedicamentoControlado(String codigoRegistro, String nombre, String dosis) {
        this.codigoRegistro = codigoRegistro;
        this.nombre = nombre;
        this.dosis = dosis;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public final void mostrarInformacion() {
        System.out.println("Medicamento controlado");
        System.out.println("Código de registro: " + codigoRegistro);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dosis: " + dosis);
    }

    public static void main(String[] args) {
        MedicamentoControlado medicamento = new MedicamentoControlado("MC-001", "Morfina", "10mg");
        medicamento.mostrarInformacion();
    }
}
