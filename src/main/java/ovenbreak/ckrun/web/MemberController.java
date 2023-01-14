package ovenbreak.ckrun.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovenbreak.ckrun.domain.member.Member;
import ovenbreak.ckrun.service.member.MemberService;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm(){
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password){

        memberService.login(email, password);
        return "/index";
    }

    @GetMapping("/register")
    public String registerForm(){
        return "member/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Member member,
                           Model model){
        log.debug("회원 정보 member = {}", member.toString());
        if (!member.pwdCheck()){
            log.debug("회원 등록 비밀번호 서로다름");
            model.addAttribute("success", "비밀번호 확인이 올바르지 않습니다.");
            return "member/register";
        } else if (member.getPassword().length() < 8) {
            log.debug("회원 등록 비밀번호 자리수가 너무 짧음");
            model.addAttribute("success", "비밀번호는 최소 8자리 이상으로 입력해주세요.");
            return "member/register";
        }

        memberService.save(member);
        return "redirect:login";
    }
}
