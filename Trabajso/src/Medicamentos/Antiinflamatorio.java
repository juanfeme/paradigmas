package Medicamentos;

public class Antiinflamatorio extends Medicamento {
    
    private String tipoAINE; 
    private boolean esSelectivo; 
    private String zonaInflamacion;
    private double dosisMaximaDiaria;
    
    public Antiinflamatorio() {
        super();
    }
    
    public Antiinflamatorio(String codigo_atc, String marca, String efecto,
                           String calidad, String color, double peso, double precio,
                           String tipoAINE, boolean esSelectivo, 
                           String zonaInflamacion, double dosisMaximaDiaria) {
        super(codigo_atc, marca, efecto, calidad, color, peso, precio);
        this.tipoAINE = tipoAINE;
        this.esSelectivo = esSelectivo;
        this.zonaInflamacion = zonaInflamacion;
        this.dosisMaximaDiaria = dosisMaximaDiaria;
    }
    
    public String getTipoAINE() { return tipoAINE; }
    public void setTipoAINE(String tipoAINE) { this.tipoAINE = tipoAINE; }
    
    public boolean isEsSelectivo() { return esSelectivo; }
    public void setEsSelectivo(boolean esSelectivo) { this.esSelectivo = esSelectivo; }
    
    public String getZonaInflamacion() { return zonaInflamacion; }
    public void setZonaInflamacion(String zonaInflamacion) { this.zonaInflamacion = zonaInflamacion; }
    
    public double getDosisMaximaDiaria() { return dosisMaximaDiaria; }
    public void setDosisMaximaDiaria(double dosisMaximaDiaria) { this.dosisMaximaDiaria = dosisMaximaDiaria; }
    
    @Override
    protected boolean esVigente() {
        return esVigenteOtraFechaCaducidad(getFecha_caducidad());
    }

    public boolean esApropiado(String zona) {
        return zonaInflamacion != null && 
               zonaInflamacion.toLowerCase().contains(zona.toLowerCase());
    }
    
    public int calcularDosisPorDia(double dosisPorToma) {
        if (dosisPorToma <= 0) return 0;
        return (int) Math.floor(dosisMaximaDiaria / dosisPorToma);
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo AINE: " + tipoAINE);
        System.out.println("Es selectivo: " + (esSelectivo ? "Sí" : "No"));
        System.out.println("Zona de inflamación: " + zonaInflamacion);
        System.out.println("Dosis máxima diaria: " + dosisMaximaDiaria + " mg");
    }
}