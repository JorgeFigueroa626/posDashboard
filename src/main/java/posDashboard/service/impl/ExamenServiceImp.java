package posDashboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posDashboard.model.entity.Categoria;
import posDashboard.model.entity.Examen;
import posDashboard.respository.IExamenRepository;
import posDashboard.service.interfaces.IExamenService;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExamenServiceImp implements IExamenService {

    @Autowired
    private IExamenRepository examenRepository;

    @Override
    public Examen agregarExamen(Examen examen) {
        return  examenRepository.save(examen);
    }

    @Override
    public Examen actualizarExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Set<Examen> obtenerExamenes() {
        return new LinkedHashSet<>(examenRepository.findAll());
    }

    @Override
    public Examen obtenerExamenId(Long id) {
        return examenRepository.findById(id).get();
    }

    @Override
    public void eliminarExamenId(Long id) {
        examenRepository.deleteById(id);
    }

    @Override
    public List<Examen> listarExamenDeCategoriaId(Categoria categoria) {
        return examenRepository.findByCategoria(categoria);
    }

    @Override
    public List<Examen> getAllExamenActivo() {
        return examenRepository.findByState(true);
    }

    @Override
    public List<Examen> getAllExamenActivoByCategoryId(Categoria categoria) {
        return examenRepository.findByCategoriaAndState(categoria, true);
    }


}
