package com.ym.service;

import com.ym.domain.ResponseResult;
import com.ym.domain.Student;
import com.ym.domain.giveme.Login;
import com.ym.domain.giveme.Register;
import com.ym.domain.giveme.ReviseUser;
import com.ym.domain.returnyou.getUser;
import com.ym.mapper.StudentMapper;

public interface StudentService {

    String getUsername(String username);

    Integer loginStudent(Login login);


    void insertStudent(Register register);

    getUser searchStudent(int id);

    String getPassword(int id);

    void updatePassword(String newPwd, int id);


    void reviseTeacher(ReviseUser reviseUser, int id);
}
