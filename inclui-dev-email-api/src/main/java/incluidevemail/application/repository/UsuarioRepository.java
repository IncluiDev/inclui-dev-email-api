package incluidevemail.application.repository;

import incluidevemail.data.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {
    boolean existsByEmail(String email);
    void deleteByEmail(String email);
}
