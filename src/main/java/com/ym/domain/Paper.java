package com.ym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper {

    private Integer p_id;
    private Integer t_id;
    private String p_name;
    private String class_name;
    private String subject;


}
