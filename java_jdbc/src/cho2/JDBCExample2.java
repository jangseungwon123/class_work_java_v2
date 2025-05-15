package cho2;

import java.sql.*;

public class JDBCExample2 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employees?serverTimezone=Asia/Seoul";
        String user = "root";
        String password = "asd1234";
        // String url ="jdbc:mysql://localhost;3306/employees?serverTimezone=Asia/Seoul";
        // String user = "root";
        // String password = "asd1234";


        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from dept_emp");
            // TODO rs = stmt.executeQuery(""); 안에 더 복잡한 코드도 넣을 수 있다.
            // TODO stmt.executeUpdate(); 업데이트 가능한 코드이다.
//            rs = stmt.executeQuery("select e.emp_no, e.first_name, s.salary, t.title\n" +
//                    "from employees as e\n" +
//                    "inner join salaries as s on e.emp_no = s.emp_no\n" +
//                    "inner join titles as t on e.emp_no = t.emp_no\n" +
//                    "where t.title = 'Senior Engineer' and e.first_name like 'ram%' and s.salary > 100000;\n");

            while (rs.next()) {
                int emp_no = rs.getInt("emp_no");
                String dept_no = rs.getString("dept_no");
                String from_date = rs.getString("from_date");
                String to_date = rs.getString("to_date");

                System.out.print("emp_no : " + emp_no + "\t");
                System.out.print("dept_no : " + dept_no + "\t");
                System.out.print("from_date : " + from_date + "\t");
                System.out.print("to_date : " + to_date + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // e.printStackTrace() 예외 발생 시 콘솔에 전체 스택 트레이스를 출력하여 디버깅에 도움을 줍니다.
            // 스택 트레이스(Stack Trace)는 예외가 발생했을 때 어디서,
            // 어떤 경로로 오류가 발생했는지를 보여주는 메서드 호출 기록 목록입니다
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("자원 해체중 오류 발생 : " + e.getMessage()); // ( e.getMessage()); 예외 발생 시 해당 예외의 상세 메시지를 반환합니다.)
            }
        }


    } // end of main
}
