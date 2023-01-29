package ovenbreak.ckrun.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovenbreak.ckrun.com.paging.PageBlock;
import ovenbreak.ckrun.com.paging.PageService;
import ovenbreak.ckrun.config.auth.dto.SessionUser;
import ovenbreak.ckrun.domain.cookies.CookiesComment;
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
    public String list(Model model,
                       @RequestParam(defaultValue = "1") int currentPage,
                       @RequestParam(defaultValue = "10") int numberPerPage,
                       @RequestParam(defaultValue = "") String searchWord){
        //세션 처리
        loginCheck(model);

        //서비스
        List<CookiesInfo> cookiesInfoList = null;
        int totalCookies;
        log.debug(searchWord);
        if (searchWord.isEmpty()){
            cookiesInfoList = cookiesService.getCookies(currentPage, numberPerPage);
            totalCookies = cookiesService.getTotalCookies();
        }else{
            if (searchWord.charAt(0) == '#'){
                String word = searchWord.substring(1);
                cookiesInfoList = cookiesService.getCookiesByTagName(currentPage, numberPerPage, word);
                totalCookies = cookiesService.getTotalCookiesByTagName(word);
            }else {
                cookiesInfoList = cookiesService.getCookies(currentPage, numberPerPage, searchWord);
                totalCookies = cookiesService.getTotalCookies(searchWord);
            }
        }

        //페이징 처리
        int totalPages = (int) Math.ceil((double) totalCookies/numberPerPage);
        PageBlock pageBlock = PageService.pagingService(currentPage, numberPerPage, 10, totalPages);
        log.debug("totalCookies = {}", totalCookies);

        model.addAttribute(cookiesInfoList);
        model.addAttribute("pageBlock", pageBlock);
        model.addAttribute("totalCookies", totalCookies);
        model.addAttribute("searchWord", searchWord);

        return "cookies/list";
    }

    private SessionUser loginCheck(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null){
            log.debug("user={}", user.getName());
            model.addAttribute("userName", user.getName());
            return user;
        }

        return null;
    }

    @GetMapping("/{ckID}")
    public String cookie(@PathVariable("ckID") int ckID,
                         Model model){
        List<CookiesInfo> cookiesInfo = cookiesService.getCookie(ckID);
        List<CookiesComment> comments = cookiesService.getComments(ckID);
        List<CookiesComment> bestComments = cookiesService.getBestComments(ckID);

        model.addAttribute("cookiesInfo", cookiesInfo);
        model.addAttribute("comments", comments);
        model.addAttribute("bestComments", bestComments);
        return "cookies/cookie";
    }

    @PostMapping("/{ckID}")
    public String cookieComment(@PathVariable("ckID") int ckID,
                                Model model,
                                @RequestParam String comment,
                                @RequestParam int grade){
        SessionUser user = loginCheck(model);
        cookiesService.writeComment(ckID, user, grade, comment);
        return "redirect:{ckID}";
    }
}
