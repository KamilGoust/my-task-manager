package pl.coderslab.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation
        .web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/admin/**").hasAnyRole("USER","ADMIN")
//                .anyRequest().permitAll()
//                .and().formLogin()
//                .loginPage("/login");

        .antMatchers("/task/**").authenticated()
                .anyRequest().permitAll()
                .and().formLogin().defaultSuccessUrl("/task/dashboard")
                .loginPage("/login").and().logout().logoutSuccessUrl("/login")
                .permitAll();

//        .antMatchers("/task/**").hasRole("ADMIN").and().formLogin().defaultSuccessUrl("/task/dashboard")
//                .loginPage("/login").and().logout().logoutSuccessUrl("/login")
//                .permitAll();
    }


    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
