package inclui_mais_email_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import incluiEmailApi.dto.EmailDto;
import incluiEmailApi.dto.NewsletterDto;
import incluiEmailApi.exception.ResponseBody;
import incluiEmailApi.service.EmailService;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/email")
    public ResponseEntity<ResponseBody> sendEmail(@RequestBody EmailDto email) {
        emailService.sendEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping("/newsletter")
    public ResponseEntity<ResponseBody> sendNewsletter(@RequestBody NewsletterDto newsletter) {
        return ResponseEntity.status(HttpStatus.OK).body(emailService.sendNewsletter(newsletter));
    }
}
