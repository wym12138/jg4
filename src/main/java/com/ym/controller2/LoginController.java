package com.ym.controller2;

import com.ym.domain.ResponseResult;
import com.ym.domain.Student;
import com.ym.domain.Teacher;
import com.ym.domain.giveme.Login;

import com.ym.service.StudentService;
import com.ym.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utils.JwtUtil;

import java.util.UUID;

@RestController
public class LoginController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;


    @PostMapping("/api/login")
    public ResponseResult login(@RequestBody Login login){
        String role = login.getRole();
        if (role.equals("teacher")){
            String username = teacherService.getUsername(login.getUsername());
            if (username==null){
                return new ResponseResult(400,"用户名不存在",null);

            }else {

            }
            Teacher teacher = teacherService.loginTeacher(login);

            if (teacher.getId()==null){
                return new ResponseResult(400,"密码错误",null);
            }else {
                String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(teacher.getId()), null);
                return new ResponseResult(200,"登陆成功",jwt);
            }
        }else if(role.equals("student")){
            String username = studentService.getUsername(login.getUsername());
            if (username==null){
                return new ResponseResult(400,"用户名不存在",null);

            }else {
            }
            Student student = studentService.loginStudent(login);
            if (student.getId()==null){
                return new ResponseResult(400,"密码错误",null);
            }else {
                String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(student.getId()), null);
                return new ResponseResult(200,"登陆成功",jwt);
            }



        }else {
            return new ResponseResult(400,"rolewrong",null);
        }




    }

}
