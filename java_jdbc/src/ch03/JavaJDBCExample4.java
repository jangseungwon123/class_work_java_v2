package ch03;

import java.sql.*;

public class JavaJDBCExample4 {

    public static void main(String[] args) {

        // MySQL 서브접근 하기 - 주소 계정,비번
        String url = "jdbc:mysql://localhost:3306/school?serverTimezone=Asia/Seoul";
        String user = "root";
        String pwd = "asd1234";


        Connection con = null; //연결
        PreparedStatement pstmt = null;
        ResultSet rs = null; //결과 집합

        //try{} catch() {}
       // try(){} catch() {};
        //open JDK
       try(
               Connection conn = DriverManager.getConnection(url,user,pwd);
               PreparedStatement pstmt2 = conn.prepareStatement("select * from tb_student ");
               ResultSet rs2 = pstmt2.executeQuery()
       ){
           System.out.println("데이터베이스 연결 성공");
            while(rs.next()){
                String name = rs2.getString("name");
                int age = rs2.getInt("age");
            }

        } catch(Exception e) {
           throw new RuntimeException(e);
        }

    } // end of main
} // end of class
