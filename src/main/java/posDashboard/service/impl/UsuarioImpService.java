package posDashboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posDashboard.model.entity.Usuario;
import posDashboard.model.entity.UsuarioRol;
import posDashboard.respository.IRolRepository;
import posDashboard.respository.IUsuarioRepository;
import posDashboard.service.interfaces.IUsuarioService;

import java.util.List;
import java.util.Set;

@Service
public class UsuarioImpService implements IUsuarioService {


    @Autowired
    private  IUsuarioRepository usuarioRepository;
    @Autowired
    private  IRolRepository rolRepository;

    /*constructor
    public UsuarioImpService(IUsuarioRepository usuarioRepository, IRolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }
     */


    @Override
    public List<Usuario> listUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario usuarioById(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).get();
    }

    @Override
    public Usuario usuarioByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
       Usuario saveUsuario = usuarioRepository.findByUsername(usuario.getUsername());
        if (saveUsuario != null) {
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else {
            for (UsuarioRol usuarioRol: usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            saveUsuario = usuarioRepository.save(usuario);
        }
       return saveUsuario;
    }

    @Override
    public void deleteUsuarioById(Long usuarioId) {
            usuarioRepository.deleteById(usuarioId);
    }
}
