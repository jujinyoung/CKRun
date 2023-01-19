package ovenbreak.ckrun.service.cookies;

import ovenbreak.ckrun.domain.cookies.Cookies;
import ovenbreak.ckrun.service.cookies.dto.CookiesInfo;

import java.util.List;

public interface CookiesService {

    List<CookiesInfo> getCookies();

    List<CookiesInfo> getCookies(int currentPage, int numberPerPage);

    List<CookiesInfo> getCookies(int currentPage, int numberPerPage, String searchWord);

    int getTotalCookies();

    int getTotalCookies(String searchWord);

    List<CookiesInfo> getCookiesByTagName(int currentPage, int numberPerPage, String searchWord);

    int getTotalCookiesByTagName(String searchWord);
}
