package Medicamentos;

public class MedicamentoControlado extends Medicamento {

    private String nivelControl;
    private String registroDEA;
    private boolean requiereRecetaEspecial;
    private int limiteCantidad;
    private String razonControl;

    public MedicamentoControlado() {
        super();
    }
    
    public MedicamentoControlado(String codigo_atc, String marca, String efecto,
                                String calidad, String color, double peso, double precio,
                                String nivelControl, String registroDEA,
                                boolean requiereRecetaEspecial, int limiteCantidad,
                                String razonControl) {
        super(codigo_atc, marca, efecto, calidad, color, peso, precio);
        this.nivelControl = nivelControl;
        this.registroDEA = registroDEA;
        this.requiereRecetaEspecial = requiereRecetaEspecial;
        this.limiteCantidad = limiteCantidad;
        this.razonControl = razonControl;
    }
    
    public String getNivelControl() { return nivelControl; }
    public void setNivelControl(String nivelControl) { this.nivelControl = nivelControl; }
    
    public String getRegistroDEA() { return registroDEA; }
    public void setRegistroDEA(String registroDEA) { this.registroDEA = registroDEA; }
    
    public boolean isRequiereRecetaEspecial() { return requiereRecetaEspecial; }
    public void setRequiereRecetaEspecial(boolean requiereRecetaEspecial) { 
        this.requiereRecetaEspecial = requiereRecetaEspecial; 
    }
    
    public int getLimiteCantidad() { return limiteCantidad; }
    public void setLimiteCantidad(int limiteCantidad) { this.limiteCantidad = limiteCantidad; }
    
    public String getRazonControl() { return razonControl; }
    public void setRazonControl(String razonControl) { this.razonControl = razonControl; }

    @Override
    protected boolean esVigente() {
        return esVigenteOtraFechaCaducidad(getFecha_caducidad());
    }

    public boolean puedeDispensarCantidad(int cantidadSolicitada) {
        return cantidadSolicitada <= limiteCantidad;
    }
    
    public String obtenerNivelRiesgo() {
        switch (nivelControl) {
            case "I": return "MUY ALTO - Sin uso médico aceptado";
            case "II": return "ALTO - Potencial de abuso alto";
            case "III": return "MODERADO - Potencial de abuso moderado";
            case "IV": return "BAJO - Potencial de abuso limitado";
            case "V": return "MUY BAJO - Potencial de abuso mínimo";
            default: return "NO CLASIFICADO";
        }
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("MEDICAMENTO CONTROLADO");
        System.out.println("Nivel de control: " + nivelControl);
        System.out.println("Registro DEA: " + registroDEA);
        System.out.println("Requiere receta especial: " + (requiereRecetaEspecial ? "Sí" : "No"));
        System.out.println("Límite de cantidad: " + limiteCantidad + " unidades");
        System.out.println("Razón del control: " + razonControl);
        System.out.println("Nivel de riesgo: " + obtenerNivelRiesgo());
    }
}
