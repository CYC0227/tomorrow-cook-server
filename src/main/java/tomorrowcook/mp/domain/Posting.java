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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
