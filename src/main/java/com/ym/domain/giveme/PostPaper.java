package com.ym.domain.giveme;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPaper {

    private Integer id;
    private String title;
    private String catename;
    private Integer dotime;
    private List<StudentAnswer> content;



}
