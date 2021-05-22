package tomorrowcook.mp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tomorrowcook.mp.domain.Member;
import tomorrowcook.mp.domain.Posting;
import tomorrowcook.mp.service.PostingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    //추가


    @GetMapping(value = "/postings/postingList")
    public List<PostingForm> postingForms(@RequestParam String email) {

        List<Posting> postings = postingService.findUserPostings(email);
        List<PostingForm> postingForms = new ArrayList<>();
        PostingForm postingForm;

        for (Posting p : postings) {
            String imgURL1 = p.getImgURL();
            String title1 = p.getTitle();
            String description1 = p.getDescription();
            String information1 = p.getInformation();
            String ingredients_name1 = p.getIngredients_name();
            String ingredients_quantity1 = p.getIngredients_quantity();


            postingForm = new PostingForm(imgURL1, title1, description1, information1, ingredients_name1, ingredients_quantity1);

            postingForms.add(postingForm);
        }

//        PostingForm ex = new PostingForm();
//        ex.setDescription("this is real");
        return postingForms;
    }


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
