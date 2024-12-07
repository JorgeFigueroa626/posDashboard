package posDashboard.service.interfaces;

import posDashboard.model.entity.Categoria;

import java.util.Set;

public interface ICategoriaService {

    public Categoria agregarCategoria(Categoria categoria);

    public Categoria actualizarCategoria(Categoria categoria);

    public Set<Categoria> obtenerCategorias();

    public Categoria obtenerCategoriaId(Long id);

    public void eliminarCategoria(Long id);
}
