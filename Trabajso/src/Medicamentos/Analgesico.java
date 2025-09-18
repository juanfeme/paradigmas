package Medicamentos;

public class Analgesico extends Medicamento{

    private String nivelPotencia;


    public Analgesico(String nombre, String dosis, String fabricante, String nivelPotencia) {
        super(nombre, dosis, fabricante);
        this.nivelPotencia = nivelPotencia;
    }

    public String getNivelPotencia() {
        return nivelPotencia;
    }

    public void setNivelPotencia(String nivelPotencia) {
        this.nivelPotencia = nivelPotencia;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("analgesico");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Dosis: " + getDosis());
        System.out.println("Fabricante: " + getFabricante());
        System.out.println("Nivel de potencia: " + nivelPotencia);
    }
}
