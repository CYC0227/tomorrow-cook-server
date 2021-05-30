package tomorrowcook.mp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class TodaySale {

    @Id @GeneratedValue
    private Long id;
    private String info;
    private String address;
    private String address_around;

}
