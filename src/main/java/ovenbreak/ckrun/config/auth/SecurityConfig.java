package ovenbreak.ckrun.config.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ovenbreak.ckrun.domain.member.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .headers().frameOptions().disable()
               .and()
               .authorizeRequests()
               .antMatchers("/error",
                       "/favicon.ico",
                       "/**/*.png",
                       "/**/*.gif",
                       "/**/*.svg",
                       "/**/*.jpg",
                       "/**/*.html",
                       "/**/*.css",
                       "/**/*.js",
                       "/",
                       "/home/**",
                       "/test/**")
               .permitAll()
               .antMatchers("/member").permitAll()
               .antMatchers("/cookies").permitAll()
               .antMatchers("/mytravel/**").hasRole(Role.GUEST.name()) // 인증 url 패턴
//               .anyRequest().authenticated()
               .and()
               .logout().clearAuthentication(true).deleteCookies("user")
               .invalidateHttpSession(true).logoutSuccessUrl("/")
               .and()
               .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
