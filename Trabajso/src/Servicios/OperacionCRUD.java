package Servicios;

import Medicamentos.Medicamento;
import java.util.List;

public interface OperacionCRUD {
    
    boolean crear(Medicamento medicamento);
    
    Medicamento consultar(String id);
    
    List<Medicamento> consultarTodos();
    
    boolean modificar(String id, Medicamento medicamento);
    
    boolean eliminar(String id);
}

