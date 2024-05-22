package com.ym.domain.giveme;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaper {
    private String title;
    private String catename;

    private String subject;
    private List<Integer> sid;
}
