package co.edu.poli.actividad3.modelo;

public class MedicamentoControlado extends Medicamento {

	private static final long serialVersionUID = 1L;

    private int nivelControl;

    public MedicamentoControlado(int id, String nombre, int anioCreacion, int nivelControl) {
        super(id, nombre, anioCreacion);
        this.nivelControl = nivelControl;
    }

    public int getNivelControl() {
        return nivelControl;
    }

    public void setNivelControl(int nivelControl) {
        this.nivelControl = nivelControl;
    }

    @Override
    protected String descripcionExtra() {
        return "Nivel de control: " + nivelControl;
    }

    @Override
    public String toString() {
        return super.toString() + ", nivelControl=" + nivelControl;
    }
}
