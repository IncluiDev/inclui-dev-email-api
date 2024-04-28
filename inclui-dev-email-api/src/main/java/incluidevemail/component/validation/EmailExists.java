package incluidevemail.component.validation;

import incluidevemail.application.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import incluidevemail.component.exception.ExceptionGeneric;

@Component
@RequiredArgsConstructor
public class EmailExists {
    private final UsuarioRepository usuarioRepository;

    public void isValid(String email) {
        if(!usuarioRepository.existsByEmail(email))
            throw new ExceptionGeneric("EMAIL INVALIDO", "EMAIL INVALIDO", 404);
    }
}
