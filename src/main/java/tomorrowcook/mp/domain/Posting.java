package tomorrowcook.mp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Posting {

    @Id
    @GeneratedValue
    @Column(name = "posting_id")
    private Long id;
    private String title;
    private String imgURL;
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
    private String weather;
    private String anniversary;
    private String country;
    private String videoURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
