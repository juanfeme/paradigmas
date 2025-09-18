package Medicamentos;

public class Medicamento {

		private String nombre;
	    private String dosis;
	    private String fabricante;

	    public Medicamento(String nombre, String dosis, String fabricante) {
	    this.nombre = nombre;
	    this.dosis = dosis;
	    this.fabricante = fabricante;
	    }

	    public void setNombre(String nombre) {
	    this.nombre = nombre;
	    }

	    public void setDosis(String dosis) {
	    this.dosis = dosis;
	    }

	    public void setFabricante(String fabricante) {
	    this.fabricante = fabricante;
	    }

	    public String getNombre() {
	    return nombre;
	    }

	    public String getDosis() {
	    return dosis;
	    }

	    public String getFabricante() {
	    return fabricante;
	    }

	    public void mostrarInformacion() {
	    System.out.println("Medicamento: " + nombre);
	    System.out.println("Dosis: " + dosis);
	    System.out.println("Fabricante: " + fabricante);
	    
	    }
}
