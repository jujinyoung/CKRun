package ovenbreak.ckrun.config.cookies;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ovenbreak.ckrun.repository.cookies.CookiesCommentMapper;
import ovenbreak.ckrun.repository.cookies.CookiesMapper;
import ovenbreak.ckrun.repository.cookies.CookiesTagMapper;
import ovenbreak.ckrun.service.cookies.CookiesService;
import ovenbreak.ckrun.service.cookies.CookiesServiceImpl;

@Configuration
@RequiredArgsConstructor
public class CookiesConfig {

    private final CookiesMapper cookiesMapper;
    private final CookiesTagMapper cookiesTagMapper;
    private final CookiesCommentMapper cookiesCommentMapper;

    @Bean
    public CookiesService cookiesService(){
        return new CookiesServiceImpl(cookiesMapper, cookiesTagMapper, cookiesCommentMapper);
    }
}
