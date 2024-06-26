package com.ym.domain.giveme;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviseUser {
    private String username;

    private String name;
    private String gender;
    private String mobilephone;
    private String jobnumber;
    private String academy;

    private String subject;
}
