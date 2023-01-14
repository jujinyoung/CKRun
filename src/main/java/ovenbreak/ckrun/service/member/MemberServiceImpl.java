package ovenbreak.ckrun.service.member;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ovenbreak.ckrun.domain.member.Member;
import ovenbreak.ckrun.repository.member.MemberMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public void save(Member member) {
        memberMapper.save(member);
        log.debug("회원가입완료 email = {}", member.getEmail());
    }

    @Override
    public void login(String email, String password) {
        memberMapper.login(email, password);
        log.debug("사용자 로그인 성공 email = {}, password = {}", email, password);
    }


}
