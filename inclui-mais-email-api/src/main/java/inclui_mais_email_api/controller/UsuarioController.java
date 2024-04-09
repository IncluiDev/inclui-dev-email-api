package inclui_mais_email_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import incluiEmailApi.dto.UsuarioDto;
import incluiEmailApi.exception.ResponseBody;
import incluiEmailApi.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ResponseBody> save(@RequestBody UsuarioDto usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @DeleteMapping
    public ResponseEntity<ResponseBody> delete(@RequestBody UsuarioDto usuario) {
        usuarioService.delete(usuario);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}