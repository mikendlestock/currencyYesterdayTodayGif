package com.facebook.currency;

import com.facebook.currency.feing.CurrencyClient;
import com.facebook.currency.feing.GifClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {GifClient.class, CurrencyClient.class})
public class CurrencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyApplication.class, args);
    }

}
