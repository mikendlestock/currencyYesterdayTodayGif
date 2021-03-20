package com.facebook.currency.service;

import com.facebook.currency.dto.GifResponseDTO;

public interface CurrencyService {

   GifResponseDTO getRichStatus();

   Boolean getCurrencyValue();

   String yesterdayDate();

}
