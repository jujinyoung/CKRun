package ovenbreak.ckrun.domain.member;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@ToString
public class Member {
    private String email;
    private String nickname;
    private String password;
    private Role role;

    private String passwordCheck;

    public Member() {
    }

    @Builder
    public Member(String email, String nickname,Role role) {
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }

    public Member(String email, String nickname, String password, Role role) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
    }

    public boolean pwdCheck(){
        if (password.equals(passwordCheck)){
            return true;
        }
        return false;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
