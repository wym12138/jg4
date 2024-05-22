package com.ym.controller2;

import com.ym.domain.ResponseResult;
import com.ym.domain.Teacher;
import com.ym.domain.giveme.RevisePassword;
import com.ym.domain.giveme.ReviseUser;
import com.ym.domain.returnyou.getUser;
import com.ym.service.StudentService;
import com.ym.service.TeacherService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ReviseAndSearchController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;


    @RequestMapping("/my/userinfo")
    public ResponseResult search(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(300,"请求异常，请重新登录");
        }
        String subject = claims.getSubject();
        int id=Integer.parseInt(subject);
        String token1 = request.getHeader("X-User-Role");
        if (token1.equals("teacher")){
            getUser teacher = teacherService.searchTeacher(id);
            return new ResponseResult<>(200,"获取成功",teacher);

        } else if (token1.equals("student")) {
            getUser student = studentService.searchStudent(id);
            return new ResponseResult<>(200,"请求成功",student);

        }else {
            return new ResponseResult<>(300,"请求异常");

        }
    }


    @PutMapping ("/my/userinfo")
    public ResponseResult revise(@RequestBody ReviseUser reviseUser,HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(300,"请求异常，请重新登录");
        }
        String subject = claims.getSubject();
        int id=Integer.parseInt(subject);
        String token1 = request.getHeader("X-User-Role");
        if (token1.equals("teacher")){
            teacherService.reviseTeacher(reviseUser,id);
            return new ResponseResult<>(200,"修改成功");
        } else if (token1.equals("student")) {
            studentService.reviseTeacher(reviseUser,id);
            return new ResponseResult<>(200,"修改成功");
        }else {
            return new ResponseResult<>(300,"请求异常");
        }


    }


    @PatchMapping("/my/updatepwd")
    public ResponseResult revisePassword(@RequestBody RevisePassword revisePassword,HttpServletRequest request){
        if (revisePassword.getNew_pwd().equals(revisePassword.getRe_pwd())){

        }else {
            return new ResponseResult<>(400,"两次新密码输入不一致");
        }
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return new ResponseResult<>(300,"请求异常，请重新登录");
        }
        String subject = claims.getSubject();
        int id=Integer.parseInt(subject);
        String token1 = request.getHeader("X-User-Role");
        String oldPwd = revisePassword.getOld_pwd();
        if (token1.equals("teacher")){
            String password = teacherService.getPassword(id);
            if (password.equals(oldPwd)){

            }else {
                return new ResponseResult<>(400,"密码错误");
            }
            teacherService.updatePassword(revisePassword.getNew_pwd(),id);
            return new ResponseResult<>(200,"修改成功");


        }else if(token1.equals("student")){
            String password = studentService.getPassword(id);
            if (password.equals(oldPwd)){

            }else {
                return new ResponseResult<>(400,"密码错误");
            }
            studentService.updatePassword(revisePassword.getNew_pwd(),id);
            return new ResponseResult<>(200,"修改成功");

        }else {
            return new ResponseResult<>(300,"请求异常");
        }



    }

}
