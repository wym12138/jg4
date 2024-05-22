package com.ym.domain.returnyou;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnGrade {

    private Integer id;
    private String studentname;
    private String catename;
    private Integer dotime;
    private Integer grade;
}
