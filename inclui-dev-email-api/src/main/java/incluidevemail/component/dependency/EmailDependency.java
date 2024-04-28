package incluidevemail.component.dependency;

import incluidevemail.data.dto.EmailDto;
import incluidevemail.data.mapper.EmailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import incluidevemail.component.exception.ExceptionGeneric;

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
