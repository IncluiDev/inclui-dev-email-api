package inclui_mais_email_api.component.dependency;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import inclui_mais_email_api.dto.EmailDto;
import inclui_mais_email_api.exception.ExceptionGeneric;
import inclui_mais_email_api.mapper.EmailMapper;

@Component
@RequiredArgsConstructor
public class EmailDependency {
    private final JavaMailSender javaMailSender;
    private final EmailMapper emailMapper;

    public void sendEmail(EmailDto emailDTO) {
        try {
            javaMailSender.send(emailMapper.toMapper(emailDTO, javaMailSender));
        } catch (Exception ignored) {
            throw new ExceptionGeneric("FALHA NO SERVICO DE EMAIL", "FALHA NO SERVICO DE EMAIL", 500);
        }
    }
}
