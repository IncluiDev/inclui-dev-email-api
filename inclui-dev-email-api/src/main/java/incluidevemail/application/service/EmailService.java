package incluidevemail.application.service;

import incluidevemail.application.repository.UsuarioRepository;
import incluidevemail.data.dto.EmailDto;
import incluidevemail.data.dto.RecuperacaoSenhaDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import incluidevemail.component.util.BodyEmail;
import incluidevemail.component.dependency.EmailDependency;
import incluidevemail.component.validation.EmailExists;
import incluidevemail.data.dto.NewsletterDto;
import incluidevemail.component.exception.ExceptionGeneric;
import incluidevemail.component.exception.ResponseBody;

import static incluidevemail.component.util.FactoryResponseBody.getResponse;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailDependency emailDependency;
    private final EmailExists emailExists;
    private final UsuarioRepository usuarioRepository;

    @Retryable(value = ExceptionGeneric.class, maxAttempts = 4, backoff = @Backoff(delay = 100))
    public void sendEmail(@Valid EmailDto email) {
        emailExists.isValid(email.getDestinatario());
        emailDependency.sendEmail(email);
    }

    public ResponseBody sendNewsletter(@Valid NewsletterDto newsletterDto) {
        usuarioRepository
                .findAll()
                .forEach(usuario -> {
                    sendEmail(
                            new EmailDto(
                                    usuario.getEmail(),
                                    newsletterDto.getAssunto(),
                                    newsletterDto.getTexto()
                            )
                    );
                });

        return getResponse("ENVIO DE NEWSLETTER CONCLUIDO", "ENVIO DE NEWSLETTER CONCLUIDO", 200);
    }

    @Retryable(value = ExceptionGeneric.class, maxAttempts = 4, backoff = @Backoff(delay = 100))
    public void sendRecuperacaoSenha(@Valid RecuperacaoSenhaDto recuperacao) {
        emailExists.isValid(recuperacao.getEmail());

        emailDependency.sendEmail(
                new EmailDto(
                        recuperacao.getEmail(),
                        "IncluiDev - Recuperacao de Credenciais",
                        BodyEmail.toString(BodyEmail.PASSWORD).concat(recuperacao.getCodigo())
                )
        );
    }

    public void sendEmailNewUser(String email) {
        sendEmail(
                new EmailDto(
                        email,
                        "IncluiDev - Boas Vindas!",
                        BodyEmail.toString(BodyEmail.NEW_USER)
                )
        );
    }
}
