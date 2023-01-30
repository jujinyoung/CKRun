package ovenbreak.ckrun.service.cookies;

import ovenbreak.ckrun.config.auth.dto.SessionUser;
import ovenbreak.ckrun.domain.cookies.CookiesComment;
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

    List<CookiesInfo> getCookie(int ckID);

    List<CookiesComment> getComments(int ckID);

    List<CookiesComment> getBestComments(int ckID);

    void writeComment(int ckID, SessionUser user, int grade, String content);

    int updateRecommend(int commentID);
}
