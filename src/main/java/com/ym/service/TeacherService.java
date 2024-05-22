package com.ym.service;


import com.ym.domain.Teacher;
import com.ym.domain.giveme.Login;
import com.ym.domain.giveme.Register;
import com.ym.domain.giveme.ReviseUser;
import com.ym.domain.returnyou.getUser;


import java.util.List;

public interface TeacherService {

    //登陆相关操作
    String getUsername(String username);
    Teacher loginTeacher(Login login);


    void insertTeacher(Register register);

    getUser searchTeacher(Integer id);

    String getPassword(Integer id);

    void updatePassword(String password,Integer id);

    void reviseTeacher(ReviseUser reviseUser,Integer id);


}
