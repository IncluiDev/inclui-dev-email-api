package com.component.util;

import com.component.exception.ResponseBody;

public class FactoryResponseBody {
    public static ResponseBody getResponse(String titulo, String mensagem, int status) {
        return ResponseBody
                .builder()
                .title(titulo)
                .message(mensagem)
                .status(status)
                .build();
    }
}
