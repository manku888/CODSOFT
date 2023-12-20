package task5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDQ {
    public static boolean insertStudentToDB(Student st) {
        boolean inserted = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "INSERT INTO students (sname, sphone, scity) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                inserted = true;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inserted;
    }

    public static boolean deleteStudent(int userId) {
        boolean deleted = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "DELETE FROM students WHERE sid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                deleted = true;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }

    public static void showAllStudents() {
        try {
            Connection con = ConnectionProvider.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                int id = rs.getInt("sid");
                String name = rs.getString("sname");
                String phone = rs.getString("sphone");
                String city = rs.getString("scity");
                System.out.println("ID: " + id + ", Name: " + name + ", Phone: " + phone + ", City: " + city);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean updateStudent(Student st) {
        boolean updated = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "UPDATE students SET sname=?, sphone=?, scity=? WHERE sid=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());
            pstmt.setInt(4, st.getStudentId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }
}

