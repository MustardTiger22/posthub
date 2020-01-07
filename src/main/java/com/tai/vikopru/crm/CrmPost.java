package com.tai.vikopru.crm;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CrmPost {
    @NotNull(message = "Pole jest obowiązkowe!")
    @Size(min = 5, message = "Niepoprawny adres")
    private String sourceUrl;

    private String imageSrc;

    @NotNull(message = "Pole jest obowiązkowe!")
    @Size(min = 1, message = "Pole jest obowiązkowe!")
    private String title;

    @NotNull(message = "Pole jest obowiązkowe!")
    @Size(min = 5, message = "Minimum 5 znaków!")
    private String description;

    public CrmPost() {
    }
}
