package com.mayuran19.booking.service.hotelbed;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by satch on 1/31/2016.
 */
@Component("hotelListService")
public class HotelListService {
    @Autowired
    private HttpHeader httpHeader;
    @Value("${HOTEL.LIST.URL}")
    private String hotelListUrl;

    public String getHotelsList() throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(hotelListUrl, HttpMethod.GET, httpHeader.getHotelbedHttpEntity(), String.class);

        return response.toString();
    }
}
