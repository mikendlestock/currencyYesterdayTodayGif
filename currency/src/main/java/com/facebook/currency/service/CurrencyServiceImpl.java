package com.facebook.currency.service;

import com.facebook.currency.dto.GifResponseDTO;
import com.facebook.currency.dto.Tag;
import com.facebook.currency.feing.CurrencyClient;
import com.facebook.currency.feing.GifClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final GifClient gifClient;
    private final CurrencyClient currencyClient;
    private final String gifApi;
    private final String currencyApi;

    public CurrencyServiceImpl(GifClient gifClient, CurrencyClient currencyClient, @Value("${gif.api}") String gifApi, @Value("${currency.api}") String currencyApi) {
        this.gifClient = gifClient;
        this.currencyClient = currencyClient;
        this.gifApi = gifApi;
        this.currencyApi = currencyApi;
    }


    @Override
    public Boolean getCurrencyValue() {
        return null;
    }

    @Override
    public String yesterdayDate() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    @Override
    public GifResponseDTO getRichStatus() {
        String yesterdayDateValue = yesterdayDate();
        Double todayValueDouble = currencyClient.getTodayValue().getRates().getRUB();
        Double yesterdayValueDouble = currencyClient.getYesterdayValue().getRates().getRUB();

        //TODO здесь будет логика по определению статуса.
        if (todayValueDouble > yesterdayValueDouble) {
            return getGif(Tag.RICH.name());
        } else {
            return getGif(Tag.POOR.name());
        }
    }

    private GifResponseDTO getGif(String tag) {
        System.out.println(yesterdayDate() + " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return gifClient.getRandomGifByTag(gifApi, tag);
    }
}
