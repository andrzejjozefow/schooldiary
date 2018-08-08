package pl.andrzejjozefow.schooldiary.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("student").password("123").roles("STUDENT_USER").and()
            .withUser("admin").password("123").roles("ADMIN").and()
            .withUser("teacher").password("123").roles("TEACHER_USER");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
            .authorizeRequests()
            .anyRequest()
            .fullyAuthenticated()
            .and()
            //.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
            .httpBasic();
        httpSecurity.csrf().disable();

    }

    @Bean
    public CustomFilter customFilter() {
        return new CustomFilter();
    }
}



