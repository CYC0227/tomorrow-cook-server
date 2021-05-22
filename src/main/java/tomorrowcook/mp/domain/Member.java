package tomorrowcook.mp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Member {

    @Id
    @Column(name = "member_id")
    private String email;
    private String pw;
    private String name;




}