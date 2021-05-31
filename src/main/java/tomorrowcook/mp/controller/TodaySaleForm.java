package tomorrowcook.mp.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodaySaleForm {

    TodaySaleForm(){

    }

    TodaySaleForm(String info, String address, String address_around , String store_address){
        this.info = info;
        this. address = address;
        this.address_around = address_around;
        this.store_address = store_address;
    }
    private String info;
    private String address;
    private String address_around;
    private String store_address;

}
