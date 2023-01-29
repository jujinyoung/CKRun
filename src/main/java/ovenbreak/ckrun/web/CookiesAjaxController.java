package ovenbreak.ckrun.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ovenbreak.ckrun.service.cookies.CookiesService;

@RestController
@RequestMapping("/ajax")
@RequiredArgsConstructor
@Slf4j
public class CookiesAjaxController {

    private final CookiesService cookiesService;

    @PostMapping("/updateRecommend/{commentID}")
    public String updateRecommend(@PathVariable("commentID") int commentID){
        log.debug("updateRecommend실행");
        int recommend = cookiesService.updateRecommend(commentID);
        log.debug("추천수: {}", recommend);
        return ""+recommend;
    }


}
