package com.mayuran19.booking.service.crypto;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * Created by satch on 1/31/2016.
 */
@Component("cryptoService")
public class CryptoService {
    public String getSha256Hex(String string){
        return DigestUtils.sha256Hex(string);
    }

    public String getHotelBedXSignature(String apiKey, String sharedSecret){
        String toDigest = apiKey + sharedSecret + (System.currentTimeMillis() / 1000);
        return this.getSha256Hex(toDigest);
    }
}
