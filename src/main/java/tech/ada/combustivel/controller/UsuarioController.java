package tech.ada.combustivel.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.ada.combustivel.dto.NovoUsuarioDTO;
import tech.ada.combustivel.dto.UsuarioDTO;
import tech.ada.combustivel.service.UsuarioService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody @Valid NovoUsuarioDTO usuario) {
        UsuarioDTO usuarioSalvo = service.salvar(usuario);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioSalvo.getId())
                .toUri();

        return ResponseEntity.created(uri).body(usuarioSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@RequestBody NovoUsuarioDTO usuario,
                                                @PathVariable Long id) {
        return ResponseEntity.ok(service.atualizar(usuario, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
