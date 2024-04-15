package com.data.mapper;

import org.springframework.beans.BeanUtils;
import com.data.dto.UsuarioDto;
import com.data.model.UsuarioModel;

public class UsuarioMapper {
    public static UsuarioModel toMapper(UsuarioDto objetoEntrada) {
        UsuarioModel objetoSaida = new UsuarioModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }
}
