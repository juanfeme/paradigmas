package Medicamentos;

public class Antibiotico extends Medicamento {

    private String espectroAccion;
    private String bacteriaObjetivo;
    private boolean requiereReceta;
    private int diasTratamiento;
    

    public Antibiotico() {
        super();
    }

    public Antibiotico(String codigo_atc, String marca, String efecto,
                      String calidad, String color, double peso, double precio,
                      String espectroAccion, String bacteriaObjetivo, 
                      boolean requiereReceta, int diasTratamiento) {
        super(codigo_atc, marca, efecto, calidad, color, peso, precio);
        this.espectroAccion = espectroAccion;
        this.bacteriaObjetivo = bacteriaObjetivo;
        this.requiereReceta = requiereReceta;
        this.diasTratamiento = diasTratamiento;
    }
    
 
    public String getEspectroAccion() { return espectroAccion; }
    public void setEspectroAccion(String espectroAccion) { this.espectroAccion = espectroAccion; }
    
    public String getBacteriaObjetivo() { return bacteriaObjetivo; }
    public void setBacteriaObjetivo(String bacteriaObjetivo) { this.bacteriaObjetivo = bacteriaObjetivo; }
    
    public boolean isRequiereReceta() { return requiereReceta; }
    public void setRequiereReceta(boolean requiereReceta) { this.requiereReceta = requiereReceta; }
    
    public int getDiasTratamiento() { return diasTratamiento; }
    public void setDiasTratamiento(int diasTratamiento) { this.diasTratamiento = diasTratamiento; }
    

    @Override
    protected boolean esVigente() {
        return esVigenteOtraFechaCaducidad(getFecha_caducidad());
    }

    public boolean esEfectivoContra(String bacteria) {
        return bacteriaObjetivo != null && 
               bacteriaObjetivo.toLowerCase().contains(bacteria.toLowerCase());
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Espectro de acción: " + espectroAccion);
        System.out.println("Bacteria objetivo: " + bacteriaObjetivo);
        System.out.println("Requiere receta: " + (requiereReceta ? "Sí" : "No"));
        System.out.println("Días de tratamiento: " + diasTratamiento);
    }
}