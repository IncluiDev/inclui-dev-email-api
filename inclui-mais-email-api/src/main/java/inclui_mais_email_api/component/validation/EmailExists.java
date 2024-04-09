package inclui_mais_email_api.component.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import inclui_mais_email_api.exception.ExceptionGeneric;
import inclui_mais_email_api.repository.UsuarioRepository;

@Component
@RequiredArgsConstructor
public class EmailExists {
    private final UsuarioRepository usuarioRepository;

    public void isValid(String email) {
        if(!usuarioRepository.existsByEmail(email))
            throw new ExceptionGeneric("EMAIL INVALIDO", "EMAIL INVALIDO", 404);
    }
}
