package com.ym.controller2.student;


import com.ym.domain.Grade;
import com.ym.domain.Question;
import com.ym.domain.ResponseResult;
import com.ym.domain.giveme.PostPaper;
import com.ym.domain.giveme.StudentAnswer;
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
public class PaperController2 {

    @Autowired
    private PaperService paperService;



    @RequestMapping("/my/student/paper")
    public ResponseResult getStudentPaper(@RequestParam("subject") String subject, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(401,"请求异常，请重新登录");
        }
        String bject = claims.getSubject();
        int s_id=Integer.parseInt(bject);


        //通过学科查找试卷id列表
        List<Integer> integers = paperService.GetPid2(subject);
        //通过试卷id查找基本信息
        //通过每个试卷id查题id
        //通过题id查题的question和answer
        List<ReturnPaperList> lists=new ArrayList<>();

        for (int i=0;i<integers.size();i++){
            ReturnPaperList returnPaperList = paperService.SelectPaper2(integers.get(i));
            lists.add(returnPaperList);
        }
        for (int i=0;i< integers.size();i++){
            Integer id1 = integers.get(i);//每个试卷id
            List<Integer> id2 = paperService.SelectQuestionId(id1);//题的id
            List<Question> questions=new ArrayList<>();
            for (int j=0;j<id2.size();j++){
                Question question = paperService.SelectQuestion(id2.get(j));
                questions.add(question);
            }
            lists.get(i).setContent(questions);
        }

        return new ResponseResult<>(200,"获取成功",lists);

    }


    @PostMapping("/my/student/submitpaper")
    public ResponseResult PostTest(@RequestBody PostPaper postPaper,HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(401,"请求异常，请重新登录");
        }
        String bject = claims.getSubject();
        int s_id=Integer.parseInt(bject);

        //计算成绩
        List<StudentAnswer> content = postPaper.getContent();
            //通过题目id返回答案
            //对答案
            //变量n，m
        int m=0;
        int n=0;
        for(int i=0;i<content.size();i++){
            String answer = paperService.IdGetAnswer(content.get(i).getId());
            if (answer.equals(content.get(i).getStudentanswer())){
                n++;
            }else {

            }
            m++;
        }
        int score=n/m;

        //添加成绩表
        Grade grade=new Grade(s_id,null,postPaper.getId(),postPaper.getTitle(),postPaper.getCatename(),score,postPaper.getDotime(),null);
            //通过s_id获取姓ming
        String name = paperService.GetName(s_id);/////////////////////////////////
        String username=paperService.GetUsername(s_id);
        if (name==null){
            grade.setName(username);
        }else {
            grade.setName(name);
        }


            //添加题库
         paperService.InsertGrade(grade);


        //返回成绩
        return new ResponseResult<>(200,"成绩",score);



    }












}
