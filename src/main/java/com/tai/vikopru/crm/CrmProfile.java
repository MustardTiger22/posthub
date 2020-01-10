package com.tai.vikopru.crm;

import com.tai.vikopru.validation.ValidEmail;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CrmProfile {

    @NotNull(message = "Pole jest obowiązkowe!")
    @Size(min = 1, message = "Pole jest obowiązkowe!")
    private String firstName;

    @NotNull(message = "Pole jest obowiązkowe!")
    @Size(min = 1, message = "Pole jest obowiązkowe!")
    private String lastName;

    @ValidEmail
    @NotNull(message = "Pole jest obowiązkowe!")
    @Size(min = 5, message = "Pole jest obowiązkowe!")
    private String email;

    public CrmProfile() {
    }
}
