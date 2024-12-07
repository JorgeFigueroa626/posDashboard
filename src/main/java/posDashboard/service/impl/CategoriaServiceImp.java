package posDashboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posDashboard.model.entity.Categoria;
import posDashboard.respository.ICategoriaRepository;
import posDashboard.service.interfaces.ICategoriaService;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoriaServiceImp implements ICategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Set<Categoria> obtenerCategorias() {
        return new LinkedHashSet<>(categoriaRepository.findAll());
    }

    @Override
    public Categoria obtenerCategoriaId(Long id) {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
