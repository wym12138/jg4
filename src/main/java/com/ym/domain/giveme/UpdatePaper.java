package com.ym.domain.giveme;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaper {
    private Integer id;
    private String title;
    private String catename;
    private List<Integer> sid;


}
