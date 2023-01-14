package ovenbreak.ckrun.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ovenbreak.ckrun.domain.member.Member;
import ovenbreak.ckrun.repository.member.MemberMapper;

public interface MemberService {

    public void save(Member member);

    public void login(String email, String password);
}
