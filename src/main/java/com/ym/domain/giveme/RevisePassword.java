package com.ym.domain.giveme;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RevisePassword {

    private String old_pwd;
    private String new_pwd;
    private String re_pwd;


}
