package tomorrowcook.mp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tomorrowcook.mp.domain.Ingredients;
import tomorrowcook.mp.domain.Member;
import tomorrowcook.mp.domain.Posting;
import tomorrowcook.mp.service.IngredService;
import tomorrowcook.mp.service.MemberService;
import tomorrowcook.mp.service.PostingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostingController {

    private final MemberService memberService;
    private final PostingService postingService;
    private final IngredService ingredService;

    //추가


    @GetMapping(value = "/postings/postingList")
    public List<PostingForm> postingForms(@RequestParam("email") String email) {

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
            String anniversary = p.getAnniversary();
            String country = p.getCountry();
            String videoURL = p.getVideoURL();

            postingForm = new PostingForm(imgURL1, title1, description1, information1, ingredients_name1, ingredients_quantity1, anniversary, country, videoURL);

            postingForms.add(postingForm);
        }

        return postingForms;
    }


    @GetMapping(value = "/postings/postingList/anniv")
    public List<PostingForm> postingsWithAnniv(@RequestParam("anniv") String anniv) {

        List<Posting> postings = postingService.findByAnniversary(anniv);
        List<PostingForm> postingForms = new ArrayList<>();
        PostingForm postingForm;

        for (Posting p : postings) {
            String imgURL1 = p.getImgURL();
            String title1 = p.getTitle();
            String description1 = p.getDescription();
            String information1 = p.getInformation();
            String ingredients_name1 = p.getIngredients_name();
            String ingredients_quantity1 = p.getIngredients_quantity();
            String anniversary = p.getAnniversary();
            String country = p.getCountry();
            String videoURL = p.getVideoURL();

            postingForm = new PostingForm(imgURL1, title1, description1, information1, ingredients_name1, ingredients_quantity1, anniversary, country, videoURL);

            postingForms.add(postingForm);
        }

        return postingForms;
    }


    @GetMapping(value = "/postings/postingList/country")
    public List<PostingForm> postingsWithCountry(@RequestParam("country") String country) {

        List<Posting> postings = postingService.findByCountry(country);
        List<PostingForm> postingForms = new ArrayList<>();
        PostingForm postingForm;

        for (Posting p : postings) {
            String imgURL1 = p.getImgURL();
            String title1 = p.getTitle();
            String description1 = p.getDescription();
            String information1 = p.getInformation();
            String ingredients_name1 = p.getIngredients_name();
            String ingredients_quantity1 = p.getIngredients_quantity();
            String anniversary = p.getAnniversary();
            String country1 = p.getCountry();
            String videoURL = p.getVideoURL();

            postingForm = new PostingForm(imgURL1, title1, description1, information1, ingredients_name1, ingredients_quantity1, anniversary, country1, videoURL);

            postingForms.add(postingForm);
        }

        return postingForms;
    }

    //현재의 포스팅 폼과 맞지 않음. 수정필요
    @PostMapping(value = "/postings/new")//클라이언트에서 static 변수로 가지고있는 member를 폼에 자동으로 입력 후 여기로 전달됨
    public String create( @RequestBody PostingForm form, @RequestParam("email") String email, BindingResult result) {

        Posting posting = new Posting();

        posting.setTitle(form.getTitle());
        posting.setImgURL(form.getImgURL());
        posting.setDescription(form.getDescription());
        posting.setInformation(form.getInformation());

//        posting.setIngredients_name(form.getIngredients_name());
//        posting.setIngredients_quantity(form.getIngredients_quantity());

        Ingredients ingredients = new Ingredients();
        ingredients.setIngredients_name(form.getIngredients_name());
        ingredients.setIngredients_quantity(form.getIngredients_quantity(););



        Member findMember = memberService.findOne(email);

        posting.setMember(findMember);

        postingService.join(posting);

        System.out.println(posting);

        return "redirect:/";
    }
}
