package tech.ada.combustivel.dto.parser;

import tech.ada.combustivel.dto.NovoUsuarioDTO;
import tech.ada.combustivel.dto.UsuarioDTO;
import tech.ada.combustivel.model.Usuario;

public class UsuarioDTOParser {

    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail(usuario.getEmail());
        dto.setNome(usuario.getNome());
        dto.setId(usuario.getId());
        return dto;
    }

    public static NovoUsuarioDTO toNovoUsuarioDTO(Usuario user) {
        NovoUsuarioDTO dto = new NovoUsuarioDTO();
        dto.setPass(user.getPassword());
        dto.setNome(user.getNome());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static Usuario toUsuarioEntity(NovoUsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setPassword(dto.getPass());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
