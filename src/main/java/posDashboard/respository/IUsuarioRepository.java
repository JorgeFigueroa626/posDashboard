package posDashboard.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posDashboard.model.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    //establecemos un method
    public Usuario findByUsername(String username);
}
