package inclui_mais_email_api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewsletterDto {
    @NotNull @NotEmpty
    String assunto, texto;
}