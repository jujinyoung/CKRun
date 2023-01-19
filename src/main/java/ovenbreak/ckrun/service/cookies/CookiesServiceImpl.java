package ovenbreak.ckrun.service.cookies;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import ovenbreak.ckrun.com.paging.PageService;
import ovenbreak.ckrun.domain.cookies.Cookies;
import ovenbreak.ckrun.domain.cookies.CookiesTag;
import ovenbreak.ckrun.repository.cookies.CookiesMapper;
import ovenbreak.ckrun.repository.cookies.CookiesTagMapper;
import ovenbreak.ckrun.service.cookies.dto.CookiesInfo;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CookiesServiceImpl implements CookiesService{

    private final CookiesMapper cookiesMapper;
    private final CookiesTagMapper cookiesTagMapper;
    @Override
    public List<CookiesInfo> getCookies() {
        List<Cookies> allCookies = cookiesMapper.findAllCookies();
        return getCookiesInfos(allCookies);
    }

    @Override
    public List<CookiesInfo> getCookies(int currentPage, int numberPerPage) {

        int begin = PageService.begin(currentPage, numberPerPage);
        int end = PageService.end(currentPage, numberPerPage);
        List<Cookies> allCookies = cookiesMapper.selectCookiesList(begin, end);
        return getCookiesInfos(allCookies);
    }

    @Override
    public List<CookiesInfo> getCookies(int currentPage, int numberPerPage, String searchWord) {

        int begin = PageService.begin(currentPage, numberPerPage);
        int end = PageService.end(currentPage, numberPerPage);
        List<Cookies> allCookies = cookiesMapper.searchCookiesList(begin, end, searchWord);
        return getCookiesInfos(allCookies);
    }

    private List<CookiesInfo> getCookiesInfos(List<Cookies> allCookies) {
        List<CookiesInfo> cookiesInfoList = new ArrayList<>();
        for (Cookies cookie: allCookies) {
            List<CookiesTag> cookiesTags = cookiesTagMapper.findByID(cookie.getCkID());
            cookiesInfoList.add(new CookiesInfo(cookie, cookiesTags));
        }

        return cookiesInfoList;
    }

    @Override
    public int getTotalCookies() {
        return cookiesMapper.getTotalRecords();
    }

    @Override
    public int getTotalCookies(String searchWord) {
        return cookiesMapper.getSearchRecords(searchWord);
    }

    @Override
    public List<CookiesInfo> getCookiesByTagName(int currentPage, int numberPerPage, String searchWord) {

        int begin = PageService.begin(currentPage, numberPerPage);
        int end = PageService.end(currentPage, numberPerPage);
        List<CookiesTag> tagNames = cookiesTagMapper.findByTagName(begin, end, searchWord);
        List<Cookies> cookies = new ArrayList<>();

        for (CookiesTag tagName: tagNames) {
            Cookies cookie = cookiesMapper.findCookiesByID(tagName.getCkID());
            cookies.add(cookie);
        }

        return getCookiesInfos(cookies);
    }

    @Override
    public int getTotalCookiesByTagName(String searchWord) {
        return cookiesTagMapper.getTotalRecords(searchWord);
    }


}
