package tech.ada.combustivel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.ada.combustivel.dto.NovoUsuarioDTO;
import tech.ada.combustivel.service.UsuarioService;


@SpringBootApplication
public class CombustivelApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService servico;

	public static void main(String... args) {
		SpringApplication.run(CombustivelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		NovoUsuarioDTO dto = new NovoUsuarioDTO();
		dto.setPass("admin");
		dto.setNome("admin");
		dto.setEmail("admin@combustivel.com.br");
		servico.salvar(dto);
	}
}
