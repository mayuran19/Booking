package com.mayuran19.booking.service.hotelbed;

import com.mayuran19.booking.service.crypto.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.Arrays;

/**
 * Created by satch on 1/31/2016.
 */
@Component("hotelbedHttpHeader")
public class HttpHeader extends HttpHeaders{
    //Header keys
    private static final String HTTP_HEADER_API_KEY = "Api-Key";
    private static final String HTTP_HEADER_X_SIGNATURE = "X-Signature";
    private static final String HTTP_HEADER_X_ORIGINATING_IP = "X-Originating-Ip";

    //properties from propertie file
    @Value("${HOTELBED.API.KEY}")
    private String apiKey;
    @Value("${HOTELBED.SHARED.SECRET}")
    private String sharedSecret;

    //Services
    @Autowired
    private CryptoService cryptoService;

    public HttpEntity<String> getHotelbedHttpEntity() throws Exception{
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.set(HTTP_HEADER_API_KEY, apiKey);
        httpHeaders.set(HTTP_HEADER_X_SIGNATURE, cryptoService.getHotelBedXSignature(apiKey,sharedSecret));
        httpHeaders.set(HTTP_HEADER_X_ORIGINATING_IP, InetAddress.getLocalHost().getHostAddress());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeaders);

        return entity;
    }
}
