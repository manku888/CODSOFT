
package codsoft.student.manage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Statement;
import java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;

public class StudentDQ {
	
    public static boolean insterStudentToDB(Student st){
        boolean found= false;
        
        try {
            Connection con = ConnectionProvider.getConnection();
            // Dynamic Query
            String q= "insert into student(sname,sroll,sphone,scity,smarks) values(?,?,?,?,?)";
            
            // prepaeredStatement
           PreparedStatement pstmt =con.prepareStatement(q);
           
           // set the value of parameter
           pstmt.setString(1, st.getStudentName());
           pstmt.setString(3, st.getStudentPhone());
           pstmt.setString(4, st.getStudentCity());
           pstmt.setString(2, st.getStudentRollNumber());
           pstmt.setInt(5, st.getStudentMarks());
           
           // execute
           pstmt.executeLargeUpdate();
           found=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }

    public static boolean deleteStudent(int userId) {
        
        boolean found= false;
        try {
          Connection con=   ConnectionProvider.getConnection();
            
          String q = "delete from student where sid = ?";
          PreparedStatement pstms= con.prepareStatement(q);
          
          pstms.setInt(1, userId);
          
          pstms.executeLargeUpdate();
          found=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return found;
        
    }

    public static boolean showAllStudents() {
       
       boolean found= false;
        try {
             Connection con = ConnectionProvider.getConnection();
             String q= "Select * from student;";
            Statement smtp = con.createStatement();
            ResultSet set = smtp.executeQuery(q);
            
            while(set.next()){
                int id = set.getInt(1);
                String name= set.getNString("sname");
                String phone = set.getNString("sphone");
                String city = set.getNString("scity");
                String roll=set.getNString("sroll");
                int marks=set.getInt("smarks");
                
                System.out.println("studentID : "+ id );
                System.out.println("student Name : "+ name);
                System.out.println("Phone :" + phone);
                System.out.println("City :" + city);
                System.out.println("Roll Number :" + roll);
                System.out.println("Marks :" + marks);
                System.out.println("+++++++++++++++++++++++++++");
            }
            
        } catch (Exception e) {
        }
         return found;
    
    }

    public static void updateStudent() {
      
       
        try {
             Connection con = ConnectionProvider.getConnection();
             String q= "update student set sname=?, sroll=?, sphone=?, scity=?, smarks=? where sid = ? ";
             BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
             
             
             
             System.out.println("Enter your name : ");
             String name = br.readLine();
             
             System.out.println("Enter your RollNumber");
             String roll = br.readLine();
             
             System.out.println("Enter your phone : ");
             String phone = br.readLine();
             
             System.out.println("Enter your City");
             String city = br.readLine();
             
             System.out.println("Enter your Marks : ");
             int marks = Integer.parseInt(br.readLine());
             
             System.out.println("Enter your SId : ");
             int id = Integer.parseInt(br.readLine());
             
             
             
             PreparedStatement psmt = con.prepareStatement(q);
            
             psmt.setString(1, name);
             psmt.setString(2,roll);
             psmt.setString(3, phone);
             psmt.setString(4, city);
              psmt.setInt(5, marks);
              psmt.setInt(6, id);
             
            
             psmt.executeUpdate();
             
             System.out.println("updated.......");     
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean searchStudentByName(String name) {
        boolean found = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "SELECT * FROM student WHERE sname LIKE ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, "%" + name + "%"); // Using "%" to search for similar names

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("sid");
                String studentName = resultSet.getString("sname");
                String phone = resultSet.getString("sphone");
                String city = resultSet.getString("scity");
                String roll = resultSet.getString("sroll");
                int marks = resultSet.getInt("smarks");

                System.out.println("Student ID : " + id);
                System.out.println("Student Name : " + studentName);
                System.out.println("Phone : " + phone);
                System.out.println("City : " + city);
                System.out.println("Roll Number : " + roll);
                System.out.println("Marks : " + marks);
                System.out.println("+++++++++++++++++++++++++++");
                found = true; // Student found
            }
            if (!found) {
                System.out.println("No student found with the name: " + name);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }

    
    
}
