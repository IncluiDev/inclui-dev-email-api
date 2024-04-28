package incluidevemail.application.controller;

import incluidevemail.application.service.UsuarioService;
import incluidevemail.data.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import incluidevemail.component.exception.ResponseBody;

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