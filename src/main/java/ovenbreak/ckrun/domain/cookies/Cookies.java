package ovenbreak.ckrun.domain.cookies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor
public class Cookies {

    private int ckID;
    private String name;
    private String rank;
    private String skill;
    private String ckImage;
    private int rankLevel;
    private int startHealth;
    private int endHealth;
    private LocalDate rdate;
    private float grade;
    private int comment;
}
