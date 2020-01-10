package com.tai.vikopru.crm;

import com.tai.vikopru.validation.FieldMatch;
import com.tai.vikopru.validation.ValidEmail;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
                })

@Data
public class CrmUser {
    @NotNull(message = "Pole jest obowiązkowe!")
    @Size(min = 5, message = "Za krótka nazwa użytkownika! Minimum 5 znaków.")
    private String username;

    @NotNull(message = "Pole jest obowiązkowe!")
    @Size(min = 1, message = "Pole jest obowiązkowe!")
    private String password;

    @NotNull(message = "Pole jest obowiązkowe!")
    @Size(min = 1, message = "Pole jest obowiązkowe!")
    private String matchingPassword;

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

    @NotNull(message = "Pole jest obowiązkowe!")
    @Size(min = 1, message = "Pole jest obowiązkowe!")
    private String gender;

    public CrmUser() {

    }

}
