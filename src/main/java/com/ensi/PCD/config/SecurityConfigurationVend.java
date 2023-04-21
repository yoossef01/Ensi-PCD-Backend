package com.ensi.PCD.config;
/*
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfigurationVend {
    private final JwtVendeurAuthFilter jwtVendAuthFilter;
    private final AppVendeurConfiguration appVendeurConfiguration;
    private final LogoutHandler logoutHandler;
   public SecurityConfigurationVend(@Qualifier("authenticationProviderVend") AuthenticationProvider authenticationProvider,
                                     JwtVendeurAuthFilter jwtVendeurAuthFilter,LogoutHandler logoutHandler ){
        this.jwtVendAuthFilter=jwtVendeurAuthFilter;
        this.authenticationProvider=authenticationProvider;
        this.logoutHandler=logoutHandler;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/**")
                .permitAll()


                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS)
               .and()
                .authenticationProvider(AppVendeurConfiguration.authenticationProvider())
                .addFilterBefore(jwtVendAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/api/v1/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
        ;

        return http.build();
    }
}*/
