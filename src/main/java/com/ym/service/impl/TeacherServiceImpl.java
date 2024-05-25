package com.ym.service.impl;


import com.ym.domain.Teacher;
import com.ym.domain.giveme.Login;
import com.ym.domain.giveme.Register;
import com.ym.domain.giveme.ReviseUser;
import com.ym.domain.returnyou.getUser;
import com.ym.mapper.TeacherMapper;
import com.ym.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public String getUsername(String username) {
        String result = teacherMapper.getUsername(username);
        return result;
    }

    @Override
    public Integer loginTeacher(Login login) {
        Integer teacher = teacherMapper.loginTeacher(login);
        return teacher;
    }

    @Override
    public void insertTeacher(Register register) {
        teacherMapper.insertTeacher(register);
    }

    @Override
    public getUser searchTeacher(Integer id) {
        getUser teacher = teacherMapper.searchTeacher(id);
        return teacher;
    }

    @Override
    public String getPassword(Integer id) {
        String password = teacherMapper.getPassword(id);
        return password;
    }

    @Override
    public void updatePassword(String password,Integer id) {
        teacherMapper.updatePassword(password,id);
    }

    @Override
    public void reviseTeacher(ReviseUser reviseUser, Integer id) {
        teacherMapper.reviseTeacher(reviseUser,id);
    }


}
