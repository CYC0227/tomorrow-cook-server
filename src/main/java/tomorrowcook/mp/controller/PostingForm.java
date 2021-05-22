package tomorrowcook.mp.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class PostingForm {

    public PostingForm(String imgURL, String title, String description, String information, String ingredients_name, String ingredients_quantity){
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.information = information;
        this.ingredients_name = ingredients_name;
        this.ingredients_quantity = ingredients_quantity;
    }

    private String imgURL;
    private String title;
    private String description;
    private String information;
    private String ingredients_name;
    private String ingredients_quantity;
}
