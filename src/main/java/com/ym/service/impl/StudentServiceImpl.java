package com.ym.service.impl;

import com.ym.domain.Student;
import com.ym.domain.giveme.Login;
import com.ym.domain.giveme.Register;
import com.ym.domain.giveme.ReviseUser;
import com.ym.domain.returnyou.getUser;
import com.ym.mapper.StudentMapper;
import com.ym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String getUsername(String username) {
        String username1 = studentMapper.getUsername(username);
        return username1;
    }

    @Override
    public Integer loginStudent(Login login) {
        Integer student = studentMapper.loginStudent(login);
        return student;
    }

    @Override
    public void insertStudent(Register register) {
        studentMapper.insertStudent(register);
    }

    @Override
    public getUser searchStudent(int id) {
        getUser getUser = studentMapper.searchStudent(id);
        return getUser;
    }

    @Override
    public String getPassword(int id) {
        String password = studentMapper.getPassword(id);
        return password;
    }

    @Override
    public void updatePassword(String newPwd, int id) {
        studentMapper.updatePassword(newPwd,id);
    }

    @Override
    public void reviseTeacher(ReviseUser reviseUser, int id) {
        studentMapper.reviseTeacher(reviseUser,id);
    }
}
