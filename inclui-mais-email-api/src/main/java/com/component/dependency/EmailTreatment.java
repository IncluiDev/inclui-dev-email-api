package com.component.dependency;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailTreatment {
    private final FileDependency fileDependency;

    public String getBody(String title, String body) {
        return fileDependency.read("email.txt")
                .replace("[TITLE]", title)
                .replace("[BODY]", body);
    }
}
