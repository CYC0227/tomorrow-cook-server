package tomorrowcook.mp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tomorrowcook.mp.domain.Member;
import tomorrowcook.mp.domain.Posting;
import tomorrowcook.mp.service.MemberService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //추가
    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


    @GetMapping(value = "/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(@RequestBody MemberForm form, BindingResult result) {

        Member member = new Member();
        member.setName(form.getName());
        member.setEmail(form.getEmail());
        member.setPw(form.getPw());

        memberService.join(member);
        return "redirect:/";
    }

}