package tomorrowcook.mp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tomorrowcook.mp.domain.Member;
import tomorrowcook.mp.domain.Posting;
import tomorrowcook.mp.service.MemberService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

//    //추가
//    @GetMapping(value = "/members")
//    public String list(Model model) {
//        List<Member> members = memberService.findMembers();
//        model.addAttribute("members", members);
//        return "members/memberList";
//    }
//
//
//    @GetMapping(value = "/members/new")
//    public String createForm(Model model) {
//        model.addAttribute("memberForm", new MemberForm());
//        return "members/createMemberForm";
//    }

    @PostMapping(value = "/members/new")
    public String create(@RequestBody MemberForm form, BindingResult result) {

        Member member = new Member();
        member.setName(form.getName());
        member.setEmail(form.getEmail());
        member.setPw(form.getPw());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members/login")
    public boolean memberLogin(@RequestParam("email") String email,@RequestParam("pw") String pw ) {

        try{
            Member findMember = memberService.findOne(email);
            String email1 = findMember.getEmail();
            String pw1 = findMember.getPw();

            if(email1.equals(email) && pw1.equals(pw))
                return true;
            else
                return false;
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }


//        PostingForm ex = new PostingForm();
//        ex.setDescription("this is real");
    }

}