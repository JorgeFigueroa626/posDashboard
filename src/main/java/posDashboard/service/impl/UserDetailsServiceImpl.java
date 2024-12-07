package posDashboard.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import posDashboard.model.entity.Usuario;
import posDashboard.respository.IUsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private  final IUsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByUsername(username);
        if (usuario == null) {
            throw  new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }
}
