package inclui_mais_email_api.mapper;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import inclui_mais_email_api.component.dependency.EmailTreatment;
import inclui_mais_email_api.dto.EmailDto;

@Component
@RequiredArgsConstructor
public class EmailMapper {
    private final EmailTreatment emailTreatment;

    public MimeMessage toMapper(EmailDto objetoEntrada, JavaMailSender javaMailSender) {
        try {
            MimeMessage objetoSaida = javaMailSender.createMimeMessage();
            MimeMessageHelper objetoAuxiliar = new MimeMessageHelper(objetoSaida, false);

            objetoAuxiliar.setTo(objetoEntrada.getDestinatario());
            objetoAuxiliar.setSubject(objetoEntrada.getAssunto());
            objetoAuxiliar.setText(emailTreatment.getBody(objetoEntrada.getAssunto(), objetoEntrada.getTexto()), true); // -> content, <boolean_is_html?>

            return objetoSaida;
        } catch (Exception ignored) {
            return null;
        }
    }
}
