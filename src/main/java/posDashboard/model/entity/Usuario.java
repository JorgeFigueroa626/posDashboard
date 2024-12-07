package posDashboard.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import posDashboard.security.Authority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private String email;
    private int telefono;
    private String foto;
    private boolean state = true;

    //OneToMany = Relacion de Uno usuario a Muchos usuarioRol
    //CascadeType-ALL = Si eliminar un usuario, se eliminara todos los registro relacionados en la tabla usuarioRol
    //FetchType-EAGER = Te retorna todos los registro y relaciones de la tabla usuarios
    //mappedBy = Apunta al propietario de la relacion que es "usuario"
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles = new HashSet<>(); //Obtiene los roles, para asignarlo al "usuario"

    public Usuario() {
    }

    public Usuario(Long usuarioId, String nombre, String apellido, String username, String password, String email, int telefono, String foto, boolean state, Set<UsuarioRol> usuarioRoles) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.foto = foto;
        this.state = state;
        this.usuarioRoles = usuarioRoles;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    //

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new HashSet<>();
        this.usuarioRoles.forEach(usuarioRol -> {
            autoridades.add(new Authority(usuarioRol.getRol().getRolNombre()));
        });
        return  autoridades;
    }
    //

    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
}
