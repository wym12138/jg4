package com.ym.service.impl;

import com.ym.domain.Grade;
import com.ym.domain.Paper;
import com.ym.domain.Question;
import com.ym.domain.giveme.CreatePaper;
import com.ym.domain.giveme.UpdatePaper;
import com.ym.domain.returnyou.FiliterS;
import com.ym.domain.returnyou.ReturnGrade;
import com.ym.domain.returnyou.ReturnPaperList;
import com.ym.domain.returnyou.ReturnPaperList2;
import com.ym.mapper.PaperMapper;
import com.ym.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public List<ReturnPaperList> SelectPaper(Integer id) {
        List<ReturnPaperList> lists = paperMapper.SelectPaper(id);
        return lists;
    }

    @Override
    public List<Integer> SelectQuestionId(Integer id) {
        List<Integer> integers = paperMapper.SelectQuestionId(id);
        return integers;
    }

    @Override
    public Question SelectQuestion(Integer id) {
        Question questions = paperMapper.SelectQuestion(id);
        return questions;
    }

    @Override
    public void UpdateCommon(UpdatePaper updatePaper) {
        paperMapper.UpdateCommon(updatePaper);
    }

    @Override
    public void DeleteQid(Integer id) {
        paperMapper.DeleteQid(id);
    }

    @Override
    public void InsertQid(Integer qid, Integer id) {
        paperMapper.InsertQid(qid,id);
    }

    @Override
    public Paper getPaperName(String name) {
        Paper paper = paperMapper.getPaperName(name);
        return paper;

    }

    @Override
    public void InsertPaper(CreatePaper createPaper, Integer id) {
        paperMapper.InsertPaper(createPaper,id);
    }

    @Override
    public List<String> NgetPaperName(Integer id, String catename) {
        List<String> s = paperMapper.NgetPaperName(id, catename);
        return s;
    }

    @Override
    public ReturnPaperList SelectPaper2(Integer id) {
        ReturnPaperList returnPaperList = paperMapper.SelectPaper2(id);
        return returnPaperList;
    }

    @Override
    public void DeletePaper(Integer id) {
        paperMapper.DeletePaper(id);
    }

    @Override
    public Integer SelectCid(String subject) {
        Integer id = paperMapper.SelectCid(subject);
        return id;
    }

    @Override
    public List<Question> getQuestion(Integer id) {
        List<Question> question = paperMapper.getQuestion(id);
        return question;

    }

    @Override
    public List<Integer> GetPid(Integer id) {
        List<Integer> integers = paperMapper.GetPid(id);
        return integers;
    }

    @Override
    public List<ReturnGrade> GetGrade(Integer id) {
        List<ReturnGrade> returnGrade = paperMapper.GetGrade(id);
        return returnGrade;
    }

    @Override
    public List<Integer> GetPid2(String subject) {
        List<Integer> integers = paperMapper.GetPid2(subject);
        return integers;
    }

    @Override
    public String IdGetAnswer(Integer id) {
        String s = paperMapper.IdGetAnswer(id);
        return s;
    }

    @Override
    public void InsertGrade(Grade grade) {
        paperMapper.InsertGrade(grade);
    }

    @Override
    public String GetName(Integer id) {
        String s = paperMapper.GetName(id);
        return s;
    }

    @Override
    public String GetUsername(Integer id) {
        String s = paperMapper.GetUsername(id);
        return s;
    }

    @Override
    public Integer GetRetest(Integer p_id, Integer s_id) {
        Integer i = paperMapper.GetRetest(p_id, s_id);
        return i;
    }

    @Override
    public Integer GetMaxGrade(Integer s_id, Integer p_id) {
        Integer i = paperMapper.GetMaxGrade(s_id, p_id);
        return i;
    }

    @Override
    public List<FiliterS> GetFiliterPaper(Integer t_id, String title, String catename) {
        List<FiliterS> filiterS = paperMapper.GetFiliterPaper(t_id, title, catename);

        return filiterS;
    }

    @Override
    public ReturnPaperList2 SelectPaper3(Integer id) {
        ReturnPaperList2 returnPaperList2 = paperMapper.SelectPaper3(id);
        return returnPaperList2;
    }


}
