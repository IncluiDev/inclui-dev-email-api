package incluidevemail.application.controller;

import incluidevemail.application.service.EmailService;
import incluidevemail.data.dto.EmailDto;
import incluidevemail.data.dto.NewsletterDto;
import incluidevemail.data.dto.RecuperacaoSenhaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import incluidevemail.component.exception.ResponseBody;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/email")
    public ResponseEntity<Void> sendEmail(@RequestBody EmailDto email) {
        emailService.sendEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping("/newsletter")
    public ResponseEntity<ResponseBody> sendNewsletter(@RequestBody NewsletterDto newsletter) {
        return ResponseEntity.status(HttpStatus.OK).body(emailService.sendNewsletter(newsletter));
    }

    @PostMapping("/recuperacao")
    public ResponseEntity<Void> sendRecuperacaoSenha(@RequestBody RecuperacaoSenhaDto recuperacaoSenha) {
        emailService.sendRecuperacaoSenha(recuperacaoSenha);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
