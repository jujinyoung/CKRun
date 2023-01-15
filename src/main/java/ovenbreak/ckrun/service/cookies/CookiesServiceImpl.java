package ovenbreak.ckrun.service.cookies;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
        List<CookiesInfo> cookiesInfoList = new ArrayList<>();
        for (Cookies cookie: allCookies) {
            List<CookiesTag> cookiesTags = cookiesTagMapper.findByName(cookie.getName());
            log.debug("cookieName = {}, cookieTags = {}", cookie.getName(), cookiesTags.get(0).getTagName());
            cookiesInfoList.add(new CookiesInfo(cookie, cookiesTags));
        }
        return cookiesInfoList;
    }
}
