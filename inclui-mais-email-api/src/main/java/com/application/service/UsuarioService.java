package com.application.service;

import com.application.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.data.dto.UsuarioDto;
import com.component.exception.ExceptionGeneric;
import com.component.exception.ResponseBody;
import com.data.mapper.UsuarioMapper;

import static com.component.util.FactoryResponseBody.getResponse;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;

    @Transactional(rollbackFor = ExceptionGeneric.class)
    public ResponseBody save(@Valid UsuarioDto usuarioDto){
        emailService.sendEmailNewUser(
                usuarioRepository.save(
                        UsuarioMapper.toMapper(usuarioDto)
                ).getEmail()
        );

        return getResponse("USUARIO CADASTRADO", "USUARIO ESTA REGISTRADO PARA O RECEBIMENTO DE NEWSLETTER", 201);
    }

    @Transactional(rollbackFor = ExceptionGeneric.class)
    public void delete(@Valid UsuarioDto usuarioDto) {
        usuarioRepository.deleteByEmail(usuarioDto.getEmail());
    }
}