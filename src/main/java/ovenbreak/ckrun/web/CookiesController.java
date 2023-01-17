package ovenbreak.ckrun.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ovenbreak.ckrun.config.auth.dto.SessionUser;
import ovenbreak.ckrun.domain.cookies.Cookies;
import ovenbreak.ckrun.service.cookies.CookiesService;
import ovenbreak.ckrun.service.cookies.dto.CookiesInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cookies")
@RequiredArgsConstructor
public class CookiesController {

    private final CookiesService cookiesService;
    private final HttpSession httpSession;

    @GetMapping
    public String list(Model model){
        //세션 처리
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user!=null){
            log.debug("user={}", user.getName());
            model.addAttribute("userName", user.getName());
        }

        //서비스
        List<CookiesInfo> cookiesInfoList = cookiesService.getCookies();

        model.addAttribute(cookiesInfoList);

        return "cookies/list";
    }
}
