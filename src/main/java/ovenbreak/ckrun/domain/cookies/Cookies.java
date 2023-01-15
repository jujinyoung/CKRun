package ovenbreak.ckrun.domain.cookies;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Cookies {

    private String name;
    private String rank;
    private String skill;
    private String ckImage;
    private Date edate;
}
