package tomorrowcook.mp.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class PostingForm {


    PostingForm(){

    }

    public PostingForm(String imgURL, String title, String description, String information, String ingredients_name, String ingredients_quantity,
                       String ingredients_name2, String ingredients_quantity2, String ingredients_name3,
                       String ingredients_quantity3, String ingredients_name4, String ingredients_quantity4,
                       String ingredients_name5, String ingredients_quantity5, String anniversary, String country, String videoURL) {
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.information = information;
        this.ingredients_name = ingredients_name;
        this.ingredients_quantity = ingredients_quantity;
        this.ingredients_name2 = ingredients_name2;
        this.ingredients_quantity2 = ingredients_quantity2;
        this.ingredients_name3 = ingredients_name3;
        this.ingredients_quantity3 = ingredients_quantity3;
        this.ingredients_name4 = ingredients_name4;
        this.ingredients_quantity4 = ingredients_quantity4;
        this.ingredients_name5 = ingredients_name5;
        this.ingredients_quantity5 = ingredients_quantity5;
        this.anniversary = anniversary;
        this.country = country;
        this.videoURL = videoURL;
    }

    private String imgURL;
    private String title;
    private String description;
    private String information;

    private String ingredients_name;
    private String ingredients_quantity;
    private String ingredients_name2;
    private String ingredients_quantity2;
    private String ingredients_name3;
    private String ingredients_quantity3;
    private String ingredients_name4;
    private String ingredients_quantity4;
    private String ingredients_name5;
    private String ingredients_quantity5;

    private String anniversary;
    private String country;
    private String videoURL;
}
