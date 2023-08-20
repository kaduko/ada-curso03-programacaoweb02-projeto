package tech.ada.combustivel.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.ada.combustivel.dto.UsuarioDetailsInfo;
import tech.ada.combustivel.model.Usuario;
import tech.ada.combustivel.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public UserDetailServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUser = repository.findByEmail(username);
        return new UsuarioDetailsInfo(optionalUser.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado")));
    }
}
