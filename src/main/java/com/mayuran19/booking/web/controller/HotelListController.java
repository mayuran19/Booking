package com.mayuran19.booking.web.controller;

import com.mayuran19.booking.service.hotelbed.HotelListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Created by satch on 1/31/2016.
 */

@Controller
public class HotelListController {
    @Autowired
    private HotelListService hotelListService;

    @RequestMapping(value = "HotelList/listHotels")
    public String listHotels() throws Exception {
        String json = hotelListService.getHotelsList();
        System.out.println(json);
        return null;
    }
}
