package ovenbreak.ckrun.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ovenbreak.ckrun.config.auth.dto.SessionUser;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final HttpSession httpSession;

    @RequestMapping({"/", "index"})
    public String home(Model model){
//        log.debug("HomeController 실행");
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user!=null){
            log.debug("user={}", user.getName());
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
}
