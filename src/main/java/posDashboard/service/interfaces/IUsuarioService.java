package posDashboard.service.interfaces;

import posDashboard.model.entity.Usuario;
import posDashboard.model.entity.UsuarioRol;

import java.util.List;
import java.util.Set;

public interface IUsuarioService {

    public List<Usuario> listUsuarios();
    public Usuario usuarioById(Long usuarioId);
    public Usuario usuarioByUsername(String username);
    public Usuario saveUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
    //public boolean updateUsuario(Long usuarioId, Usuario usuario);
    public void deleteUsuarioById(Long usuarioId);
}
