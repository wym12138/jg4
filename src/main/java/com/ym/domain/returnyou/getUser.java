package com.ym.domain.returnyou;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class getUser {

    private String username;


    private String name;
    private String gender;

    private String mobilephone;
    private String jobnumber;
    private String academy;
    private String subject;
}
