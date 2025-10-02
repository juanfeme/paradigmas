package co.edu.poli.actividad3.modelo;

import java.io.Serializable;

public abstract class Medicamento implements Serializable {

	 private static final long serialVersionUID = 1L;

	    private int id;
	    private String nombre;
	    private int anioCreacion;

	    public Medicamento(int id, String nombre, int anioCreacion) {
	        this.id = id;
	        this.nombre = nombre;
	        this.anioCreacion = anioCreacion;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int getAnioCreacion() {
	        return anioCreacion;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public void setAnioCreacion(int anioCreacion) {
	        this.anioCreacion = anioCreacion;
	    }

	    protected String descripcionExtra() {
	        return "";
	    }

	    @Override
	    public String toString() {
	        return "Medicamento{" +
	                "id=" + id +
	                ", nombre='" + nombre + '\'' +
	                ", anioCreacion=" + anioCreacion +
	                '}';
	    }
}
