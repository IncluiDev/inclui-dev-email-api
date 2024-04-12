package incluiMaisEmailApi.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import incluiMaisEmailApi.component.bodyEmail.Body;
import incluiMaisEmailApi.component.dependency.EmailDependency;
import incluiMaisEmailApi.component.validation.EmailExists;
import incluiMaisEmailApi.dto.EmailDto;
import incluiMaisEmailApi.dto.NewsletterDto;
import incluiMaisEmailApi.exception.ExceptionGeneric;
import incluiMaisEmailApi.exception.ResponseBody;
import incluiMaisEmailApi.repository.UsuarioRepository;

import static incluiMaisEmailApi.component.util.FactoryResponseBody.getResponse;

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
                            EmailDto
                                    .builder()
                                    .destinatario(usuario.getEmail())
                                    .assunto(newsletterDto.getAssunto())
                                    .texto(newsletterDto.getTexto())
                                    .build()
                    );
                });

        return getResponse("ENVIO DE NEWSLETTER CONCLUIDO", "ENVIO DE NEWSLETTER CONCLUIDO", 200);
    }

    public void sendEmailNewUser(String email) {
        sendEmail(
                EmailDto
                        .builder()
                        .destinatario(email)
                        .assunto("Inclui+ - Boas Vindas!")
                        .texto(Body.toString(Body.NEW_USER))
                        .build()
        );
    }
}
