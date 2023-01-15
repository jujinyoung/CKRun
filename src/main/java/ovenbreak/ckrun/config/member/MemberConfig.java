package ovenbreak.ckrun.config.member;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ovenbreak.ckrun.repository.member.MemberMapper;
import ovenbreak.ckrun.service.member.MemberService;
import ovenbreak.ckrun.service.member.MemberServiceImpl;

import javax.servlet.http.HttpSession;

@Configuration
@RequiredArgsConstructor
public class MemberConfig {

    private final MemberMapper memberMapper;
    private final HttpSession httpSession;

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberMapper, httpSession);
    }
}
