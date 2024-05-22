package com.ym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Param;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Integer id;
    private String username;

    private String password;

    private String name;
    private String gender;

    private String mobilephone;
    private Integer jobnumber;
    private String academy;
    private String subject;
}
