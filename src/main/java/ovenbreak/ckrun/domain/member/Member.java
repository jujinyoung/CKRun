package ovenbreak.ckrun.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Member {

    private long userID;
    private String nickname;
    private String email;
    private String password;

    private String passwordCheck;

    public Member(long userID, String nickname, String email, String password) {
        this.userID = userID;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public boolean pwdCheck(){
        if (password.equals(passwordCheck)){
            return true;
        }
        return false;
    }
}
