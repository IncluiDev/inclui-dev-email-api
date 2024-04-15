package com.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.data.dto.EmailDto;
import com.data.dto.NewsletterDto;
import com.component.exception.ResponseBody;
import com.application.service.EmailService;

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
