package posDashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import posDashboard.model.entity.Rol;
import posDashboard.model.entity.Usuario;
import posDashboard.model.entity.UsuarioRol;
import posDashboard.service.interfaces.IUsuarioService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    //@Autowired
    private final IUsuarioService usuarioService ;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listUsuarios(){
        return usuarioService.listUsuarios();
    }

    //@GetMapping("/{usuarioId}")
    public Usuario usuarioById(@PathVariable Long usuarioId){
        return usuarioService.usuarioById(usuarioId);
    }

    @GetMapping("/{username}")
    public Usuario usuarioByUsername(@PathVariable String username){
        return  usuarioService.usuarioByUsername(username);
    }

    @PostMapping("/")
    public Usuario saveUsuario(@RequestBody Usuario usuario) throws Exception{
        usuario.setFoto("perfil.png");
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setRolNombre("USER");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);

        return  usuarioService.saveUsuario(usuario, usuarioRoles);
    }

    @DeleteMapping("/{usuarioId}")
    public void deleteUsuario(@PathVariable Long usuarioId) {
        usuarioService.deleteUsuarioById(usuarioId);
    }
}
