

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private static final String UID = "root";
    private static final String PASS = "root";

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, UID, PASS);

            String sql = "SELECT * FROM student";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setSl(rs.getInt("sl_no"));
                student.setName(rs.getString("name"));
                student.setDob(rs.getString("dob"));
                student.setEmail(rs.getString("email"));
                students.add(student);
                
                System.out.println("Fetched student: " + student.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }
}

