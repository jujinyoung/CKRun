package ovenbreak.ckrun.service.cookies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ovenbreak.ckrun.domain.cookies.Cookies;
import ovenbreak.ckrun.domain.cookies.CookiesTag;

import java.util.List;

@Getter
@AllArgsConstructor
public class CookiesInfo {

    private Cookies cookie;
    private List<CookiesTag> tags;
}
