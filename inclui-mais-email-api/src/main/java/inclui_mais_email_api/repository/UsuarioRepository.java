package inclui_mais_email_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import inclui_mais_email_api.model.UsuarioModel;


@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioModel, String> {
    boolean existsByEmail(String email);
    void deleteByEmail(String email);
}
