import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;



public class Student{
    private int id;
    private String fname;
    private String lname;
    private String email;
    static Connection conn = Db.connect();
    public Student(int id, String fname, String lname, String email)
    {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public int getId() {return id;}
    public String getFname() {return fname;}
    public String getLname() {return lname;}
    public String getEmail() {return email;}

    public String toString()
    {
        return "[ID: " + id + ", First Name: " + fname + ", Last Name: " + lname + ", Email: " + email+"]";
    }



    public static void createStudentData(Student stu) throws SQLException
    {
        String query = Query.insert;
        PreparedStatement prStatement = conn.prepareStatement(query);
        prStatement.setInt(1, stu.getId());
        prStatement.setString(2, stu.getFname());
        prStatement.setString(3, stu.getLname());
        prStatement.setString(4, stu.getEmail());
        prStatement.executeUpdate();
        prStatement.close();
        System.out.println("Student created successfully\n"+stu);
    }

    public static ArrayList<Student> getStudentList() throws SQLException
    {
        ArrayList<Student> list = new ArrayList<Student>();
        String query = Query.select;
        Statement st = conn.createStatement();
        ResultSet set = st.executeQuery(query);
        while(set.next())
        {
            Student student = new Student(set.getInt(1), set.getString(2), set.getString(3), set.getString(4));
            list.add(student);
        }
        st.close();
        return list;
    }

    public static void updateStudentData(int id, String fname) throws SQLException
    {
        String query = Query.update;
        PreparedStatement prStatement = conn.prepareStatement(query);
        prStatement.setString(1, fname);
        prStatement.setInt(2, id);
        prStatement.executeUpdate();
        System.out.println("Student data Updated");
        prStatement.close();
    }

    public static void deleteStudentData(int id) throws SQLException
    {
        String query = Query.delete;
        PreparedStatement prStatement = conn.prepareStatement(query);
        prStatement.setInt(1, id);
        prStatement.executeUpdate();
        System.out.println("Student data Deleted");
        prStatement.close();
    }
}