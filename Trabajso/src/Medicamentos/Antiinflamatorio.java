package Medicamentos;

public class Antiinflamatorio extends Medicamento {

    private String zonaAplicacion;

    public Antiinflamatorio(String nombre, String dosis, String fabricante, String zonaAplicacion) {
        super(nombre, dosis, fabricante); 
        this.zonaAplicacion = zonaAplicacion;
    }
    
    public String getZonaAplicacion() {
        return zonaAplicacion;
    }

    public void setZonaAplicacion(String zonaAplicacion) {
        this.zonaAplicacion = zonaAplicacion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("antiinflamatorio");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Dosis: " + getDosis());
        System.out.println("Fabricante: " + getFabricante());
        System.out.println("Zona de aplicación: " + zonaAplicacion);
    }
}
