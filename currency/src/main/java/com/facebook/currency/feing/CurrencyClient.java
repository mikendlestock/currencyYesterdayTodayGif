package com.facebook.currency.feing;

import com.facebook.currency.dto.UsdValueDTO;
import com.facebook.currency.service.CurrencyService;
import com.facebook.currency.service.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "currency", url = "https://openexchangerates.org/api")
public interface CurrencyClient {
    @GetMapping("/historical/2020-03-19.json?app_id=128a38fb5c4a4a98bd101e8adaf5b2ae&symbols=RUB")
    public UsdValueDTO getYesterdayValue();

    @GetMapping("/latest.json?app_id=128a38fb5c4a4a98bd101e8adaf5b2ae&symbols=RUB")
    public UsdValueDTO getTodayValue();
}
