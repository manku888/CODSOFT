
package codsoft.student.manage;


public class Student {
    private int studentId;
    private String studentName;
    private String studentPhone;
    private String studentRollNumber;
    private  String studentCity;
    private  int studentMarks;
    
    public Student(int studentId, String studentName, String studentPhone,String studentRollNumber, String studentCity, int studentMarks ){
        super();
        this.studentId    =studentId;
        this.studentName  =studentName;
        this.studentPhone = studentPhone;
        this.studentCity  = studentCity;
        this.studentRollNumber  = studentRollNumber;
        this.studentMarks  = studentMarks;
    }
    public Student(String studentName, String studentPhone,String studentRollNumber, String studentCity, int studentMarks){
        super();
        this.studentName  =studentName;
        this.studentPhone = studentPhone;
        this.studentCity  = studentCity;
        this.studentRollNumber  = studentRollNumber;
        this.studentMarks  = studentMarks;
    }
    
    
    public Student(){
        super();
        
    }

    // getter and Setters
    
    public int getStudentId() {
    	return studentId;
    }
    public void setStudentId(int studentId) {
    	this.studentId = studentId;
    }
    public String getStudentName() {
    	return studentName;
    }
    public void setStudentName(String studentName) {
    	this.studentName = studentName;
    }
    public String getStudentPhone() {
    	return studentPhone;
    }
    public void setStudentPhone(String studentPhone) {
    	this.studentPhone = studentPhone;
    }
    public String getStudentRollNumber() {
    	return studentRollNumber;
    }
    public void setStudentRollNumber(String studentRollNumber) {
    	this.studentRollNumber = studentRollNumber;
    }
    public String getStudentCity() {
    	return studentCity;
    }
    public void setStudentCity(String studentCity) {
    	this.studentCity = studentCity;
    }
    public int getStudentMarks() {
    	return studentMarks;
    }
    public void setStudentMarks(int studentMarks) {
    	this.studentMarks = studentMarks;
    }

	
	
    
    
	
    
    
    

	
    
    
    
	 
	 
            
}
