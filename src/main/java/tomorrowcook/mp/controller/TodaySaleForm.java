package tomorrowcook.mp.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodaySaleForm {

    TodaySaleForm(){

    }

    TodaySaleForm(String info, String address){
        this.info = info;
        this. address = address;
    }
    private String info;
    private String address;
}
