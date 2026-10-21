package com.depaya.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    // Lee las URLs permitidas desde tu application.properties
    @Value("${depaya.cors.origenes}")
    private List<String> corsOrigenes;

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Asigna los orígenes leídos
        config.setAllowedOrigins(corsOrigenes);

        // Permite los métodos HTTP estándar
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Permite todos los encabezados
        config.setAllowedHeaders(Arrays.asList("*"));

        // Permite credenciales (si usas tokens o cookies)
        config.setAllowCredentials(true);

        // Aplica esta configuración a todas las rutas de la API
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}