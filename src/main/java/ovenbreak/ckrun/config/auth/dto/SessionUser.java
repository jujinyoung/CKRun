package ovenbreak.ckrun.config.auth.dto;

import lombok.Getter;
import ovenbreak.ckrun.domain.member.Member;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name, email;

    public SessionUser(Member member) {
        this.name = member.getNickname();
        this.email = member.getEmail();
    }
}
