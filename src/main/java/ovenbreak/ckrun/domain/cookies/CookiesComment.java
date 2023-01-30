package ovenbreak.ckrun.domain.cookies;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CookiesComment {

    private int commentID;
    private int ckID;
    private String email;
    private String nickname;
    private int grade;
    private LocalDate rdate;
    private String content;
    private int recommend;
    private int ref;
    private int step;
    private int depth;
}
