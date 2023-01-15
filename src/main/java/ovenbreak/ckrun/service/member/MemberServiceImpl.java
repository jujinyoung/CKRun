package ovenbreak.ckrun.service.member;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ovenbreak.ckrun.config.auth.dto.SessionUser;
import ovenbreak.ckrun.domain.member.Member;
import ovenbreak.ckrun.domain.member.Role;
import ovenbreak.ckrun.repository.member.MemberMapper;

import javax.servlet.http.HttpSession;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;
    private final HttpSession httpSession;

    @Override
    public void save(Member member) {
        member.setRole(Role.USER);
        memberMapper.save(member);
        log.debug("회원가입완료 email = {}", member.getEmail());
    }

    @Override
    public void login(String email, String password) {
        Member user = memberMapper.login(email, password);
        //세션 생성
        httpSession.setAttribute("user", new SessionUser(user));
        log.debug("사용자 로그인 성공 email = {}, password = {}", email, password);
    }


}
