package com.facebook.currency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GifDTO {
    String id;
    String url;
    String type;
    //наше поле.
    @JsonProperty("image_url")
    String imageUrl;

}
