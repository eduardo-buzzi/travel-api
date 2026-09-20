package br.com.travelapi.config;

import br.com.travelapi.model.Usuario;
import br.com.travelapi.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

@Bean
CommandLineRunner criarUsuarios(
        UsuarioRepository usuarioRepository,
        PasswordEncoder passwordEncoder) {

    return args -> {

        if (usuarioRepository.findByUsername("admin").isEmpty()) {

            Usuario admin = new Usuario(
                    "admin",
                    passwordEncoder.encode("admin123"),
                    "ADMIN"
            );

            usuarioRepository.save(admin);
        }

        if (usuarioRepository.findByUsername("usuario").isEmpty()) {

            Usuario usuario = new Usuario(
                    "usuario",
                    passwordEncoder.encode("usuario123"),
                    "USER"
            );

            usuarioRepository.save(usuario);
        }
    };
}

}
