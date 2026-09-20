package br.com.travelapi.config;

import br.com.travelapi.model.Usuario;
import br.com.travelapi.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

private final UsuarioRepository usuarioRepository;

public SecurityConfig(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
}

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

@Bean
public UserDetailsService userDetailsService() {

    return username -> {

        Usuario usuario = usuarioRepository
                .findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Usuário não encontrado"
                        )
                );

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRole())
                .build();
    };
}

@Bean
public SecurityFilterChain securityFilterChain(
        HttpSecurity http) throws Exception {

    http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                    .requestMatchers(
                            "/destinos",
                            "/destinos/{id}"
                    ).permitAll()

                    .requestMatchers(
                            "/destinos/{id}/avaliacao"
                    ).hasAnyRole("USER", "ADMIN")

                    .requestMatchers(
                            "/destinos/**"
                    ).hasRole("ADMIN")

                    .anyRequest().authenticated()
            )

            .httpBasic(httpBasic -> {});

    return http.build();
}

}
