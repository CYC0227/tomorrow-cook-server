package tomorrowcook.mp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import tomorrowcook.mp.domain.Member;
import tomorrowcook.mp.domain.Posting;
import tomorrowcook.mp.service.PostingService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    //추가


    @PostMapping(value = "/postings/new")
    public String create(@RequestBody PostingForm form, BindingResult result) {

        Posting posting = new Posting();

        posting.setTitle(form.getTitle());
        posting.setImgURL(form.getImgURL());
        posting.setDescription(form.getDescription());
        posting.setInformation(form.getInformation());
        posting.setIngredients_name(form.getIngredients_name());
        posting.setIngredients_quantity(form.getIngredients_quantity());

        postingService.join(posting);

        System.out.println(posting);

        return "redirect:/";
    }
}
