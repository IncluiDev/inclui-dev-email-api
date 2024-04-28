package incluidevemail.data.mapper;

import incluidevemail.data.dto.UsuarioDto;
import incluidevemail.data.model.UsuarioModel;
import org.springframework.beans.BeanUtils;

public class UsuarioMapper {
    public static UsuarioModel toMapper(UsuarioDto objetoEntrada) {
        UsuarioModel objetoSaida = new UsuarioModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }
}
