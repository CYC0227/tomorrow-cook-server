package tomorrowcook.mp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Ingredients {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "posting_id")
    private Posting posting;

    private String ingredients_name;
    private String ingredients_quantity;

}
