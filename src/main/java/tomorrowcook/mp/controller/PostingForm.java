package tomorrowcook.mp.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostingForm {

    private String imgURL;
    private String title;
    private String description;
    private String information;
    private String ingredients_name;
    private String ingredients_quantity;
}
