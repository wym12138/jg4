package com.ym.domain.returnyou;

import com.ym.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnPaperList {//学生端查询试卷也用

    private Integer id;
    private String title;
    private String catename;
    private String subject;
    private Integer total;
    private List<Question> content;


}
