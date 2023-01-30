package ovenbreak.ckrun.service.cookies;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ovenbreak.ckrun.domain.member.Member;
import ovenbreak.ckrun.repository.cookies.CookiesMapper;

import static org.assertj.core.api.Assertions.*;


class CookiesServiceImplTest {


    @Test
    void 테스트(){
        Member member = new Member();
        member.setEmail("주진영");
        assertThat(member.getEmail()).isEqualTo("주진영");
    }

}