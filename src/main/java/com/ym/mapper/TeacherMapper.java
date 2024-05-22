package com.ym.mapper;

import com.ym.domain.Teacher;
import com.ym.domain.giveme.Login;
import com.ym.domain.giveme.Register;
import com.ym.domain.giveme.ReviseUser;
import com.ym.domain.returnyou.getUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {

    //教师登录
    String getUsername(String username);

    Teacher loginTeacher(Login login);

    void insertTeacher(Register register);

    getUser searchTeacher(Integer id);

    String getPassword(Integer id);

    void updatePassword(@Param("password") String password,@Param("id") Integer id);

    void reviseTeacher(@Param("reviseUser") ReviseUser reviseUser,@Param("id") Integer id);////////////////////




}
