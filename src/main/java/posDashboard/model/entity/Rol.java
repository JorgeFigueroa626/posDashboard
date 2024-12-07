package posDashboard.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    private Long rolId;
    private  String rolNombre;

    //OneToMany = Relacion de Uno rol a Muchos usuarioRol
    //CascadeType-ALL = Si eliminar un rol, se eliminara todos los registro relacionados en la tabla usuarioRol
    //FetchType-LAZY = Indicamos para que retorne todos los registro y relaciones de la tabla roles
    //mappedBy = Apunta al propietario de la relacion que es "rol"
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Rol() {
    }


    public Rol(Long rolId, String rolNombre, Set<UsuarioRol> usuarioRoles) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.usuarioRoles = usuarioRoles;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
}
