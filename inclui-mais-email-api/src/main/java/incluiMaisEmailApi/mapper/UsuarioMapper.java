package incluiMaisEmailApi.mapper;

import org.springframework.beans.BeanUtils;
import incluiMaisEmailApi.dto.UsuarioDto;
import incluiMaisEmailApi.model.UsuarioModel;

public class UsuarioMapper {
    public static UsuarioModel toMapper(UsuarioDto objetoEntrada) {
        UsuarioModel objetoSaida = new UsuarioModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }
}
