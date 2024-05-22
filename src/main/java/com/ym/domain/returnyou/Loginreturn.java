package com.ym.domain.returnyou;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loginreturn {

    private Integer code;
    private String msg;
    private String token;


}
