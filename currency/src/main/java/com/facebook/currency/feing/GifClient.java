package com.facebook.currency.feing;

import com.facebook.currency.dto.GifResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gif", url = "https://api.giphy.com/v1/gifs")
public interface GifClient {
    @RequestMapping(method = RequestMethod.GET, value = "/random")
    GifResponseDTO getRandomGifByTag(@RequestParam("api_key") String apiKey, @RequestParam("tag") String tag);

}
