package co.edu.poli.actividad3.modelo;

public class MedicamentoPsicotropico extends MedicamentoControlado{

    private static final long serialVersionUID = 1L;

    private boolean requiereReceta;

    public MedicamentoPsicotropico(int id, String nombre, int anioCreacion, int nivelControl, boolean requiereReceta) {
 
        super(id, nombre, anioCreacion, nivelControl);
        this.requiereReceta = requiereReceta;
    }

    public boolean isRequiereReceta() {
        return requiereReceta;
    }

    public void setRequiereReceta(boolean requiereReceta) {
        this.requiereReceta = requiereReceta;
    }

    @Override
    protected String descripcionExtra() {
        return (requiereReceta ? "Requiere receta" : "Venta controlada, sin receta") ;
    }

    @Override
    public String toString() {
        return super.toString() + ", requiereReceta=" + requiereReceta;
    }
}
