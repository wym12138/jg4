package com.ym.domain.giveme;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {
    private String username;
    private String role;
    private String password;
    private String repassword;
}
