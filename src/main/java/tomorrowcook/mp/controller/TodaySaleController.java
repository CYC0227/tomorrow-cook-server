package tomorrowcook.mp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tomorrowcook.mp.domain.Member;
import tomorrowcook.mp.domain.Posting;
import tomorrowcook.mp.domain.TodaySale;
import tomorrowcook.mp.repository.TodaySaleRepository;
import tomorrowcook.mp.service.TodaySaleService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodaySaleController {

    private final TodaySaleService todaySaleService;
    private final TodaySaleRepository todaySaleRepository;

    @GetMapping(value = "/todaysales")
    public List<TodaySaleForm> todaySaleForms() {

        List<TodaySale> todaySales = todaySaleService.findTodaySales();
        List<TodaySaleForm> todaySaleForms = new ArrayList<>();
        TodaySaleForm todaySaleForm;

        for (TodaySale p : todaySales) {
            String address = p.getAddress();
            String info = p.getInfo();
            String address_around = p.getAddress_around();
            String store_address = p.getStore_address();

            todaySaleForm = new TodaySaleForm(info, address,address_around, store_address);

            todaySaleForms.add(todaySaleForm);
        }

        return todaySaleForms;
    }


    @GetMapping(value = "/todaysales/around")
    public List<TodaySaleForm> findByRegion(@RequestParam("region") String region) {

        List<TodaySale> todaySales = todaySaleService.findByRegion(region);
        List<TodaySaleForm> todaySaleForms = new ArrayList<>();
        TodaySaleForm todaySaleForm;

        for (TodaySale p : todaySales) {
            String address = p.getAddress();
            String info = p.getInfo();
            String address_around = p.getAddress_around();
            String store_address = p.getStore_address();

            todaySaleForm = new TodaySaleForm(info, address,address_around,store_address);

            todaySaleForms.add(todaySaleForm);
        }

        return todaySaleForms;
    }

    @PostMapping(value = "/todaysales/new")//????????????????????? static ????????? ??????????????? member??? ?????? ???????????? ?????? ??? ????????? ?????????
    public String create(@RequestBody TodaySaleForm form, BindingResult result) {

        TodaySale todaySale = new TodaySale();

        todaySale.setAddress(form.getAddress());
        todaySale.setInfo(form.getInfo());
        todaySale.setAddress_around(form.getAddress_around());
        todaySale.setStore_address(form.getStore_address());

        todaySaleService.join(todaySale);

        return "redirect:/";
    }
}
