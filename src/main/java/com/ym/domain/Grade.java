package com.ym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private Integer s_id;
    private String name;
    private Integer p_id;
    private String paper_name;
    private String class_name;
    private Integer score;
    private Integer dotime;
    private Integer status;



}
