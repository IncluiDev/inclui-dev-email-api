package com.component.dependency;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.data.dto.EmailDto;
import com.component.exception.ExceptionGeneric;
import com.data.mapper.EmailMapper;

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
