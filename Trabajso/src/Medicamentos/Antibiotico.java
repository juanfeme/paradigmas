package Medicamentos;

public class Antibiotico extends Medicamento {

	 private String tipoBacteria;

	    public Antibiotico(String nombre, String dosis, String fabricante, String tipoBacteria) {
	        super(nombre, dosis, fabricante);
	        this.tipoBacteria = tipoBacteria;
	    }

	    public String getTipoBacteria() {
	        return tipoBacteria;
	    }

	    public void setTipoBacteria(String tipoBacteria) {
	        this.tipoBacteria = tipoBacteria;
	    }

	    @Override
	    public void mostrarInformacion() {
	        System.out.println("antibiotico");
	        System.out.println("Nombre: " + getNombre());
	        System.out.println("Dosis: " + getDosis());
	        System.out.println("Fabricante: " + getFabricante());
	        System.out.println("Tipo de bacteria que combate: " + tipoBacteria);

	    }
}
