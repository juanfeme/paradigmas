package Medicamentos;

import java.time.LocalDate;
import java.util.List;

public abstract class Medicamento {
	
    private String codigo_atc;
    private String marca;
    private String efecto;
    private List<String> contraindicaciones;
    private String calidad;
    private String color;
    private List<String> patologia;
    private double peso;
    private double cantidad;
    private String presentacion;
    private String fecha_caducidad;
    private double tamano;
    private double precio;
    private int ano_fab;

    public Medicamento() {}

    Medicamento(String codigo_atc, String marca, String efecto, 
                      String calidad, String color, double peso, double precio) {
        this.codigo_atc = codigo_atc;
        this.marca = marca;
        this.efecto = efecto;
        this.calidad = calidad;
        this.color = color;
        this.peso = peso;
        this.precio = precio;
    }
    
    public String getCodigo_atc() { return codigo_atc; }
    public void setCodigo_atc(String codigo_atc) { this.codigo_atc = codigo_atc; }
    
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    public String getEfecto() { return efecto; }
    public void setEfecto(String efecto) { this.efecto = efecto; }
    
    public List<String> getContraindicaciones() { return contraindicaciones; }
    public void setContraindicaciones(List<String> contraindicaciones) { 
        this.contraindicaciones = contraindicaciones; 
    }
    
    public String getCalidad() { return calidad; }
    public void setCalidad(String calidad) { this.calidad = calidad; }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    
    public List<String> getPatologia() { return patologia; }
    public void setPatologia(List<String> patologia) { this.patologia = patologia; }
    
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    
    public double getCantidad() { return cantidad; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
    
    public String getPresentacion() { return presentacion; }
    public void setPresentacion(String presentacion) { this.presentacion = presentacion; }
    
    public String getFecha_caducidad() { return fecha_caducidad; }
    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }
    
    public double getTamano() { return tamano; }
    public void setTamano(double tamano) { this.tamano = tamano; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    public int getAno_fab() { return ano_fab; }
    public void setAno_fab(int ano_fab) { this.ano_fab = ano_fab; }
    
    protected abstract boolean esVigente();
    
    protected boolean esVigenteOtraFechaCaducidad(String otraFechaCaducidad) {
        try {
            LocalDate fechaCaducidadDate = LocalDate.parse(otraFechaCaducidad);
            LocalDate fechaActual = LocalDate.now();
            return fechaCaducidadDate.isAfter(fechaActual);
        } catch (Exception e) {
            System.out.println("¿La pastilla con tratamiento crónico (" + 
                             (ano_fab != 0 ? ano_fab : "sin año") + 
                             ") está vigente? " + false);
            return false;
        }
    }
    
    public void mostrarInformacion() {
        System.out.println(" INFORMACIÓN DEL MEDICAMENTO ");
        System.out.println("Código ATC: " + codigo_atc);
        System.out.println("Marca: " + marca);
        System.out.println("Efecto: " + efecto);
        System.out.println("Calidad: " + calidad);
        System.out.println("Color: " + color);
        System.out.println("Peso: " + peso + " g");
        System.out.println("Precio: $" + precio);
        if (fecha_caducidad != null) {
            System.out.println("Fecha caducidad: " + fecha_caducidad);
        }
    }
}