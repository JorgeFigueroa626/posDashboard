package posDashboard.service.interfaces;

import posDashboard.model.entity.Categoria;
import posDashboard.model.entity.Examen;

import java.util.List;
import java.util.Set;

public interface IExamenService {

    public Examen agregarExamen(Examen examen);

    public Examen actualizarExamen(Examen examen);

    public Set<Examen> obtenerExamenes();

    public Examen obtenerExamenId(Long id);

    public void eliminarExamenId(Long id);

    public List<Examen> listarExamenDeCategoriaId(Categoria categoria);

    public List<Examen> getAllExamenActivo();

    public List<Examen> getAllExamenActivoByCategoryId(Categoria categoria);
}
