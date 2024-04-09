package inclui_mais_email_api.mapper;

import org.springframework.beans.BeanUtils;
import inclui_mais_email_api.dto.UsuarioDto;
import inclui_mais_email_api.model.UsuarioModel;

public class UsuarioMapper {
    public static UsuarioModel toMapper(UsuarioDto objetoEntrada) {
        UsuarioModel objetoSaida = new UsuarioModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }
}
