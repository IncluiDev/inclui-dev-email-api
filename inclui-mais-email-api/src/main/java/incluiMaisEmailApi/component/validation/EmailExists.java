package incluiMaisEmailApi.component.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import incluiMaisEmailApi.exception.ExceptionGeneric;
import incluiMaisEmailApi.repository.UsuarioRepository;

@Component
@RequiredArgsConstructor
public class EmailExists {
    private final UsuarioRepository usuarioRepository;

    public void isValid(String email) {
        if(!usuarioRepository.existsByEmail(email))
            throw new ExceptionGeneric("EMAIL INVALIDO", "EMAIL INVALIDO", 404);
    }
}
