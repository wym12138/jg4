package com.ym.controller2.teacher;

import com.ym.domain.Paper;
import com.ym.domain.Question;
import com.ym.domain.ResponseResult;
import com.ym.domain.giveme.CreatePaper;
import com.ym.domain.giveme.PaperList;
import com.ym.domain.giveme.UpdatePaper;
import com.ym.domain.returnyou.ReturnGrade;
import com.ym.domain.returnyou.ReturnPaperList;
import com.ym.service.PaperService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PaperController {



    @Autowired
    private PaperService paperService;




    @RequestMapping("/my/article/list")
    public ResponseResult getPaperList(@RequestBody PaperList paperList, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(300,"请求异常，请重新登录");
        }
        String subject = claims.getSubject();
        int id=Integer.parseInt(subject);
        //通过t_id查找一堆试卷信息
        //通过每个试卷id查题id
        //通过题id查题的question和answer
        List<ReturnPaperList> lists = paperService.SelectPaper(id);
        for (int i=0;i< lists.size();i++){
            Integer id1 = lists.get(i).getId();//每个试卷id
            List<Integer> id2 = paperService.SelectQuestionId(id1);//题的id
            List<Question> questions=new ArrayList<>();
            for (int j=0;j<id2.size();j++){
                Question question = paperService.SelectQuestion(id2.get(j));
                questions.add(question);
            }
            lists.get(i).setContent(questions);
        }
        List<ReturnPaperList> lists2=new ArrayList<>();
        Integer pagenum = paperList.getPagenum();
        Integer pagesize = paperList.getPagesize();
        int m=0;
        int n = (pagenum-1) * pagesize;
        while (m<pagesize){
            if (n>=lists.size()){
                break;
            }
            ReturnPaperList returnPaperList = lists.get(n);
            lists2.add(returnPaperList);
            n++;
            m++;
        }
        for (int k=0;k<lists2.size();k++){
            lists2.get(k).setTotal(m);//添加每一页的个数
        }


        return new ResponseResult<>(200,"查询成功",lists2);

    }


    @PutMapping("/my/article/info")
    public ResponseResult updatePaper(@RequestBody UpdatePaper updatePaper,HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(300,"请求异常，请重新登录");
        }
        String subject = claims.getSubject();
        int t_id=Integer.parseInt(subject);

        //通过t_id改基础信息
        //通过id删除所有题目id
        //通过id和题id添加联表
        Integer id = updatePaper.getId();//试卷id
        if (updatePaper.getCatename()!=null||updatePaper.getCatename()!=null){
            paperService.UpdateCommon(updatePaper);
        }
        if (updatePaper.getSid()!=null){
            paperService.DeleteQid(id);//删除题与试卷的连接
            List<Integer> sid = updatePaper.getSid();
            for (int i=0;i< sid.size();i++){
                Integer qid = sid.get(i);
                paperService.InsertQid(qid,id);
            }
        }
        return new ResponseResult<>(200,"获取成功");


    }



    @PostMapping("/my/article/add")
    public ResponseResult InsertPaper(@RequestBody CreatePaper createPaper, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(300,"请求异常，请重新登录");
        }
        String subject = claims.getSubject();
        int t_id=Integer.parseInt(subject);


        //查找是否有相同试卷名
        //添加paper库
        //添加paper_question库
        Paper paper = paperService.getPaperName(createPaper.getTitle());
        if (paper==null){

        }else {
            return new ResponseResult<>(400,"试卷名重复");
        }
        paperService.InsertPaper(createPaper,t_id);

        Paper paper2 = paperService.getPaperName(createPaper.getTitle());
        Integer id = paper2.getP_id();//找试卷id


        List<Integer> sid = createPaper.getSid();
        for (int i=0;i< sid.size();i++){
            Integer qid = sid.get(i);
            paperService.InsertQid(qid,id);
        }

        return new ResponseResult<>(200,"创建成功");
    }



    @RequestMapping("/my/article/info")
    public ResponseResult GetNbPaper(@PathVariable Integer id,HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(300,"请求异常，请重新登录");
        }
        String subject = claims.getSubject();
        int t_id=Integer.parseInt(subject);

        //通过试卷id查找试卷基本信息
        //通过试卷id查找题目
        ReturnPaperList returnPaperList = paperService.SelectPaper2(id);
        List<Integer> ids = paperService.SelectQuestionId(id);
        List<Question> questions=new ArrayList<>();
        for (int j=0;j<ids.size();j++){
            Question question = paperService.SelectQuestion(ids.get(j));
            questions.add(question);
        }
        returnPaperList.setContent(questions);

        return new ResponseResult<>(200,"获取成功",returnPaperList);

    }

    @DeleteMapping("/my/article/info")
    public ResponseResult DeletePaper(@PathVariable Integer id,HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(300,"请求异常，请重新登录");
        }
        String subject = claims.getSubject();
        int t_id=Integer.parseInt(subject);

        //删除paper中信息
        //删除与题库之间的连接
        paperService.DeletePaper(id);
        paperService.DeleteQid(id);
        return new ResponseResult<>(200,"删除成功");

    }

    @RequestMapping("/my/article/papers")
    public ResponseResult SelectQuestions(@PathVariable String subject,HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(300,"请求异常，请重新登录");
        }
        String bject = claims.getSubject();
        int t_id=Integer.parseInt(bject);

        //通过学科名在course里查找id
        //根据id在question里查找题
        Integer id = paperService.SelectCid(subject);
        List<Question> question = paperService.getQuestion(id);
        return new ResponseResult<>(200,"查询成功",question);
    }

    @RequestMapping("/my/cate/list")
    public ResponseResult SelectGrade(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(300,"请求异常，请重新登录");
        }
        String bject = claims.getSubject();
        int t_id=Integer.parseInt(bject);

        //通过t_id查找p_id集合
        //p_id查找基本信息
        List<Integer> integers = paperService.GetPid(t_id);
        List<ReturnGrade> returnGrades=new ArrayList<>();
        for (int i=0;i<integers.size();i++){
            ReturnGrade returnGrade = paperService.GetGrade(integers.get(i));
            returnGrades.add(returnGrade);
        }
        return new ResponseResult<>(200,"获取成功",returnGrades);


    }


}
