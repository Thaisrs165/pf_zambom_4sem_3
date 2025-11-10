package br.edu.insper.pf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

    // 🔓 Libera CORS para permitir que o front (Vite) acesse o back
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // URL do seu front-end
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    // 🔐 Configuração de segurança com Auth0
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Endpoints públicos (se quiser deixar alguns abertos)
                        .requestMatchers("/public/**").permitAll()
                        // Todos os outros exigem autenticação via JWT
                        .anyRequest().authenticated()
                )
                // Desativa CSRF (necessário para APIs REST)
                .csrf(AbstractHttpConfigurer::disable)
                // Ativa o CORS que configuramos acima
                .cors(Customizer.withDefaults())
                // Configura o Resource Server para validar tokens JWT do Auth0
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())
                );

        return http.build();
    }
}
