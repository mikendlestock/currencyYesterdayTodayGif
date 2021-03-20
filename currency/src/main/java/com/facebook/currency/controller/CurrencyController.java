package com.facebook.currency.controller;

import com.facebook.currency.dto.GifResponseDTO;
import com.facebook.currency.dto.UsdValueDTO;
import com.facebook.currency.feing.CurrencyClient;
import com.facebook.currency.service.CurrencyService;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@EnableFeignClients
public class CurrencyController {

    private final CurrencyService currencyService;

    private final CurrencyClient currencyClient;

    public CurrencyController(CurrencyService currencyService, CurrencyClient currencyClient) {
        this.currencyService = currencyService;
        this.currencyClient = currencyClient;
    }

    @GetMapping(path = "/richStatus")
    public void getRichStatus(HttpServletResponse httpResponse) throws IOException {
        GifResponseDTO richStatus = currencyService.getRichStatus();
        String imageUrl = richStatus.getData().getImageUrl();
        httpResponse.sendRedirect(imageUrl);
    }
}
