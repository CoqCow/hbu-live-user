package com.hbu.live.user.req;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Getter @Setter
public class LoginReq {

    @NotBlank @Email
    public String email;

    @NotBlank @Length(min = 6, max = 32)
    public String password;

}
