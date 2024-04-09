package inclui_mais_email_api.component.util;

import inclui_mais_email_api.exception.ResponseBody;

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
