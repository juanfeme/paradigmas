package Medicamentos;

public class Analgesico extends Medicamento {

    private String tipoAnalgesico;
    private String intensidadDolor;
    private int duracionEfecto; 
    

    public Analgesico() {
        super();
    }
    

    public Analgesico(String codigo_atc, String marca, String efecto,
                     String calidad, String color, double peso, double precio,
                     String tipoAnalgesico, String intensidadDolor, int duracionEfecto) {
        super(codigo_atc, marca, efecto, calidad, color, peso, precio);
        this.tipoAnalgesico = tipoAnalgesico;
        this.intensidadDolor = intensidadDolor;
        this.duracionEfecto = duracionEfecto;
    }
    
    public String getTipoAnalgesico() { return tipoAnalgesico; }
    public void setTipoAnalgesico(String tipoAnalgesico) { this.tipoAnalgesico = tipoAnalgesico; }
    
    public String getIntensidadDolor() { return intensidadDolor; }
    public void setIntensidadDolor(String intensidadDolor) { this.intensidadDolor = intensidadDolor; }
    
    public int getDuracionEfecto() { return duracionEfecto; }
    public void setDuracionEfecto(int duracionEfecto) { this.duracionEfecto = duracionEfecto; }
    

    @Override
	public boolean esVigente() {
        return esVigenteOtraFechaCaducidad(getFecha_caducidad());
    }

    public boolean esEfectivoParaDolor(String tipoDolor) {
        return intensidadDolor != null && 
               intensidadDolor.toLowerCase().contains(tipoDolor.toLowerCase());
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo Analgésico: " + tipoAnalgesico);
        System.out.println("Intensidad para dolor: " + intensidadDolor);
        System.out.println("Duración efecto: " + duracionEfecto + " horas");
    }
}

