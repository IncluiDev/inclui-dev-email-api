package inclui_mais_email_api.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import inclui_mais_email_api.dto.UsuarioDto;
import inclui_mais_email_api.exception.ExceptionGeneric;
import inclui_mais_email_api.exception.ResponseBody;
import inclui_mais_email_api.mapper.UsuarioMapper;
import inclui_mais_email_api.repository.UsuarioRepository;

import static inclui_mais_email_api.component.util.FactoryResponseBody.getResponse;

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