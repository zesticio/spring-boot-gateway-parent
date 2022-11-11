package in.zestic.gateway.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * since KeycloakAuthenticationProcessingFilter.java intercepts every request with an HTTP authorization header.
 * so if the request does not have the header "Bearer: ***" it will be rejected
 *
 * solutions is to simply register the filter of basic authentication before the keycloak filter is applied. This could
 * be easily done by using @Order annotation.
 */

@Order(1)                           //Order is 1 -> First the special case
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

//    /**
//     * in case you want to enable OAuth2 flow
//     * @param http
//     * @return
//     */
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//
//        http
//                .authorizeExchange()
//                .pathMatchers("/actuator/**").permitAll().and()//any pattern matching actuator we are going to permit all of them
//                .authorizeExchange().anyExchange().authenticated().and()//any other request should be authenticated
//                .oauth2Login();
//        http.csrf().disable();
//        return http.build();
//    }

    /**
     * for basic authentication
     * @param http
     * @return
     */
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        http
                .authorizeExchange()
                .pathMatchers("/actuator/**").permitAll()
                .pathMatchers("/swagger-ui.html").permitAll()
                .and()//any pattern matching actuator we are going to permit all of them
                .authorizeExchange().anyExchange().authenticated().and()//any other request should be authenticated
                .httpBasic();
        http.csrf().disable();
        http.cors().disable();
        return http.build();
    }

}
