package com.ym.mapper;

import com.ym.domain.Grade;
import com.ym.domain.Paper;
import com.ym.domain.Question;
import com.ym.domain.giveme.CreatePaper;
import com.ym.domain.giveme.UpdatePaper;
import com.ym.domain.returnyou.FiliterS;
import com.ym.domain.returnyou.ReturnGrade;
import com.ym.domain.returnyou.ReturnPaperList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaperMapper {

    List<ReturnPaperList> SelectPaper(Integer id);

    List<Integer> SelectQuestionId(Integer id);

    Question SelectQuestion(Integer id);

    void UpdateCommon( UpdatePaper updatePaper);/////////////////////////////

    void DeleteQid(Integer id);

    void InsertQid(@Param("qid") Integer qid,@Param("pid") Integer id);

    Paper getPaperName(String name);


    void InsertPaper(@Param("createPaper") CreatePaper createPaper,@Param("id") Integer id);////////////////////


    ReturnPaperList SelectPaper2(Integer id);

    void DeletePaper(Integer id);

    Integer SelectCid (String subject);

    List<Question> getQuestion(Integer id);

    List<Integer> GetPid(Integer id);

    List<ReturnGrade> GetGrade(Integer id);

    List<Integer> GetPid2(String subject);

    String IdGetAnswer(Integer id);

    void InsertGrade(Grade grade);

    String GetName(Integer id);

    String GetUsername(Integer id);

    Integer GetRetest(@Param("p_id") Integer p_id,@Param("s_id") Integer s_id);

    String NgetPaperName(@Param("id") Integer id,@Param("catename") String catename);


    Integer GetMaxGrade(@Param("s_id") Integer s_id,@Param("p_id") Integer p_id);

    List<FiliterS> GetFiliterPaper(@Param("t_id") Integer t_id,@Param("title") String title,@Param("catename") String catename);



}
