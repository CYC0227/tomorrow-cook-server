package tomorrowcook.mp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


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

    @OneToMany(mappedBy = "posting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredients> ingredients;

    private String weather;
    private String anniversary;
    private String country;
    private String videoURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
