package com.ym.service;

import com.ym.domain.Grade;
import com.ym.domain.Paper;
import com.ym.domain.Question;
import com.ym.domain.giveme.CreatePaper;
import com.ym.domain.giveme.UpdatePaper;
import com.ym.domain.returnyou.ReturnGrade;
import com.ym.domain.returnyou.ReturnPaperList;

import java.util.List;

public interface PaperService {

    //通过t_id查找一堆试卷信息
    //通过每个试卷id查题id
    //通过题id查题的question和answer

    List<ReturnPaperList> SelectPaper(Integer id);
    List<Integer> SelectQuestionId(Integer id);
    Question SelectQuestion(Integer id);


    //通过t_id改基础信息
    //通过id删除所有题目id
    //通过id和题id添加联表

    void UpdateCommon(UpdatePaper updatePaper);
    void DeleteQid(Integer id);
    void InsertQid(Integer qid,Integer id);

    //查找是否有相同试卷名
    //添加paper库
    //添加paper_question库
    Paper getPaperName(String name);
    void InsertPaper(CreatePaper createPaper,Integer id);


    //通过p_id查找试卷基本信息
    ReturnPaperList SelectPaper2(Integer id);


    ////删除paper中信息
    void DeletePaper(Integer id);

    //通过学科名在course里查找id
    //根据id在question里查找题
    Integer SelectCid (String subject);
    List<Question> getQuestion(Integer id);

    //通过t_id查找p_id集合
    //p_id查找基本信息
    List<Integer> GetPid(Integer id);
    ReturnGrade GetGrade(Integer id);

    //通过学科查找试卷id列表
    //通过试卷id查找基本信息
    List<Integer> GetPid2(String subject);

    //通过题目id返回答案
    //添加成绩表
    String IdGetAnswer(Integer id);
    void InsertGrade(Grade grade);

    //通过s_id获取姓名

    String GetName(Integer id);









}
