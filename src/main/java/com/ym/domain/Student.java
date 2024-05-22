package com.ym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private Integer mobilephone;
    private Integer jobnumber;
    private String academy;

}
