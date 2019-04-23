package com.maven.pablo.reportingtool.security;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**","/index" )
                .permitAll()
                .antMatchers("/reports/**")
                .hasAnyRole("USER","LEADER")
                .antMatchers("/projects/**", "/employees/**")
                .hasRole("LEADER")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login-error")
        ;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails apk1 = User.withUsername("APK1")
                .password(encoder.encode("MSE1"))
                .roles("USER").build();

        UserDetails apk2 = User.withUsername("APK2")
                .password(encoder.encode("MSE2"))
                .roles("LEADER").build();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(apk1);
        manager.createUser(apk2);

        return manager;

    }
}