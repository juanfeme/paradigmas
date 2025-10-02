package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.modelo.Medicamento;

public interface OperacionCRUD {

	    void create(Medicamento m);
	    Medicamento read(int id);
	    void update(int id, Medicamento m);
	    void delete(int id);
	    void listAll();
	    void saveToFile(String filename);
	    void loadFromFile(String filename);
}
