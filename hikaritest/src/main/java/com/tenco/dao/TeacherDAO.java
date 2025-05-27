package com.tenco.dao;

import com.tenco.dto.Teacher;
import com.tenco.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    public List<Teacher> searchAllTeacher() throws SQLException {
        List<Teacher> teacherList = new ArrayList<>();
        String sql = "SELECT * from teacher ";
        try (
                Connection conn = DatabaseUtil.getConnection();
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int teacherPk = rs.getInt("teacher_pk");
                String teacherId = rs.getString("teacher_id");
                String teacherName = rs.getString("teacher_name");
                String teacherPhone = rs.getString("teacher_phone");
                String teacherEmail = rs.getString("teacher_email");
                Teacher teacher = new Teacher(teacherPk, teacherId, teacherName, teacherPhone, teacherEmail);
                teacherList.add(teacher);
            }
        }
        return teacherList;
    }

    public static void main(String[] args) {
        TeacherDAO teacherDAO = new TeacherDAO();
        try {
            System.out.println("DB 구현됨");
            teacherDAO.searchAllTeacher();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
