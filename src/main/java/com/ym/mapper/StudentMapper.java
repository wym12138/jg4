package com.ym.mapper;

import com.ym.domain.Student;
import com.ym.domain.giveme.Login;
import com.ym.domain.giveme.Register;
import com.ym.domain.giveme.ReviseUser;
import com.ym.domain.returnyou.getUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

    String getUsername(String username);

    Student loginStudent(Login login);

    void insertStudent(Register register);

    getUser searchStudent(int id);

    String getPassword(int id);

    void updatePassword(@Param("password") String newPwd,@Param("id") int id);

    void reviseTeacher(@Param("reviseUser") ReviseUser reviseUser,@Param("id") int id);/////////////////////
}
