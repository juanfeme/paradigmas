package co.edu.poli.actividad3.modelo;

public class MedicamentoGenerico extends Medicamento {

	 private static final long serialVersionUID = 1L;

	    private String laboratorio;

	    public MedicamentoGenerico(int id, String nombre, int anioCreacion, String laboratorio) {
	        super(id, nombre, anioCreacion);
	        this.laboratorio = laboratorio;
	    }

	    public String getLaboratorio() {
	        return laboratorio;
	    }

	    public void setLaboratorio(String laboratorio) {
	        this.laboratorio = laboratorio;
	    }

	    @Override
	    protected String descripcionExtra() {
	        return "Laboratorio: " + laboratorio;
	    }

	    @Override
	    public String toString() {
	        return super.toString() + ", laboratorio=" + laboratorio;
	    }
}
