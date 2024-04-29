package incluidevemail.data.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecuperacaoSenhaDto {
    @NotNull @NotEmpty @Email
    String email;

    @NotNull @NotEmpty
    String codigo;
}