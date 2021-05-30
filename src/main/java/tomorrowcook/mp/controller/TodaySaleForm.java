package tomorrowcook.mp.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodaySaleForm {

    TodaySaleForm(){

    }

    TodaySaleForm(String info, String address, String address_around){
        this.info = info;
        this. address = address;
        this.address_around = address_around;
    }
    private String info;
    private String address;
    private String address_around;

}
