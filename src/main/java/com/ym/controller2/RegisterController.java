package com.ym.controller2;

import com.ym.domain.ResponseResult;
import com.ym.domain.giveme.Register;
import com.ym.service.StudentService;
import com.ym.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/api/reg")
    public ResponseResult register(@RequestBody Register register){
        if (register.getRepassword().equals(register.getPassword())){

        }else {
            return new ResponseResult<>(400,"两次密码输入不一致");
        }
        String role = register.getRole();
        if (role.equals("teacher")){
            String username = teacherService.getUsername(register.getUsername());
            if (username==null){

            }else {
                return new ResponseResult<>(400,"用户名已重复");
            }
            teacherService.insertTeacher(register);
            return new ResponseResult<>(200,"注册成功");
        }else if(role.equals("student")){
            String username = studentService.getUsername(register.getUsername());
            if (username==null){

            }else {
                return new ResponseResult<>(400,"用户名已重复");
            }
            studentService.insertStudent(register);
            return new ResponseResult<>(200,"注册成功");
        }else {
            return new ResponseResult<>(300,"请求异常");
        }

    }




}
