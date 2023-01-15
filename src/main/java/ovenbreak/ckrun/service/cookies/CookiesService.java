package ovenbreak.ckrun.service.cookies;

import ovenbreak.ckrun.domain.cookies.Cookies;
import ovenbreak.ckrun.service.cookies.dto.CookiesInfo;

import java.util.List;

public interface CookiesService {

    List<CookiesInfo> getCookies();
}
