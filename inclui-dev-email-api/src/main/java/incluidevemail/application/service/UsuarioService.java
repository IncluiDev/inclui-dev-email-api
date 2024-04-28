package incluidevemail.application.service;

import incluidevemail.application.repository.UsuarioRepository;
import incluidevemail.data.dto.UsuarioDto;
import incluidevemail.data.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import incluidevemail.component.exception.ExceptionGeneric;
import incluidevemail.component.exception.ResponseBody;

import static incluidevemail.component.util.FactoryResponseBody.getResponse;

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