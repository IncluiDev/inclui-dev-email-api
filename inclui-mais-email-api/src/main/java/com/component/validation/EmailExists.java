package com.component.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.component.exception.ExceptionGeneric;
import com.application.repository.UsuarioRepository;

@Component
@RequiredArgsConstructor
public class EmailExists {
    private final UsuarioRepository usuarioRepository;

    public void isValid(String email) {
        if(!usuarioRepository.existsByEmail(email))
            throw new ExceptionGeneric("EMAIL INVALIDO", "EMAIL INVALIDO", 404);
    }
}
